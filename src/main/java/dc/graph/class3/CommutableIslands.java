package dc.graph.class3;

/**
 * There are A islands and there are M bridges connecting them.
 * Each bridge has some cost attached to it.
 * We need to find bridges with minimal cost such that all islands are connected.
 * It is guaranteed that input data will contain at least one possible scenario
 * in which all islands are connected with each other.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
public class CommutableIslands
{
    //b[i][0] - Node
    //b[i][1] - Vertex
    //b[i][2] - Weight
    
    public static void main (String[] args)
    {
        System.out.println (commutableIslands (4 , new int[][] {{1, 2, 1} , {2, 3, 4} , {1, 4, 3} , {4, 3, 2}, {1, 3, 10}}));
    }
    
    public static int commutableIslands (int A , int[][] B)
    {
        boolean[] visited = new boolean[A + 1];
        ArrayList<ArrayList<Graph>> graph = new ArrayList <> ();
        constructAdjList(B, graph, A);
        PriorityQueue <Graph> minHeap = new PriorityQueue <> (java.util.Comparator.comparingInt (o -> o.weight));
        minHeap.add (new Graph(1,1,0) );
        int totalCost = 0;
        while (!minHeap.isEmpty ()) {
            Graph g = minHeap.poll ();
            if (!visited[g.edges]) {
                visited[g.edges] = true;
                totalCost = totalCost + g.weight;
                for (Graph grp : graph.get (g.edges)) {
                    if (!visited[grp.node] || !visited[grp.edges]) {
                        minHeap.add (grp);
                    }
                }
            }
        }
          return totalCost;
    }
    
    private static void constructAdjList (int[][] b , ArrayList <ArrayList <Graph>> graph , int edges)
    {
        for (int i = 0 ; i <= edges ; i++) {
            graph.add (new java.util.ArrayList <> ());
        }
    
        for (int i = 0 ; i < b.length ; i++) {
            graph.get (b[i][0]).add (new Graph (b[i][0] , b[i][1] , b[i][2]));
            graph.get (b[i][1]).add (new Graph (b[i][1] , b[i][0] , b[i][2]));
        }
    }
    
    static class Graph
    {
        @Override
        public String toString ()
        {
            return "Graph{" + "node=" + node + ", edges=" + edges + ", weight=" + weight + '}';
        }
        
        int node;
        int edges;
        int weight;;
        
        Graph (int node , int edges , int weight)
        {
            this.node = node;
            this.edges = edges;
            this.weight = weight;
        }
    }
}
