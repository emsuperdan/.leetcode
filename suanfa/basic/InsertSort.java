package basic;

import java.util.Arrays;

//从第二个数开始第一个数前/后插入，第三个数往前两个数中插入，以此类推
public class InsertSort {
    
    public static void main(String[] args) {
        // int[] nums = new int[]{1, 7, 6, 4, 5, 10, 2, 8, 9};
        int[] nums = new int[]{1, 7, 6, 4, 5, 10, 2};
        // int[] nums = new int[]{1, 4, 7, 8, 9};
        // System.out.println(seletSort(nums, 9));
        seletSort(nums);
    }

    public static void seletSort(int[] nums){
        for(int i = 1;i<nums.length;i++){
            int temp = nums[i];
            int j;
            for(j= i-1; j>=0;j--){
                if(nums[j]>temp){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            //这里本来是nums[j]但是因为最后j--了  所以这里+1；
            nums[j+1] = temp;
        }

        // System.out.println(Arrays.toString(nums));
    }
}
