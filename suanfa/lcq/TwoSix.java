import java.util.Arrays;

public class TwoSix {
    public static void main(String[] args) {
        TwoSix instance = new TwoSix();
        System.out.println(instance.getResult(new int[]{1}));
        
    }

    private int getResult(int[] nums){
        int p = 0;
        for (int q = 1; q < nums.length; q++) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p += 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        return p + 1;
    }
}
