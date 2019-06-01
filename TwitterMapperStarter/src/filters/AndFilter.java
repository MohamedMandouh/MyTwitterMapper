package filters;

import twitter4j.Status;

import java.io.File;
import java.util.List;

public class AndFilter implements  Filter
{
    Filter leftChild;
    Filter rightChild;

    public AndFilter(Filter child1 , Filter child2 )
    {
        leftChild=child1;
        rightChild=child2;
    }
    @Override
    public boolean matches(Status s) {
        return leftChild.matches(s) && rightChild.matches(s);
    }

    @Override
    public List<String> terms() {
        return null;
    }

    @Override
    public String toString() {
        return "(" +
                 leftChild +
                " and "
                + rightChild +
                ")";
    }
}
