package 栈和队列;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DequeTest {
    

    public static void main(String[] args) throws Exception {
        System.out.println(isValid("()[]"));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        //奇数一定不对称
        if(n % 2 == 1){
            return false;
        }
        //创建符号表
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for(int index = 0; index<n; index++){
            char c = s.charAt(index);
            //如果对称，那么会从对称轴位置的后面index开始满足containKey(c)
            if(pairs.containsKey(c)){
                //如果对称，从符号表中取出的左括号将是离c最近的括号，而这个括号一定是在栈顶；如果不则直接返回false
                if(stack.isEmpty() || stack.peek() != pairs.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                //如果对称，那么会一直push到中心对称轴的位置
                stack.push(c);
            }
        }
        //如果对称，则最终栈内为空
        return stack.isEmpty();
    }

}


