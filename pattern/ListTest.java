
public class ListTest {
    

    public static void main(String[] args) throws Exception {
        int[][] arr = {{0}};
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(getMinSum2(arr));

    }

    public static int getMinSum2(int[][] grid){
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dp[i][j] = -1;
            }
        }

        getMinSum(grid, grid.length-1, grid[0].length-1, dp);
        return dp[grid.length-1][grid[0].length-1];
    }

    public static int getMinSum(int[][] arr, int curX, int curY, int[][] dp){

        if(curX>=0 && curY>=0&& dp[curX][curY]!=-1){
                return dp[curX][curY];
            }

        int ans = 0;
        if(curX == 0 && curY == 0){
            ans= arr[0][0];
            dp[curX][curY] = ans;
            return ans;
        }

        if(curX == 0 && curY>0){
            ans= getMinSum(arr, curX, curY-1, dp)  + arr[curX][curY];
            dp[curX][curY] = ans;
            return ans;
        }

        if(curY == 0 && curX>0){
            ans= getMinSum(arr, curX-1, curY,dp) + arr[curX][curY];
            dp[curX][curY] = ans;
            return ans;
        }

        if(arr.length > 1 && arr[0].length > 1){
            ans=  Math.min(getMinSum(arr, curX-1, curY,dp) , getMinSum(arr, curX, curY-1,dp))+ arr[curX][curY];
        }else if(arr[0].length == 1){
            ans=  getMinSum(arr, curX-1, curY,dp)+ arr[curX][curY];
        } else if(arr.length == 1){
            ans=  getMinSum(arr, curX, curY-1,dp)+ arr[curX][curY];
        }else{
            ans = arr[0][0];
        }

        dp[curX][curY] = ans;

        return ans;
    }
}
