package uppgift.uppgift2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GraphVertexIterator implements Iterator<Integer> {
    private int current = 0;
    private final int totalVertices;

    public GraphVertexIterator(int totalVertices) {
        this.totalVertices = totalVertices;
    }

    @Override
    public boolean hasNext() {
        return current < totalVertices;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more vertices.");
        }
        return current++;
    }
}
