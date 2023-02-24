
public class ListTest8 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[] arr = new int[]{1,2,3,2,1};
        int[] arr2 = new int[]{3,2,1,4,7};
        // String s="babad";
        System.out.println(findLength(arr,arr2));
    }

    public static int findLength(int[] nums1, int[] nums2) {
        //dp[i][j]表示 nums1[i]到nums1[end]和nums2[j]到nums2[end]的最长公共子序
        //因此这次需要倒着写状态方程
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int ans = 0;

        for(int i=nums1.length-1;i>=0;i--){
            for(int j = nums2.length-1;j>=0;j--){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = dp[i+1][j+1] +1;
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }
}
