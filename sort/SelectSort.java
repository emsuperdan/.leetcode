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

public class SelectSort {
    

    public static void main(String[] args) throws Exception {
        SelectSort test2 = new SelectSort();
        System.out.println(Arrays.toString(test2.sortArray(new int[]{5,1,1,2,0,0})));
    }


    public int[] sortArray(int[] nums) {
        selectSort(nums);
        return nums;
    }

    public void selectSort(int[] nums){
        for(int i = 0; i< nums.length; i++){
            int roundMin = nums[i];
            int roundMinIndex = i;
            for(int j = i+1; j < nums.length; j++){
                if(roundMin > nums[j]){
                    roundMin = nums[j];
                    roundMinIndex = j;
                }
            }
            if(roundMinIndex != i){
                int temp = nums[i];
                nums[i] = nums[roundMinIndex];
                nums[roundMinIndex] = temp;
            }
        }
    }
}


