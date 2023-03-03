package practice1;

import java.util.Arrays;
import java.util.Random;

public class Test2 {
    

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{5,2,3,1};
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        Test2 test1 = new Test2();
        test1.mySqrt(8);
        Integer a1 = new Integer(126);
        Integer a2 = new Integer(126);
        System.out.println(a1 == a2);
        System.out.println(test1.mySqrt(8));
    }
    
    public int binearySearch(int[] nums, int target){
        int high = nums.length - 1;
        int low = 0;
        while(low<=high){
            int mid = (high + low)/2;
            if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public int mySqrt(int x) {
        int high = x;
        int low = 0;
        int ans = -1;
        while(high>=low){
            int mid=  (high - low)/2 + low;
            if(((long)mid * mid) <= x){
                ans = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public int binearySearchParams(int[] nums, int i, int j, int target){
        int high = i;
        int low = j;
        while(high < low){
            int mid = (high+low)/2;
            if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int high = searchRangeHigh(nums, target);
        int low = searchRangeLow(nums, target);
        if(high != -1 && low != -1 && nums[high] == target && nums[low] == target){
            return new int[]{low, high};
        }
        return new int[]{-1,-1};
    }

    public int searchRangeHigh(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] <= target){
                low = mid + 1;
                ans = mid;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public int searchRangeLow(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] >= target){
                high = mid - 1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public int findMin(int[] nums) {
        int high = nums.length -1 ;
        int low = 0;
        int minIndex = -1;
        while(high >= low){
            int mid = (high + low)/2;
            if(nums[mid] < nums[0]){
                high = mid - 1;
            } else {
                minIndex = mid;
                low = mid + 1;
            }
        }
        return minIndex == -1 ? nums[0] : nums[minIndex];
    }

    public void swapValue(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    String a;
    class Inner{
        String b;

        void shtsd(){
            
        }
    }
}
