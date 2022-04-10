package dc.graph.class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
//
//Given 2 towns find whether you can reach the first town from the second without repeating any edge.
public class FirstDepthFirstSearch
{
    
    public static void main (String[] args)
    {
        System.out.println (firstDepthFirstSearch (new ArrayList <> (Arrays.asList (1 ,
                                                                                    1 ,
                                                                                    2)) , 1 , 2));
        System.out.println (firstDepthFirstSearch (new ArrayList <> (Arrays.asList (1 ,
                                                                                    1 ,
                                                                                    2)) , 2 , 1));
    }
    
    public static int firstDepthFirstSearch (ArrayList <Integer> A , final int B , final int C)
    {
        if (A.size () == 1 && B == 1 && C == 1) {
            if (A.get (0) == B) {
                return 1;
            }
        
            return 0;
        }
        ArrayList <ArrayList <Integer>> graph = new ArrayList <> ();
        for (int i = 0 ; i < A.size () ; i++) {
            graph.add (new ArrayList <> ());
        }
        
        for (int i = 0 ; i < A.size () ; i++) {
            graph.get (A.get (i)).add (i + 1);
        }
        return dfs (graph , B , C);
        
    }
    
    private static int dfs (ArrayList <ArrayList <Integer>> a , int b , int c)
    {

        Stack <Integer> s = new Stack <> ();
        boolean[] visited = new boolean[a.size () + 1];
        Arrays.fill (visited , false);
        s.add (c);
        visited[c] = true;
        while (!s.isEmpty ()) {
            int v = s.pop ();
            if (v == b) {
                return 1;
            }
            if (v < a.size ()) {
                for (int i = 0 ; i < a.get (v).size () ; i++) {
                    if (!visited[a.get (v).get (i)]) {
                        visited[a.get (v).get (i)] = true;
                        s.add (a.get (v).get (i));
                    }
                }
            }
        }
        return 0;
    }
}
