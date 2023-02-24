package 字符串;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StringTest3 {
    

    public static void main(String[] args) throws Exception {
        StringTest3 test = new StringTest3();

        System.out.println("ans:"+ test.longestCommonPrefix(new String[]{"a","b"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }
        if(strs.length == 1){
            return strs[0];
        }

        //找到最短的那个字符A，从A(0...1)的位置截取到(0...length)获取commonStr，分别去查strs其他字符是否是以commonStr这样开头的
        int shortestIndex = 0;
        int shortestLength = Integer.MAX_VALUE;
        for(int i =0; i < strs.length; i++){
            if(strs[i].length() < shortestLength){
                shortestLength = strs[i].length();
                shortestIndex = i;
            }
        }

        for(int i = 0; i < strs[shortestIndex].length(); i++){
            String commonStr = strs[shortestIndex].substring(0, i+1);
            for(int j = 0; j < strs.length; j++){
                if(!strs[j].startsWith(commonStr)){
                    return strs[shortestIndex].substring(0, i);
                }
            }
        }
        return strs[shortestIndex];
    }
}


