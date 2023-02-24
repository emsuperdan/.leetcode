import java.util.Arrays;

public class ArrayTest2 {
    

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1,2,3,0,0,0};
        int[] arr1 = new int[]{2,5,6};
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        // System.out.println(merge(arr,3,arr1, 3));

        merge(arr,3,arr1, 3);
        System.out.println(Arrays.toString(arr));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] nums: matrix){
            //每一行二分查找
            int search = search(nums, target);
            if(search != -1){
                return true;
            }
        }
        return false;
    }

    //二分查找
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (right - left)/2 + left;
            int midV = nums[mid];

            if(midV == target){
                return mid;
            }else if(midV > target){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    //暴力遍历
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean find = false;
        for(int i =0; i <m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == target){
                    find = true;
                }
            }
        }
        return find;
    }

}
