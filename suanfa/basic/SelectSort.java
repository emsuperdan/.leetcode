package basic;

import java.util.Arrays;

//每轮选出最小/最大的数放在最前面 两次for循环
public class SelectSort {
    
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 6, 4, 5, 10, 2};
        // int[] nums = new int[]{1, 4, 7, 8, 9};
        // System.out.println(seletSort(nums, 9));
        selectSort(nums);
    }

    public static void selectSort(int[] nums){
        for(int i = 0; i<nums.length;i++){
        int max = nums[i];
        int changeIndex = i;
        for(int k = i+1 ; k<nums.length;k++){
            if(max<nums[k]){
                max = nums[k];
                changeIndex = k;
            }
        }
        if(changeIndex != i){
            nums[changeIndex] = nums[i];
            nums[i] = max;
        }
    }
    System.out.println(Arrays.toString(nums));
}
}
