import java.util.Arrays;

public class ListTest15 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] arr = {{1,2,3},{4,5,6}};

        // int[] arr = new int[]{1};
        int[] arr2 = new int[]{2,1,1,2};
        // String s="babad";
        System.out.println(minDistance("asdasd","qweasd"));
    }


    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //分别代表word1第m个字母位置上的最小 和 word2第n个字母位置上最小编辑距离
        int[][] dp = new int[m+1][n+1];
        //只有word1的边界情况
        for(int i = 1;i<=m; i++){
            dp[i][0] = dp[i-1][0] + 1;
        }
        //只有word2的边界情况
        for(int i = 1;i<=n; i++){
            dp[0][i] = dp[0][i-1] + 1;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                //状态方程:
                //eg:  word1:horse  word2:ros
                //当charAt(i-1) != charAt(j-1)时:
                //word1增字符操作:  dp[i][j] = dp[i-1][j] + 1;
                //word1删字符操作(其实是word2增字符操作):  dp[i][j] = dp[i][j-1] + 1;
                //word1改字符操作(其实是word1和word2都删字符后再增字符操作):  dp[i][j] = dp[i-1][j-1] + 1;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                }
            }
        }
        return dp[m][n];
    }
}
