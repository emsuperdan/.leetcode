import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest3 {
    

    public static void main(String[] args) throws Exception {
        // int[] arr = new int[]{1,2,3,0,0,0};
        // int[] arr1 = new int[]{2,5,6};
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(arr));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        //判空
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int top = 0; int left = 0; int right = n-1; int bottom = m-1;
        while(left<=right && top<=bottom){
            //注意往右扫的时候 不包含右上拐角那个点
            for(int column = left;column<right;column++){
                list.add(matrix[top][column]);
            }
            //注意往下扫的时候 包含右上拐角点和右下拐角点
            for(int row = top; row<=bottom;row++){
                list.add(matrix[row][right]);
            }
            //因为往左和往上扫时，可能已经left==right或top==bottom
            //这种情况不需要再左和上扫
            if(left<right && top<bottom){
                //注意往左扫的时候 不包含左下拐角点
                for(int column = right-1; column >left; column--){
                    list.add(matrix[bottom][column]);
                }
                //注意往左扫的时候 不包含左上拐角点(完整闭环)
                for(int row = bottom; row > top; row--){
                    list.add(matrix[row][left]);
                }
            }
            top++;
            right--;
            left++;
            bottom--;
        }
        return list;
    }
   

}
