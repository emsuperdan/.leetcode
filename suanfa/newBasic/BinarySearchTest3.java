package newBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinarySearchTest3 {
    

    public static void main(String[] args) throws Exception {
        BinarySearchTest3 test2 = new BinarySearchTest3();
        System.out.println(test2.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        int high = x;
        int low = 0;
        int ans = -1;
        while(high >= low){
            int mid = low + (high - low)/2;
            //这里设置为long是为了不超出int范围
            //而且这里满足<=的条件，还需要动态调整low下标，直到找到最大满足<=x的元素
            if((long)mid*mid <= x){
                ans = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return ans;
    }

}


