
public class ListTest6 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[] arr = new int[]{7,6,4,3,1};
        // String s="babad";
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int[] dp = new int[prices.length];
        for(int i=1;i<prices.length;i++){
            //先找区域内的最低价
            minPrice = Math.min(minPrice, prices[i]);
            //转移方程
            dp[i] = Math.max(dp[i-1], prices[i]-minPrice);
        }

        return dp[prices.length-1];
    }
}
