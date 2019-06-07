package ui;

import query.Query;
import twitter.PlaybackTwitterSource;
import twitter.TwitterSource;
import ui.ContentPanel;

import java.util.*;

public class QueryManager implements Iterable<Query>{
    private List<Query> queries = new ArrayList<>();
    private TwitterSource twitterSource;
    private ContentPanel contentPanel;

    public QueryManager(ContentPanel contentPanel) {
        this.contentPanel=contentPanel;
        twitterSource = new PlaybackTwitterSource(60.0);
    }

    // The source of tweets, a TwitterSource, either live or playback




    @Override
    public Iterator<Query> iterator() {
        return queries.iterator();
    }


    /**
     * A new query has been entered via the User Interface
     * @param   query   The new query object
     */
    public void addQuery(Query query) {
        queries.add(query);
        Set<String> allterms = getQueryTerms();
        twitterSource.setFilterTerms(allterms);
        contentPanel.addQuery(query);
        // TODO: This is the place where you should connect the new query to the twitter source
        twitterSource.addObserver(query);
    }

    /**
     * return a list of all terms mentioned in all queries. The live twitter source uses this
     * to request matching tweets from the Twitter API.
     * @return
     */
    private Set<String> getQueryTerms() {
        Set<String> ans = new HashSet<>();
        for (Query q : queries) {
            ans.addAll(q.getFilter().terms());
        }
        return ans;
    }
    /**
     * This query is no longer interesting, so terminate it and remove all traces of its existence.
     *
     * TODO: Implement this method
     */

    public void terminateQuery(Query query) {
        // TODO: This is the place where you should disconnect the expiring query from the twitter source
        queries.remove(query);
        Set<String> allterms = getQueryTerms();
        twitterSource.setFilterTerms(allterms);

        twitterSource.deleteObserver(query);
    }
}
