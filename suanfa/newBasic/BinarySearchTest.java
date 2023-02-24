import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinarySearchTest {
    

    public static void main(String[] args) throws Exception {

    }

    public int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
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


