import java.util.Arrays;

public class ArrayTest {
    

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1,2,3,0,0,0};
        int[] arr1 = new int[]{2,5,6};
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        // System.out.println(merge(arr,3,arr1, 3));

        merge(arr,3,arr1, 3);
        System.out.println(Arrays.toString(arr));

    }

    //双指针
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        int cur = 0;
        int[] arr = new int[m+n];

        while(index1<m || index2<n){
            if(index1 == m){
                //把nums1的数据全部排完，剩下直接拼接nums2的数据
                cur = nums2[index2++];
            } else if(index2 == n){
                //把nums2的数据全部排完，剩下直接拼接nums1的数据
                cur = nums1[index1++];
            } else if(nums1[index1]<nums2[index2]){
                cur = nums1[index1++];
            } else{
                cur = nums2[index2++];
            }
            //注意减1
            arr[index1+index2-1] = cur;
        }
    
        for(int i = 0; i<arr.length;i++){
            nums1[i] = arr[i];
        }
    }

    //简单无脑 先合并再排序
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index =0;
        for(int i = m;i<m+n;i++){
            nums1[i] = nums2[index++];
        }
        Arrays.sort(nums1);
    }

}
