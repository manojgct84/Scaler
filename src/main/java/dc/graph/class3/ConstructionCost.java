package dc.graph.class3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.
public class ConstructionCost
{
    //b[i][0] - Node
    //b[i][1] - Vertex
    //b[i][2] - Weight
    
    public static void main (String[] args)
    {
        System.out.println (minimumCostEveryNodeFromFirstNode (3 , new int[][] {{1 , 2 , 14} , {2 , 3 , 7} , {3 , 1 , 2}}));
    }
    
    public static int minimumCostEveryNodeFromFirstNode (int A , int[][] B)
    {
        List<Graph> graph = new ArrayList<>();
       
        for (int j = 0 ; j < B.length ; j++) {
            graph.add (new Graph (B[j][0] , B[j][1], B[j][2]));
        }
        
        int[] parent = new int[A + 1];
    
        for (int i = 0 ; i <= A ; i++) {
            parent[i] = i;
        }
        
        graph.sort(java.util.Comparator.comparingInt (o -> o.weight));
        int mod = 100000007;
        System.out.println (graph.toString ());
        long sum = 0;
        for (int i =0; i<graph.size (); i++) {
            Graph g = graph.get (i);
            if (find (g.edges, parent) != find (g.node, parent)) {
                if (union (g.node , g.edges , parent)) {
                    sum = ((sum % mod) + ((long) g.weight % mod)) % mod;
                }
            }
        }
        return (int) sum;
    }
    
    private static boolean union (int node , int edges , int[] parent)
    {
        int rootX = find (node, parent);
        int rootY = find (edges, parent);
        if (rootX == rootY) return false;
        parent[rootX] = rootY;
        return true;
    }
    
    private static int find (int node , int[] parent)
    {
       /* while (node != parent[node] ) {
            node = parent[node];
        }
        return node;*/
        
        if (node == parent[node]) return node;
        parent[node] = find (parent[node], parent);
        return parent[node];
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
