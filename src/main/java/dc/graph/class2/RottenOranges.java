package dc.graph.class2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RottenOranges
{
    
    public static void main (String[] args)
    {
        System.out.println (rottenOranges (new int[][] {{2 , 1 , 1} , {1 , 1 , 0} , {0 , 1 , 1}}));
        System.out.println (rottenOranges (new int[][] {{2 , 1 , 1} , {0 , 1 , 1} , {1 , 0 , 1}}));
    }
    
    static Queue<Pair> q;
    public static int rottenOranges (int[][] matrix)
    {
        int[][] solution = new int[matrix.length][matrix[0].length];
        for (int i = 0 ; i < solution.length ; i++) {
            Arrays.fill (solution[i] , -1);
        }
        q = new ArrayDeque <> ();
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                if (matrix[i][j] == 2) {
                    q.add (new Pair (i, j));
                    solution[i][j] = 0;
                }  else if (matrix[i][j] == 0) {
                    solution[i][j] = 0;
                }
            }
        }
        return  bfs(matrix, solution);
    }
    
    private static int bfs (int[][] matrix , int[][] solution)
    {
        int[][] direct = {{0 , 1} , {1 , 0} , {0 , -1} , {-1 , 0}};
        while (!q.isEmpty ()) {
              Pair pair = q.poll ();
            for (int i = 0 ; i < direct.length ; i++) {
                int new_x = pair.x + direct[i][0];
                int new_y = pair.y + direct[i][1];
                if (getDirection(new_x, new_y, matrix) &&
                    matrix[new_x][new_y] == 1 &&
                    solution[new_x][new_y] == -1)
                {
                    q.add (new Pair (new_x , new_y));
                    solution[new_x][new_y] = solution[pair.x][pair.y] + 1;
                }
            }
            
           /* if (getDirection( pair.x + 1, pair.y, matrix)  && matrix[pair.x + 1][pair.y] == 1 && solution[pair.x + 1][pair.y] == -1) {
                q.add (new Pair (pair.x + 1 , pair.y));
                solution[pair.x + 1][pair.y] = solution[pair.x][pair.y] + 1;
            }
    
            if (getDirection( pair.x , pair.y + 1, matrix)  && matrix[pair.x][pair.y + 1] == 1 && solution[pair.x][pair.y + 1] == -1) {
                q.add (new Pair (pair.x, pair.y + 1));
                solution[pair.x][pair.y + 1] = solution[pair.x][pair.y] + 1;
            }
            
            if (getDirection( pair.x , pair.y - 1, matrix)  && matrix[pair.x][pair.y - 1] == 1 && solution[pair.x][pair.y - 1] == -1) {
                q.add (new Pair (pair.x, pair.y - 1));
                solution[pair.x][pair.y - 1] = solution[pair.x][pair.y] + 1;
            }
            if (getDirection( pair.x - 1, pair.y, matrix)  && matrix[pair.x - 1][pair.y] == 1 && solution[pair.x - 1][pair.y] == -1) {
                q.add (new Pair (pair.x  - 1, pair.y));
                solution[pair.x - 1][pair.y] = solution[pair.x][pair.y] + 1;
            }*/
        }
        System.out.println (Arrays.deepToString (solution));
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < solution.length ; i++) {
            for (int j = 0 ; j < solution[0].length ; j++) {
                if (solution[i][j] == -1) {
                    return  -1;
                }
                max = Math.max (max , solution[i][j]);
            }
        }
        return max;
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
