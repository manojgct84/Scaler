package dc.graph.class2;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructRoads
{
    
    public static void main (String[] args)
    {
        System.out.println (constructRoads (3 ,
                                            new int[][] {{1 , 2},{1,3}}));
        System.out.println (constructRoads (5 ,
                                            new int[][] {{1 , 3} , {1 , 4} , {3 , 2}, {3 , 5}}));
        
    }
    
    public static int constructRoads (int A , int[][] matrix)
    {
        Graph[] graphs = new Graph[A + 1];
        for (int i = 1 ; i <= A ; i++) {
            graphs[i] = new Graph ();
            graphs[i].vertex = new ArrayList<> ();
        }
        
        for (int i = 0 ; i < matrix.length ; i++) {
            graphs[matrix[i][0]].vertex.add (matrix[i][1]);
            graphs[matrix[i][1]].vertex.add (matrix[i][0]);
        }
        int[] color = new int[A + 1];
        Arrays.fill (color, -1);
        color[1] = 0;
        checkBipartiteGraphDFS (graphs , 1, color);
        
        int set1 = 0, set2 =0;
    
        for (int i = 1 ; i < color.length ; i++) {
            if (color[i] == 0) {
                set1++;
            }
            else {
                set2++;
            }
        }
        int mod = 1000000007;
        System.out.println (Arrays.toString (color));
        int totalAlreadyPresent = (set1 % mod * set2 % mod) % mod;
        return totalAlreadyPresent - matrix.length;
    }
    
    private static void checkBipartiteGraphDFS (Graph[] graphs , int source , int[] color)
    {
        ArrayList<Integer> edges = graphs[source].vertex;
        for (Integer vertex : edges) {
            if (color[vertex] == -1) {
                color[vertex] = color[source] == 0 ? 1 : 0;
                checkBipartiteGraphDFS (graphs , vertex , color);
            }
        }
    }
    
    static class Graph
    {
        ArrayList <Integer> vertex;
    }
}
