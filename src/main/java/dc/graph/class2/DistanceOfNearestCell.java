package dc.graph.class2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DistanceOfNearestCell
{
    public static void main (String[] args)
    {
        System.out.println(Arrays.deepToString(distanceOfNearestCell(new int[][] {{0, 0, 0, 1} ,
                        {0, 0, 1, 1} , {0, 1, 1, 0}})));
        System.out.println(Arrays.deepToString(distanceOfNearestCell(new int[][] {{1, 0, 0} ,
                        {0, 0, 0} , {0, 0, 0}})));
    }
    
    static Queue <Pair> q;
    public static int[][] distanceOfNearestCell(int[][] matrix) {
        q = new ArrayDeque <> ();
        int[][] solution = new int[matrix.length][matrix[0].length];
    
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                if (matrix[i][j] == 1) {
                    q.add (new Pair (i,j));
                } else {
                    solution[i][j] = Integer.MAX_VALUE;
                }
            }
            
        }
        return bfs(matrix, solution);
    }
    
    private static int[][] bfs (int[][] matrix , int[][] solution)
    {
        int[][] direction = {{0 , 1} , {1 , 0} , {-1 , 0} , {0 , -1}};
        
        while (!q.isEmpty ()) {
            Pair pair = q.poll ();
            //constant iteration
            for (int i = 0 ; i < direction.length ; i++) {
                int new_x = pair.x + direction[i][0];
                int new_y = pair.y + direction[i][1];
                if (getDirection(new_x, new_y, matrix)) {
                   // System.out.println ("solution " + solution[new_x][new_y] + " > " + solution[pair.x][pair.y]);
                     if (solution[new_x][new_y] > solution[pair.x][pair.y]) {
                         solution[new_x][new_y] = solution[pair.x][pair.y]  + 1;
                      // System.out.println ("New Value " + solution[new_x][new_y]);
                         q.add (new Pair (new_x , new_y));
                     }
                }
            }
        }
       // System.out.println (Arrays.deepToString (solution));
        return solution;
    }
    
    private static boolean getDirection(int x , int y , int[][] matrix) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }
    static class Pair
    {
        int x;
        int y;
        
        Pair (int x , int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
