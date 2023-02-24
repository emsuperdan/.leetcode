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

public class HashMapTest5 {
    

    public static void main(String[] args) throws Exception {
        HashMapTest4 test4 = new HashMapTest4();
        System.out.println(test4.longestConsecutive2(new int[]{-1,1,0}));
    }

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int intVal = 1;
        while(set.contains(intVal)){
            intVal++;
        }
        return intVal;
    }
}


