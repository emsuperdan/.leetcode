package newBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinarySearchTest4 {
    

    public static void main(String[] args) throws Exception {
        BinarySearchTest4 test2 = new BinarySearchTest4();
        System.out.println(Arrays.toString(test2.searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }


    public int[] searchRange(int[] nums, int target) {
        int low = binarySearchRange(nums, target, true);
        int high = binarySearchRange(nums, target, false);
        //判断条件比较长 不过都是很好想的
        if(low != -1 && high != -1 && low < nums.length && high < nums.length && nums[low] == target && nums[high] == target){
            return new int[]{low, high};
        }
        return new int[]{-1, -1};
    }


    public int binarySearchRange(int[] nums, int target, boolean findLow) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(high>=low){
            int mid = low + (high - low)/2;
            if(!findLow){
                // <= 是求右边界
            if(nums[mid]<=target){
                ans = mid;
                //note
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }else{
                // <= 是求左边界
            if(nums[mid]>=target){
                ans = mid;
                //note
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        }
        return ans;
    }

}


