package dc.graph.class1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PathDirectedGraph
{
    public static void main (String[] args)
    {
        
        System.out.println (pathDirectedGraph (5 ,
                                               new int[][] {{1 , 2} , {4 , 1} , {2 , 4} , {3 , 4} ,
                                                               {5 , 2} , {1 , 3}}));
        
        System.out.println (pathDirectedGraph (5 ,
                                               new int[][] {{1 , 2} , {2 , 3} , {3 , 4} ,
                                                               {4 , 5}}));
    }
    
    public static int pathDirectedGraph (int A , int[][] B)
    {
        boolean[] visited = new boolean[A + 1];
        ArrayList <ArrayList <Integer>> adjList = new ArrayList <> ();
        convertToAdjList (A , B , adjList);
        return bfs (visited , adjList , A);
    }
    
    private static int bfs (boolean[] visited , ArrayList <ArrayList <Integer>> adjList , int a)
    {
        Queue <Integer> q = new ArrayDeque <> ();
        q.add (1);
        visited[1] = true;
        
        while (!q.isEmpty ()) {
            int v = q.poll ();
            for (int i = 0 ; i < adjList.get (v).size () ; i++) {
                if (!visited[adjList.get (v).get (i)]) {
                    visited[adjList.get (v).get (i)] = true;
                    q.add (adjList.get (v).get (i));
                }
            }
        }
        return visited[a] ? 1 : 0;
    }
    
    private static void convertToAdjList (int a , int[][] b , ArrayList <ArrayList <Integer>> adjList)
    {
        
        for (int i = 1 ; i <= a + 1 ; i++) {
            adjList.add (new ArrayList <> ());
        }
        
        for (int i = 0 ; i < b.length ; i++) {
            adjList.get (b[i][0]).add (b[i][1]);
        }
    }
}
