
public class ListTest7 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[] arr = new int[]{7,1,5,3,6,4};
        // String s="babad";
        System.out.println(maxProfit2(arr));
    }

    //贪心算法 只计算上涨趋势的差
    public static int maxProfit2(int[] prices) {
        if(prices == null || prices.length==1){
            return 0;
        }

        int profit = 0;
        for(int i = 0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //dp[i][0] 表示手上股票数为0 第i天时的收益
        dp[0][0] = 0;
        //dp[i][1] 表示手上股票数为1 第i天时的收益(dp[0][1]表示第一天买了股票
        //，亏了prices[0])
        dp[0][1] = -prices[0];

        for(int i=1;i<prices.length;i++){
            //如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票
            //，即 dp[i−1][0]，或者前一天结束的时候手里持有一支股票，即 dp[i−1][1]
            //这时候我们要将其卖出，并获得 prices[i]的收益
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);

            //前一天已经持有一支股票，即 dp[i−1][1]，或者前一天结束时还没有股票
            //即 dp[i−1][0]，这时候我们要将其买入，并减少 prices[i]的收益
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }

        //全部交易结束后，持有股票的收益一定低于不持有股票的收益
        //dp[n−1][0]的收益必然是大于 dp[n−1][1];
        return dp[prices.length-1][0];
    }
}
