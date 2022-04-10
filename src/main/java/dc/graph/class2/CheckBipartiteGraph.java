package dc.graph.class2;

import java.util.ArrayList;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class CheckBipartiteGraph
{
    public static void main (String[] args)
    {
        System.out.println (checkBipartiteGraph (2 , new int[][] {{0 , 1}}));
        System.out.println (checkBipartiteGraph (3 , new int[][] {{0 , 1} , {0 , 2} , {1 , 2}}));
        System.out.println (checkBipartiteGraph (9 , new int[][] {{1 , 7} , {0 , 5} , {6 , 7} , {0 , 6}}));
    
    }
    
    static int size = 0;
    static int[] color;
    
    public static int checkBipartiteGraph (int A , int[][] B)
    {
        
        ArrayList <ArrayList <Integer>> graph = new ArrayList <> ();
        
        for (int i = 0 ; i < A ; i++) {
            graph.add (new ArrayList <> ());
        }
        
        for (int i = 0 ; i < B.length ; i++) {
            graph.get(B[i][0]).add(B[i][1]);
            graph.get(B[i][1]).add(B[i][0]);
        }
        
        size = A;
        color = new int[A];
        Arrays.fill (color , -1);
        
        for (int i = 0 ; i < size ; i++) {
            if (color[i] == -1) {
                color[i] = 1;
                if (!checkBipartiteGraphDFS (graph , i)) {
                    return 0;
                }
            }
        }
        return 1;
    }
    
    private static boolean checkBipartiteGraphDFS (@NotNull ArrayList <ArrayList <Integer>> graph , int v)
    {
        for (int i = 0 ; i < graph.get (v).size () ; i++)
        {
            int vertex = graph.get (v).get (i);
            if (color[vertex] == -1)
            {
                color[vertex] = color[v] == 0 ? 1 : 0;
                if (!checkBipartiteGraphDFS (graph , vertex)) {
                    return false;
                }
            }
            else if (color[vertex] == color[v])
            {
                return false;
            }
        }
        return true;
    }
}
