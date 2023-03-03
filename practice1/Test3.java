package practice1;

import java.util.Arrays;
import java.util.Random;

public class Test3 {
    

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{5,2,3,1};
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        Test3 test3 = new Test3();
        test3.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[]nums, int left, int right){
        if(left < right){
             int pos = getPartipatePos(nums, left, right);
             quickSort(nums, left, pos - 1);
             quickSort(nums, pos +1 , right);
          }
    }
    
    public int getPartipatePos(int[] nums, int left, int right){
        int i = left;
        int j = right;
        int pivot = nums[left];
        while(i<j){
            while(i<j && nums[j] > pivot){
                j--;
            }
            while(i<j && nums[i] <= pivot){
                i++;
            }
            if(i<j){
                swapValue(nums, i, j);
            }
        }
        swapValue(nums, i, left);
        return i;
    }

    public void swapValue(int[] nums, int a, int b){
        int temp  = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
}
