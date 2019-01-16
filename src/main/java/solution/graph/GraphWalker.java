package solution.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class GraphWalker {

    public ArrayList<GNode> walkGraph(GNode node) {
        HashSet<GNode> nodes = new HashSet<>();
        return new ArrayList<>(walkGraph(node, nodes));
    }

    private HashSet<GNode> walkGraph(GNode node, HashSet<GNode> nodes) {
        if(nodes.contains(node)){
            return nodes;
        }

        nodes.add(node);

        if (node.getChildren().length == 0) {
            return nodes;
        }

        for (GNode n : node.getChildren()) {
            walkGraph(n, nodes);
        }

        return nodes;
    }

    public ArrayList<ArrayList<GNode>> paths(GNode node) {
        ArrayList<ArrayList<GNode>> paths = new ArrayList<>();

        return paths(node, paths, new ArrayList<>());
    }

    private ArrayList<ArrayList<GNode>> paths(GNode node, ArrayList<ArrayList<GNode>> paths,
                                              ArrayList<GNode> currentPath) {
        currentPath.add(node);

        if (node.getChildren().length == 0) {
            paths.add(currentPath);
            return paths;
        }

        for (GNode n : node.getChildren()) {
            paths(n, paths, new ArrayList<>(currentPath));
        }

        return paths;
    }
}

