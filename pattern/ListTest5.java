
public class ListTest5 {
    

    public static void main(String[] args) throws Exception {
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        // String s="babad";
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        return subMaxSubArray(nums);
    }

    public static int subMaxSubArray(int[] nums) {
        int fn = 0;
        int maxAns = nums[0];
        for(int i = 0; i < nums.length;i++){
            //如果fn + nums[i]还没有nums[i]大，则舍弃之前的fn，让nums[i]重开一段连续数组
            fn = Math.max(fn+nums[i], nums[i]);
            //可能第二段重开的数组和没有第一次的大，所以需要记录最大一组
            maxAns = Math.max(fn, maxAns);
        }

        return maxAns;
    }
}
