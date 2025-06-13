import java.util.Arrays;

public class UniquePaths {
    public int helpFunc(int m, int n, int row, int col, int[][] memo) {
        if(row == m-1 && col == n-1)
        {
            return 1;
        }
        else if(row >= m || col >= n){
            return 0;
        }
        
        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        memo[row][col] =  helpFunc(m, n, row+1, col,memo) + helpFunc(m, n, row, col+1,memo);
        return memo[row][col];
    }
    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return helpFunc(m,n,0,0,memo);
    }
}

