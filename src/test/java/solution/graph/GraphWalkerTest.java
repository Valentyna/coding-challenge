package solution.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphWalkerTest {

    private static final GNode J = new Node("J", new GNode[]{});
    private static final GNode D = new Node("D", new GNode[]{J});
    private static final GNode I = new Node("I", new GNode[]{});
    private static final GNode H = new Node("H", new GNode[]{});
    private static final GNode G = new Node("G", new GNode[]{});
    private static final GNode C = new Node("C", new GNode[]{G, H, I});
    private static final GNode F = new Node("F", new GNode[]{C});
    private static final GNode E = new Node("E", new GNode[]{});
    private static final GNode B = new Node("B", new GNode[]{E, F});
    private static final GNode A = new Node("A", new GNode[]{B, C, D});



    private final GraphWalker service = new GraphWalker();

    @Test
    public void testWalk() {
        List<GNode> actual = service.walkGraph(A);
        List<GNode> expected = Arrays.asList(A, B, E, F, C, G, H, I, D, J);

        Assert.assertTrue(actual.size() == expected.size()
                && actual.containsAll(expected)
                && expected.containsAll(actual));
    }

    @Test
    public void testPath() {
        ArrayList<ArrayList<GNode>> actual = service.paths(A);

        List<List<GNode>> expected = Arrays.asList(
                Arrays.asList(A, B, E),
                Arrays.asList(A, B, F, C, G),
                Arrays.asList(A, B, F, C, H),
                Arrays.asList(A, B, F, C, I),
                Arrays.asList(A, C, G),
                Arrays.asList(A, C, H),
                Arrays.asList(A, C, I),
                Arrays.asList(A, D, J)
        );

        Assert.assertEquals(expected, actual);
    }
}

