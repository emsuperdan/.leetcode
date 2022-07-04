package basic;

import java.util.Arrays;

//
public class QuickSort {
    
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 6, 4, 5, 10, 2};
        getResult(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }


    private static void getResult(int[] nums, int low, int high){
        //函数出口
        if(low>high){
            return;
        }
        int i = low;
        int j = high;
        int key = nums[low];

        while(i<j){
            while(i<j&&nums[j]<key){
                j--;
            }
            while(i<j&&nums[i]>=key){
                i++;
            }
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        
        int temp = nums[low];
        nums[low] = nums[i];
        nums[i] = temp;
        getResult(nums, low, i-1);
        getResult(nums, i+1, high);
    }
}
