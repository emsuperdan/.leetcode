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

public class BinarySearchTest5 {
    

    public static void main(String[] args) throws Exception {
        BinarySearchTest4 test2 = new BinarySearchTest4();
        System.out.println(Arrays.toString(test2.searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }

    public int findMin(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        int minIndex = -1;
        while(high >= low){
            int mid = (high + low)/2;
            //这里比较的是 0 - mid 内区间是否单调增，是的话则最小值在mid - length内区间,反之一样
            if(nums[0] <= nums[mid]){
                low = mid + 1;
            }else{
                minIndex = mid;
                high = mid - 1;
            }
        }
        //如果下标等于-1，说明已经排好序，第一个为最小值
        return minIndex == -1 ? nums[0] : nums[minIndex];
    }

}


