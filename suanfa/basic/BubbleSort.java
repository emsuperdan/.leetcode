package basic;

import java.util.Arrays;

//每轮两两比较，如果前数大/小于后数，则进行交换，内部for循环一轮冒泡下来保证最后的数(是nums.length-i-1，而并非nums.length)最大/小；
//每轮通过hasChange记录是否这轮发生过元素交换，外部for循环则直接continue，i+1；
public class BubbleSort {
    
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 6, 4, 5, 10, 2};
        bubbleSort(nums);
    }

    public static void bubbleSort(int[] nums){
        for(int i = 0;i<nums.length;i++){
            boolean hasChange = false;
            for(int k = 0; k<nums.length-i-1;k++){
                if(nums[k+1]>nums[k]){
                    int temp = nums[k+1];
                    nums[k+1] = nums[k];
                    nums[k] = temp;
                    hasChange = true;
                }
            }
            if(hasChange){
                continue;
            }
        }
        System.out.println(Arrays.toString(nums));

    }
}
