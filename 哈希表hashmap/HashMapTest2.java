package 哈希表hashmap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapTest2 {
    

    public static void main(String[] args) throws Exception {
        System.out.println(val);
    }


    //只遍历一遍，然后用map存数据，只要符合条件就可以直接取出
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int diff = target - nums[i];
            //这里用数组元素值做key而不是value是因为get的时候可以直接通过值拿到下标，反之不行
            if(map.containsKey(diff)){
                return new int[]{i, map.get(diff)};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }



    public int[] twoSum2(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}


