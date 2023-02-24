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

public class StringTest1 {
    

    public static void main(String[] args) throws Exception {
        StringTest1 test = new StringTest1();

        System.out.println("ans:"+ test.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        String[] strArr = s.trim().split(" ");
        List<String> list= new ArrayList<>();
        for(String str : strArr){
            if(!str.equals(" ")){
                list.add(str);
            }
        }

        Collections.reverse(list);
        return String.join(" ", list);
    }
}


