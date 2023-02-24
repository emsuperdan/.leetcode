import java.util.Arrays;

public class ListTest10 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] arr = {{1,2,3},{4,5,6}};

        // int[] arr = new int[]{1};
        // int[] arr2 = new int[]{3,2,1,4,7};
        // String s="babad";
        System.out.println(minPathSum(arr));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //因为dp[0][0]就代表第一个格子的最小路径和
        //这里dp[m][n]就代表grid右下角(m,n)位置路径最小和
        //即最后只需要返回dp[m-1][n-1]即是(m,n)位置结果
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        //第一列的dp初始值
        int sumA = grid[0][0];
        for(int i = 1; i<m;i++){
            sumA += grid[i][0];
            dp[i][0] = sumA;
        }

        //第一行的dp初始值
        int sumB = grid[0][0];
        for(int j = 1; j<n;j++){
            sumB += grid[0][j];
            dp[0][j] += sumB;
        }

        for(int i =1 ;i<m ;i++){
            for(int j = 1;j<n;j++){
                //状态方程
                dp[i][j] = Math.min(dp[i][j-1]+grid[i][j], dp[i-1][j]+grid[i][j]);
            }
        }

        return dp[m-1][n-1];
    }
}
