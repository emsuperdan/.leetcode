import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest4 {
    

    public static void main(String[] args) throws Exception {
        // int[] arr = new int[]{1,2,3,0,0,0};
        // int[] arr1 = new int[]{2,5,6};
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        rotate2(arr);
        for(int[] sub:arr){
            System.out.println(Arrays.toString(sub));
        }
    }


    //找到最小旋转重复区域进行翻转
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n/2;i++){
            for(int j = 0; j<(n+1)/2;j++){
                //matrix[i][j] 90度对应旋转点 matrix[n-j-1][i]
                //matrix[i][j] 180度对应旋转点 matrix[n-i-1][n-j-1]
                //matrix[i][j] 270度对应旋转点 matrix[j][n-i-1]
                int temp = matrix[i][j];//找到上边对应坐标点
                matrix[i][j] = matrix[n-j-1][i];//找到右边对应坐标点
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];//找到下边对应坐标点
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];//找到左边对应坐标点
                matrix[j][n-i-1] = temp;
            }
        }
    }

    //上下翻转后再对角翻转
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        //上下翻转
        for(int i=0;i<n/2; i++){
            for(int j = 0;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }

        //对角翻转
        for(int i =0;i<n;i++){
            for(int j = 0; j < i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
   
}
