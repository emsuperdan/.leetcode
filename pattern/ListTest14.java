import java.util.Arrays;

public class ListTest14 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] arr = {{1,2,3},{4,5,6}};

        // int[] arr = new int[]{1};
        int[] arr2 = new int[]{2,1,1,2};
        // String s="babad";
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if(n<=2){
            return n;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n;i++){
            //状态方程
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }
}
