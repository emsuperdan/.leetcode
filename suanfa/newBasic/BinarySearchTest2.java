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

public class BinarySearchTest2 {
    

    public static void main(String[] args) throws Exception {
        BinarySearchTest2 test2 = new BinarySearchTest2();
        System.out.println(test2.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    public int search(int[] nums, int target) {
        int index = -1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i]>nums[i+1]){
                index = i;
            }
        }
        if(index != -1){
            if(target <= nums[nums.length-1]){
                //结果落在后半段
                return binarySearch(nums, target, nums.length - 1, index + 1);
            }else{
                //结果落在前半段
                return binarySearch(nums, target, index, 0);
            }
        }else {
            //数组顺序不用变，都是单调递增的
            return binarySearch(nums, target, nums.length-1, 0);
        }
    }

    //这里和普通二分法一样，只是把入参提取出来，方便对high和low位置进行控制
    public int binarySearch(int[] nums, int target, int high, int low) {
        //如果nums只有一位数， high为0，low为0，所以这里得>= 
        while(high >= low){
            int mid = (high - low)/2 + low;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}


