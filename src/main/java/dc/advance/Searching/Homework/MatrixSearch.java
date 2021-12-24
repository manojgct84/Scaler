package dc.advance.Searching.Homework;

public class MatrixSearch {

    public static void main(String[] args) {
        System.out.println(getSearchMatrix(new int[][]{{0}}, 1));

        System.out.println(getSearchMatrix(new int[][]{
                {
                        1, 3, 5, 7
                },
                {
                        10, 11, 16, 20
                },
                {
                        23, 30, 34, 50
                }
        }, 3));

    }

    public static int getSearchMatrix(int[][] A, int B) {

        if (A.length == 0) {
            return -1;
        }

        int i = 0;
        int j = A[0].length - 1;

        while (i < A.length && j >= 0) {

            if (A[i][j] < B) {
                i++;
            } else if (A[i][j] > B) {
                j--;
            } else if (A[i][j] == B) {
                return 1;
            }

        }
        return 0;

    }

    //This is from the HINT
    public int searchMatrix(int[][] A, int B) {
        int n = A.length, m = A[0].length;
        //assume all elements are added to a list and after that it is sorted
        //last index will be n * m - 1
        int low = 0, high = n * m - 1, ans = -1;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            int row = mid / m, col = mid % m;
            if(A[row][col] > B)
                high = mid - 1;
            else{
                ans = mid;
                low = mid + 1;
            }
        }
        if(ans == -1 || A[ans / m][ans % m] != B)
            return 0;
        return 1;
    }

}
