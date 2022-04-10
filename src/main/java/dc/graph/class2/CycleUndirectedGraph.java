package dc.graph.class2;

import java.util.ArrayList;

public class CycleUndirectedGraph
{
    
    public static void main (String[] args)
    {
        System.out.println(cycleUndirectedGraph (5 , new int[][] {{1, 2}, {1, 3}, {2, 3}, {1, 4}, {4, 5}}));
        System.out.println(cycleUndirectedGraph (3 , new int[][] {{1, 2}, {1, 3}}));
        System.out.println(cycleUndirectedGraph (7 , new int[][] {{1, 2}, {2, 3}, {3, 1}, {2, 4}, {2, 5}, {2, 7}, {4, 6}, {5, 6}}));
        System.out.println(cycleUndirectedGraph (4 , new int[][] {{1 , 2} , {2 , 3} , {3 , 4}}));
        
    }
    public static int cycleUndirectedGraph (int A , int[][] B)
    {
        ArrayList <ArrayList <Integer>> graph = new ArrayList <> ();
        for (int i = 0 ; i < A + 1 ; i++) {
            graph.add (new ArrayList <> ());
        }
    
        for (int[] b : B) {
            graph.get (b[0]).add (b[1]);
        }
        
        boolean[] visited = new boolean[A + 1];
        for (int i = 1 ; i < A ; i++) {
            if (!visited[i]) {
                if (dfs (graph , i , visited , -1)) {
                    return 1;
                }
            }
        }
        return 0;
    }
    
    private static boolean dfs (ArrayList <ArrayList <Integer>> graph , int source , boolean[] visited, int parent)
    {
        
        visited[source] = true;
        
        for (int j = 0; j < graph.get (source).size (); j++) {
            int vertex = graph.get (source).get (j);
            if (!visited[vertex]) {
                if (dfs(graph, vertex, visited, source)) {
                    return true;
                }
            } else if (vertex != parent) {
                return true;
            }
        }
        return false;
    }
}
