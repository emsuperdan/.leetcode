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

public class InsertSort {
    

    public static void main(String[] args) throws Exception {
        InsertSort test2 = new InsertSort();
        System.out.println(Arrays.toString(test2.sortArray(new int[]{5,2,3,1})));
    }


    public int[] sortArray(int[] nums) {
        insertSort(nums);
        return nums;
    }

    public void insertSort(int[] nums){
        //从1开始是因为默认0的位置不用排，可以直接插
        for(int i = 1; i< nums.length; i++){
            int base = nums[i];
            int j;
            for(j = i-1; j>=0; j--){
                if(nums[j] > base){
                    //j的位置空一格出来 j到i之间集体往后移一格(相当于废弃并占用掉原来的i给j+1了)
                    nums[j+1] = nums[j];
                }else {
                    //如果没有就直接break 省时间复杂度
                    break;
                }
            }
            //为啥用base不用num[i]?: 因为num[i]的值已经被num[j+1]占了;
            nums[j+1] = base;
        }
    }
}


