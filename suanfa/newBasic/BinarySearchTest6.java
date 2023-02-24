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

    public int findPeakElement(int[] nums) {
        // int high = nums.length - 1;
        // int low = 0;
        // int ans = -1;
        // while(high > low){
        //     int mid = (high + low)/2;
        //     //说明单调增还没到头，让low再+1
        //     if(nums[mid] < nums[mid+1]){
        //         low = mid + 1;
        //     }else{
        //         //说明单调到头了,而且mid可能是结果()
        //         high = mid - 1;
        //     }
        // }
        // return low;
    }

}


