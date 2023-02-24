package 哈希表hashmap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapTest3 {
    

    public static void main(String[] args) throws Exception {
        System.out.println(val);
    }


    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int val : nums){
            //把数组的value放key，是为了通过key拿到count，反之则不行
            if(hashMap.containsKey(val)){
                hashMap.put(val, hashMap.get(val)+1);
            }else{
                hashMap.put(val, 1);
            }
        }
        
        //获取map中count数量最大的
        int count = 0;
        int max = 0;
        for(Map.Entry<Integer, Integer> map : hashMap.entrySet()){
            if(map.getValue()>=count){
                max = map.getKey();
                count = map.getValue();
            }
        }
        return max;
    }

    //众数且数量超一半，因此排完序中位数就是答案
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}


