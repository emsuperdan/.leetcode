import java.util.Arrays;

public class ListTest11 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] arr = {{1,2,3},{4,5,6}};

        // int[] arr = new int[]{1};
        // int[] arr2 = new int[]{3,2,1,4,7};
        // String s="babad";
        System.out.println(uniquePaths(3,7));
    }


    public static int uniquePaths(int m, int n) {
        //因为dp[0][0]就代表第一个格子的不同路径结果
        //这里dp[m][n]就代表grid右下角(m,n)位置不同路径结果和
        //即最后只需要返回dp[m-1][n-1]即是(m,n)位置结果
        int[][] dp = new int[m][n];
        //init data
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }

        for(int j = 0;j<n;j++){
            dp[0][j] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j = 1;j<n;j++){
                //状态方程
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.println(dp[m-1][n-1]);
        return dp[m-1][n-1];
    }
}
