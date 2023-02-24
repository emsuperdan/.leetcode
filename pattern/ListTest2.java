
public class ListTest2 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        int[] dp=new int[46];
        for(int i = 0;i<=45;i++){
            dp[i] = -1;
        }
        getSubClimbStairs(n,n, dp);
        return dp[n];
    }

    public static int getSubClimbStairs(int n, int left, int[] dp){
        if(left>=0 && dp[left]!=-1){
            return dp[left];
        }

        int ans = 0;
        if(left <= 2){
            ans = left;
            dp[left] = ans;
            return ans;
        }

        ans = getSubClimbStairs(n, left - 1, dp) + getSubClimbStairs(n, left-2, dp); 
        dp[left] = ans;
        return ans;
    }
}
