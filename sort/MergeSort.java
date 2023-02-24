package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javafx.scene.chart.PieChart.Data;
import 字符串.StringTest;

public class MergeSort {
    

    public static void main(String[] args) throws Exception {
        MergeSort test2 = new MergeSort();
        System.out.println(Arrays.toString(test2.sortArray(new int[]{4,5,6,7,0,1,2})));
    }

    public int[] sortArray(int[] nums) {
        //建立等长临时数组 省去每轮为了拷贝而去new数组
        int[] tempNums = new int[nums.length];
        mergeSort(nums, tempNums, 0, nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums, int[] tempNums, int left, int right){
        if(left >= right){
            return;
        }
        //拿到每次merge的中分线
        int mid = (left + right)/2;
        mergeSort(nums, tempNums, left, mid);
        //注意右边是从mid+1开始
        mergeSort(nums, tempNums, mid + 1, right);
        //这里有说法 也是传进mid+1作为中分线
        merge(nums, tempNums, left, mid + 1, right);
    }

    public void merge(int[] nums, int[] tempNums, int left, int mid, int right){
        int i = left;
        //这里实际上入参是mid+1的值
        int j = mid;
        //合并后数组的下标位置
        int cur = left;

        //这里小于mid，实际上是 <=（mid真实值）
        while(i < mid && j <= right){
            //去两者更小值放入进去;
            if(nums[i] <= nums[j]){
                tempNums[cur++] = nums[i++];
            }else{
                tempNums[cur++] = nums[j++];
            }
        }
        //left到mid的剩余元素填充
        while(i < mid){
            tempNums[cur++] = nums[i++];
        }
        //mid到right的剩余元素填充
        while(j <= right){
            tempNums[cur++] = nums[j++];
        }
        //拷贝回原来的数组
        for(int m = left; m<=right; m++){
            nums[m] = tempNums[m];
        }
    }
}


