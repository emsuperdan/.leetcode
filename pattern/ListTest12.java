import java.util.Arrays;

public class ListTest12 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] arr = {{1,2,3},{4,5,6}};

        // int[] arr = new int[]{1};
        int[] arr2 = new int[]{2,1,1,2};
        // String s="babad";
        System.out.println(rob(arr2));
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];

        //init data
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2;i<=nums.length;i++){
            //状态转移: 注意nums[i-1]对应dp[i-2]
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }

        System.out.println(dp[nums.length]);
        return dp[nums.length];
    }
}
