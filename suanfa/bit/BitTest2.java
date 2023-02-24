package bit;

import java.util.Arrays;

public class BitTest2 {
    
    public static void main(String[] args) {
        BitTest2 bitTest = new BitTest2();
        // int[] nums = new int[]{1, 7, 6, 4, 5, 10, 2};
        System.out.println(bitTest.isPowerOfTwo(1));
    }

    //小于等于0 肯定不是2的幂次
    //正数判断2的幂可用 n&(n-1)==0
    public boolean isPowerOfTwo(int n) {
        return n<=0 || ((n & (n-1)) != 0) ? false : true;
    }

}
