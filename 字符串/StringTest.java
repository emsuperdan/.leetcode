package 字符串;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StringTest {
    

    public static void main(String[] args) throws Exception {
        StringTest test = new StringTest(2);
        test.put(1, 1);
        test.put(2, 2);
        int val;
        val = test.get(1);
        test.put(3, 3);
        val = test.get(2);

        System.out.println(val);
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length() - 1;
        String ans = "";
        //当前位数是否要进1
        int add = 0;
        while(i>=0 || j>=0 || add!=0){
            int x = i>=0 ? num1.charAt(i) - '0' : 0;
            int y = j>=0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            add = result/10;
            ans += result%10;
            i--;
            j--;
        }
        String bns = "";
        for(int m = ans.length()-1; m >= 0 ;m--){
            bns += ans.charAt(m);
        }
        return bns;
    }

    public String addStrings2(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length() - 1;
        StringBuffer ans = new StringBuffer();
        //当前位数是否要进1
        int add = 0;
        while(i>=0 || j>=0 || add!=0){
            int x = i>=0 ? num1.charAt(i) - '0' : 0;
            int y = j>=0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            add = result/10;
            ans.append(result%10);
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}


