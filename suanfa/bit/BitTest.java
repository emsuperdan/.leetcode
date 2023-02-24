package bit;

import java.util.Arrays;

public class BitTest {
    
    public static void main(String[] args) {
        BitTest bitTest = new BitTest();
        // int[] nums = new int[]{1, 7, 6, 4, 5, 10, 2};
        System.out.println(bitTest.hammingWeight(00000000000000000000000000001011));
    }

    //利用 value>>n 获取第n位上的数，然后和1进行&操作，循环32次即可拿到所有1的个数
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i =1; i<=32; i++){
            //为了不破坏原来的数
            int tempN = n;
            int v = tempN >> i & 1;
            if(v==1){
                cnt++;
            }
        }
        return cnt;
    }

}
