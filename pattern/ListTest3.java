
public class ListTest3 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        String s="babad";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        //可以涵盖所有的结果；
        boolean[][] dp = new boolean[s.length()][s.length()];
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
