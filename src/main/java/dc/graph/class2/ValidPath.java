package dc.graph.class2;

public class ValidPath
{
    public static void main (String[] args)
    {
        System.out.println (validPath (2 , 3 , 1 , 1 , new int[] {2} , new int[] {3}));
        System.out.println (validPath (1 , 1 , 1 , 1 , new int[] {1} , new int[] {1}));
    }
    
    static String res = "NO";
    public static String validPath (int A , int B , int C , int D , int[] E , int[] F)
    {
        int[][] matrix = new int[A + 1][B + 1];
        res = "NO";
        for (int i = 0 ; i <= A ; i++) {
            for (int j = 0 ; j <= B ; j++) {
                int val = 1;
                for (int k = 0 ; k < C ; k++) {
                    int di = (int) (Math.pow (i - E[k] , 2) + Math.pow (j - E[k] , 2));
                    if ((D * D) > di) {
                        val = 0;
                        break;
                    }
                }
                matrix[i][j] = val;
            }
        }
         if (matrix[0][0] ==0 || matrix[A][B] ==0) {
             return res;
         }
         
         boolean[][]  visited = new boolean[A + 1][B + 1];
         dfs(matrix,visited, 0 , 0);
         return res;
    }
    
    static int[][] direct =  {{0 , 1} , {1 , 0} , {0 , -1} , {-1 , 0}, {-1, - 1}, {1, 1}, {-1, 1}, {1, - 1}};
    private static void dfs (int[][] matrix , boolean[][] visited , int i , int j)
    {
        if (!validDirections (i , j , matrix, visited)) {
            return;
        }
        
        if (i == matrix.length && j == matrix[0].length) {
            res = "YES";
            return;
        }
        visited[i][j] = true;
    
        
    /*    dfs (matrix , visited , i + 1 , j); //down
        dfs (matrix , visited , i , j + 1); //right
        dfs (matrix , visited , i - 1 , j); // up
        dfs (matrix , visited , i , j - 1); // left
        dfs (matrix , visited , i - 1 , j - 1); // up diagonal
        dfs (matrix , visited , i + 1 , j + 1); // down diagonal
        dfs (matrix , visited , i - 1 , j + 1); // right diagonal
        dfs (matrix , visited , i + 1 , j - 1); // left diagonal */
    
        for (int e = 0 ; e < direct.length ; e++) {
             dfs (matrix,visited, i + direct[e][0],j + direct[e][1]);
        }
    }
    
    private static boolean validDirections(int x , int y , int[][] matrix, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && !visited[x][y] && matrix[x][y] == 1;
    }
}
