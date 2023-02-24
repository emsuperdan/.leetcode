import java.util.Arrays;

public class ListTest13 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] arr = {{1,2,3},{4,5,6}};

        // int[] arr = new int[]{1};
        int[] arr2 = new int[]{2,1,1,2};
        // String s="babad";
        System.out.println(longestCommonSubsequence("abc","def"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                //状态转移 注意是取index-1位置的值
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }





        // for (int i = n - 1; i >= 0; i--) {
        //     for (int j = m - 1; j >= 0; j--) {
        //         if(text1.indexOf(i) == text2.indexOf(j) ){
        //             dp[i][j] = dp[i + 1][j + 1] + 1;
        //         }else{
        //             dp[i][j] = Math.
        //         }
        //         ans = Math.max(ans, dp[i][j]);
        //     }
        // }
        // return ans;
}
