
public class ListTest4 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        String s="babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        countSubstrings(s, dp);
        
        int maxLength = 1;
        int index = 0;
        int curLength = 0;
        for(int j = 0;j<s.length();j++){
            curLength =0;
            for(int i=0;i<=j;i++){
                if(dp[i][j]){
                    curLength = j-i + 1;
                }
                if(maxLength < curLength){
                    maxLength = curLength;
                    index = i;
                }
            }
        }

        return s.substring(index, index + maxLength);
    }

    public static int countSubstrings(String s, boolean[][] dp) {
        int ans = 0;

        //指针从最右边开始往左
        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                //j-i<2表示相邻字符则一定为回文
                //或 缓存中的dp[i+1][j-1]为true表示除i和j位置，i和j之间的位置也为回文
                if(s.charAt(i) == s.charAt(j) && (j-i<2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}
