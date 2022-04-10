package dc.graph.class1;

public class NumberOfIslands
{
    public static void main (String[] args)
    {
        System.out.println (numberOfIslands (new int[][] {{1 , 1 , 0 , 0 , 0} ,
                        {0 , 1 , 0 , 0 , 0} , {1 , 0 , 0 , 1 , 1} , {0 , 0 , 0 , 0 , 0} ,
                        {1 , 0 , 1 , 0 , 1}}));
    }
    
    public static int numberOfIslands (int[][] mat)
    {
        int count = 0;
        for (int i = 0 ; i < mat.length ; i++) {
            for (int j = 0 ; j < mat[0].length ; j++) {
                if (mat[i][j] == 1) {
                    count++;
                    dfs (mat , i , j);
                }
            }
        }
        return count;
    }
    
    static int[] dx = {1 , -1 , 0 , 0 , -1 , -1 , 1 , 1};
    static int[] dy = {0 , 0 , 1 , -1 , 1 , -1 , 1 , -1};
    
    private static void dfs (int[][] mat , int i , int j)
    {
        mat[i][j] = 0;
        
        for (int k = 0 ; k < 8 ; k++) {
            int new_i = i + dx[k];
            int new_j = j + dy[k];
            if (new_i > -1 && new_j > -1 && new_i < mat.length && new_j < mat[0].length && mat[new_i][new_j] == 1) {
                dfs (mat , new_i , new_j);
            }
        }
    }
}
