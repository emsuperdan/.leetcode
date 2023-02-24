package 栈和队列;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DequeTest2 {
    

    public static void main(String[] args) throws Exception {
        System.out.println(isValid("()[]"));
    }

    Deque<Integer> inDeque = new LinkedList<>();
    Deque<Integer> outDeque = new LinkedList<>();
    public void push(int x) {
        inDeque.push(x);
    }
    public int pop() {
        //out栈元素空了才能从in栈取，不然out栈中新元素会覆盖旧元素
        if(outDeque.isEmpty()){
            in2Out();
        }
        return outDeque.pop();
    }
    public int peek() {
        //out栈元素空了才能从in栈取，不然out栈中新元素会覆盖旧元素
        if(outDeque.isEmpty()){
            in2Out();
        }
        return outDeque.peek();
    }
    //判断两个都为空
    public boolean empty() {
        return outDeque.isEmpty() && inDeque.isEmpty();
    }
    //一次性把in栈的元素全塞到out栈
    public void in2Out(){
        while(!inDeque.isEmpty()){
            outDeque.push(inDeque.pop());
        }
    }
}


