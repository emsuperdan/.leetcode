package 哈希表hashmap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapTest4 {
    

    public static void main(String[] args) throws Exception {
        HashMapTest4 test4 = new HashMapTest4();
        System.out.println(test4.longestConsecutive2(new int[]{-1,1,0}));
    }

    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        //去重
        for(int val : nums){
            set.add(val);
        }

        int[] newNums = new int[set.size()];
        int index = 0;
        for(int val: set){
            newNums[index++] = val;
        }
        //去重后赋值新数组并排序
        Arrays.sort(newNums);

        //遍历一次并用hash缓存
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i<newNums.length; i++){
            hashMap.put(newNums[i], i);
        }

        int maxLength = 1;
        int roundLength = 1;
        for(int i = 0;i<newNums.length;i++){
            if(hashMap.containsKey(newNums[i]+1)){
                roundLength++;
            }else{
                roundLength = 1;
                continue;
            }
            //每轮取最大值
            if(roundLength>=maxLength){
                maxLength = roundLength;
            }
        }
        return maxLength;
    }

    public int longestConsecutive2(int[] nums) {
        if(nums==null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }

        int maxLong = 0;
        for(int i = 0;i<nums.length;i++){
            //保证无连续的前驱元素x-1，从i位置断层重新计算
            if(!set.contains(nums[i]-1)){
                int curVal = nums[i];
                int roundLong = 1;
                //只会在连续元素起始处开始while循环，此处时间复杂度为常量
                while(set.contains(curVal + 1)){
                    roundLong++;
                    curVal++;
                }
                maxLong = Math.max(maxLong, roundLong);
            }
        }
        return maxLong;
    }
}


