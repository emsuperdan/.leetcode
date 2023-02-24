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

public class BubbleSort {
    

    public static void main(String[] args) throws Exception {
        BubbleSort test2 = new BubbleSort();
        System.out.println(Arrays.toString(test2.sortArray(new int[]{5,2,3,1})));
    }


    public int[] sortArray(int[] nums) {
        bubbleSort(nums);
        return nums;
    }

    public void bubbleSort(int[] nums){
        //此处i是为了记录冒泡的轮次
        for(int i = 0; i< nums.length; i++){
            //判断是否已经有序了
            boolean changed = false;
            //每次冒泡都得从index = 0位置开始
            //由于j+1的存在 只能循环到length-1-i位置
            for(int j = 0; j< nums.length-i-1; j++){
                if(nums[j]>nums[j+1]){
                 int temp = nums[j];
                 nums[j] = nums[j+1];
                 nums[j+1] = temp;
                 changed = true;
              }
            }
            if(!changed){
                break;
            }
        }
    }
}


