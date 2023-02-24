package 栈和队列;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DequeTest3 {
    

    public static void main(String[] args) throws Exception {
        System.out.println(isValid("()[]"));
    }

    Deque<Integer> minDeque = new LinkedList<>();
    Deque<Integer> helperDeque = new LinkedList<>();
    //构造函数
    public MinStack() {
        minDeque = new LinkedList<Integer>();
        helperDeque = new LinkedList<Integer>();
        //先往辅助栈中放入一个最大值，可以兜底边界空栈的判断逻辑
        helperDeque.push(Integer.MAX_VALUE);
    }
    public void push(int val) {
        minDeque.push(val);
        //因为最终是为了取最小值，所以可以往辅助栈中塞入同个栈顶元素
        helperDeque.push(Math.min(helperDeque.peek(), val));
    }
    public void pop() {
        minDeque.pop();
        helperDeque.pop();
    }
    public int top() {
       return minDeque.peek();
    }
    public int getMin() {
        return helperDeque.peek();
    }
}


