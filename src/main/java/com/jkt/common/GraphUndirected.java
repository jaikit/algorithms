package com.jkt.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GraphUndirected {

    int vertices;
    ArrayList<ArrayList<Integer>> adjList;

    public GraphUndirected(final int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<ArrayList<Integer>>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(final int src, final int dest) {
        /* boundary check missing. */
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public Collection<Integer> getAdjacencyList(final int vertex) {
        return Collections.unmodifiableCollection(adjList.get(vertex));
    }
}
