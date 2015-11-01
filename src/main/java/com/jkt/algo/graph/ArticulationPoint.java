package com.jkt.algo.graph;

import com.jkt.common.GraphUndirected;

public class ArticulationPoint {

    public static void main(final String args[]) {

        final ArticulationPoint articulationPoint = new ArticulationPoint();
        final GraphUndirected graphUndirected = new GraphUndirected(5);
        graphUndirected.addEdge(1, 0);
        graphUndirected.addEdge(1, 2);
        graphUndirected.addEdge(0, 2);
        graphUndirected.addEdge(0, 3);
        graphUndirected.addEdge(3, 4);

        articulationPoint.findPoints(graphUndirected, 5);

    }

    private void findPoints(final GraphUndirected graphUndirected, final int vertices) {
        final int[] articulationPoint = new int[5];
        final int root = 0;
        final int[] discovery = new int[5];
        final int[] low = new int[5];
        final int[] visited = new int[5];
        final int[] parent = new int[5];
        final Integer level = 0;
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        parent[root] = -2;

        dfs(graphUndirected, articulationPoint, root, discovery, low, visited, parent, level);
        for (int i = 0; i < vertices; i++) {

            System.out.println(articulationPoint[i]);
        }
    }

    private void dfs(final GraphUndirected graphUndirected, final int[] articulationPoint, final int root, final int[] discovery, final int[] low,
            final int[] visited, final int[] parent, Integer level) {
        int childer = 0;
        visited[root] = 1;
        level = level + 1;

        discovery[root] = low[root] = level;
        for (final Integer neighbors : graphUndirected.getAdjacencyList(root)) {

            if (visited[neighbors] != 1) {
                childer = childer + 1;
                parent[neighbors] = root;
                dfs(graphUndirected, articulationPoint, neighbors, discovery, low, visited, parent, level);

                low[root] = Math.min(low[neighbors], low[root]);

                if ((parent[root] == -2) && (childer > 1)) {
                    articulationPoint[root] = 1;
                }

                if ((parent[root] != -2) && (low[neighbors] > low[root])) {
                    articulationPoint[root] = 1;
                }

            } else {
                if (parent[root] != neighbors) {
                    low[root] = Math.min(low[neighbors], discovery[root]);
                }
            }
        }
    }
}
