import java.util.Arrays;

public class ListTest9 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[] arr = new int[]{1};
        // int[] arr2 = new int[]{3,2,1,4,7};
        // String s="babad";
        System.out.println(coinChange(arr,0));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //填充数值比amount要大即可，这里取amount+1
        Arrays.fill(dp, amount+1);
        //数额0 无法由任意面值组成所以 0个coin
        dp[0] = 0;

        for(int i = 0;i<=amount;i++){
            for(int j = 0; j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        //数额无法被任意coin组成，dp的值还是初始值，进行比较；
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
