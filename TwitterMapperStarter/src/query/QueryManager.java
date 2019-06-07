package query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueryManager implements Iterable<Query>{
    private List<Query> queries = new ArrayList<>();

    /**
     * This query is no longer interesting, so terminate it and remove all traces of its existence.
     *
     * TODO: Implement this method
     */
    public void terminate(Query query) {
    queries.remove(query);
    }

    @Override
    public Iterator<Query> iterator() {
        return queries.iterator();
    }

    public void addQuery(Query query)
    {
        queries.add(query);
    }
}
