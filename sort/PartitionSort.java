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

import 字符串.StringTest;

public class PartitionSort {
    

    public static void main(String[] args) throws Exception {
        PartitionSort test2 = new PartitionSort();
        System.out.println(Arrays.toString(test2.sortArray(new int[]{4,5,6,7,0,1,2})));
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right){
        if(left < right){
            //找到每次两个指针相撞的下标
            int pivotIndex = getPartition(nums, left, right);
            quickSort(nums, 0, pivotIndex-1);
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    public int getPartition(int[] nums, int left, int right){
        //随机取base去做比较  选择left到right任意位置的值，这种是随机化快排
        int random = (new Random()).nextInt(right - left) + left;
        //拿待会要赋值的base(left)和随机生成的index交换值，因为待会我们取left做base，交换之后base就是随机值了，达到随机化快排目的
        swap(nums, left, random);

        int i = left;
        int j = right;
        int pivot = nums[left];
        while(i<j){
            //右边元素大于base
            while(i<j && nums[j]>pivot){
                j--;
            }
            //左边元素小于base
            while(i<j && nums[i]<=pivot){
                i++;
            }
            //左右指针相撞处交换值
            if(i<j){
                swap(nums, j, i);
            }
        }
        //取base的下标和相撞指针index也要互换值
        swap(nums, i, left);
        return i;
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int getPartition2(int[] nums, int left, int right){
        //随机取base去做比较  选择left到right任意位置的值，这种是随机化快排
        int random = (new Random()).nextInt(right - left) + left;
        //拿待会要赋值的base(left)和随机生成的index交换值，因为待会我们取left做base，交换之后base就是随机值了，达到随机化快排目的
        swap(nums, left, random);

        int i = left;
        int j = right;
        int pivot = nums[left];
        while(i<j){
            //右边元素大于base
            while(i<j && nums[j]>pivot){
                j--;
            }
            //左边元素小于base
            while(i<j && nums[i]<=pivot){
                i++;
            }
            //左右指针相撞处交换值
            if(i<j){
                swap(nums, j, i);
            }
        }
        //取base的下标和相撞指针index也要互换值
        swap(nums, i, left);
        return i;
    }

}


