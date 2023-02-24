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

public class HeapSort {
    

    public static void main(String[] args) throws Exception {
        HeapSort test2 = new HeapSort();
        System.out.println(Arrays.toString(test2.sortArray(new int[]{5,1,1,2,0,0})));
    }

    public int[] sortArray(int[] nums) {
        wholeBigHeapSort(nums);
        return nums;
    }

    public void wholeBigHeapSort(int[] nums){
        //用每个根节点构建大顶堆
        for(int i = (nums.length - 1)/2; i>=0; i--){
            //注意这里排序用的是数组长度，也就是数组最后一位数 + 1的位置
            partHeapSort(nums, i, nums.length);
        }

        //遍历每个结点 从大顶堆顶部依次置换出有序数组
        for(int i = (nums.length-1); i >= 0; i--){
            swap(nums, i, 0);
            //注意这里排序用的是数组长度-1，也就是数组最后一位数的位置
            partHeapSort(nums, 0, i);
        }
    }

    //endIndex实质上要比构建大顶堆的end大一位，从2*root+1 < endIndex  2*root+2<endIndex就可观察出
    public void partHeapSort(int[] nums, int rootIndex, int endIndex){
        int maxChildIndex;
        //判断有子节点
        while(2*rootIndex + 1 < endIndex){
            maxChildIndex = 2*rootIndex + 1;
            //取最大子节点
            if((2*rootIndex + 2 < endIndex) && nums[2*rootIndex + 1] < nums[2*rootIndex + 2]){
                maxChildIndex++;
            }
            //为啥这里可以提前break不管子节点是否为大顶堆了: 因为是从下往上排，子节点一定为大顶堆
            if(nums[rootIndex] > nums[maxChildIndex]){
                break;
            }
            swap(nums, rootIndex, maxChildIndex);
            //因为rootIndex不满足大顶堆，替换之后需要从上往下进行调整
            rootIndex = maxChildIndex;
        }
    }

       //endIndex实质上要比构建小顶堆的end大一位，从2*root+1 < endIndex  2*root+2<endIndex就可观察出
       public void partSmallHeapSort(int[] nums, int rootIndex, int endIndex){
        int minChildIndex;
        //判断有子节点
        while(2*rootIndex + 1 < endIndex){
            minChildIndex = 2*rootIndex + 1;
            //取最小子节点
            if((2*rootIndex + 2 < endIndex) && nums[2*rootIndex + 1] > nums[2*rootIndex + 2]){
                minChildIndex++;
            }
            //为啥这里可以提前break不管子节点是否为小顶堆了: 因为是从下往上排，子节点一定为小顶堆
            if(nums[rootIndex] < nums[minChildIndex]){
                break;
            }
            swap(nums, rootIndex, minChildIndex);
            //因为rootIndex不满足小顶堆，替换之后需要从上往下进行调整
            rootIndex = minChildIndex;
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }



}


