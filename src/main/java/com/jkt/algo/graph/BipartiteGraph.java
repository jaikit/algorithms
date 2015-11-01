package com.jkt.algo.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.jkt.common.GraphUndirected;

public class BipartiteGraph {

    public static void main(final String args[]) {

        final BipartiteGraph bipartiteGraph = new BipartiteGraph();
        final GraphUndirected graphUndirected = new GraphUndirected(5);
        graphUndirected.addEdge(0, 2);
        graphUndirected.addEdge(1, 3);
        graphUndirected.addEdge(2, 3);
        graphUndirected.addEdge(2, 4);

        bipartiteGraph.print2Color(graphUndirected, 5);

    }

    private void print2Color(final GraphUndirected graphUndirected, final int totalVertices) {

        final int red[] = new int[totalVertices];
        final int blue[] = new int[totalVertices];
        boolean isBipartite = true;
        for (int i = 0; i < totalVertices; i++) {
            red[i] = -1;
            blue[i] = -1;
        }

        final boolean visited[] = new boolean[totalVertices];
        final Queue<Holder> queue = new LinkedList<>();
        queue.add(new Holder(0, red));
        while (queue.isEmpty() == false) {
            final Holder holder = queue.poll();
            if (visited[holder.vertex] == false) {
                visited[holder.vertex] = true;
                holder.color[holder.vertex] = 1;
                for (final Integer edge : graphUndirected.getAdjacencyList(holder.vertex)) {
                    queue.add(new Holder(edge, holder.color == red ? blue : red));
                }
            } else {
                if (holder.color[holder.vertex] == -1) {
                    isBipartite = false;
                    break;
                }
            }
        }

        if (isBipartite) {
            for (int i = 0; i < totalVertices; i++) {
                if (red[i] != -1) {
                    System.out.println("RED: " + i);
                }
            }
            for (int i = 0; i < totalVertices; i++) {
                if (blue[i] != -1) {
                    System.out.println("BLUE: " + i);
                }
            }

        } else {
            System.out.println("Not ");
        }
    }

    class Holder {
        int vertex;
        int color[];

        Holder(final int vertex, final int color[]) {
            this.vertex = vertex;
            this.color = color;
        }
    }
}
