package practice1;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
    

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{5,2,3,1};
        // int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        Test1 test1 = new Test1();
        test1.sort5(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void sort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int minV = nums[i];
            int minIndex = i;
            for(int j = i+1; j < nums.length; j++){
                if(minV > nums[j]){
                    minV = nums[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                swapValue(nums, minIndex, i);
            }
        }
    }

    public void sort1(int[] nums){
        for(int i = 1; i<nums.length; i++){
            int minV = nums[i];
            int j;
            for(j = i-1; j >= 0; j--){
                if(nums[j] > minV){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            nums[j+1] = minV;
        }
    }

    public void sort2(int[] nums){
        for(int i = 0; i < nums.length; i++){
            boolean changed = false;
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    swapValue(nums, j+1, j);
                    changed = true;
                }
            }
            if(!changed){
                break;
            }
        }
    }

    public void sort3(int[] nums){
        quickSort(nums, 0, nums.length-1);
    }

    public void quickSort(int[] nums, int left, int right){
        if(left < right){
            int pos = getPartipatePos(nums, left, right);
            quickSort(nums, left, pos-1);
            quickSort(nums, pos + 1, right);
        }
    }

    public int getPartipatePos(int[] nums, int left, int right){
        int i = left;
        int j = right;
        int pivot = nums[left];
        while(i<j){
            while(i<j && nums[j] > pivot){
                j--;
            }
            while(i<j && nums[i] <= pivot){
                i++;
            }
            if(i<j){
                swapValue(nums, j, i);
            }
        }
        swapValue(nums, i, left);
        return i;
    }

    public int getRandomPartipatePos(int[] nums, int left, int right){
        int random = (new Random()).nextInt(right-left) + left;
        swapValue(nums, random, left);

        int i = left;
        int j = right;
        int pivot = nums[left];
        while(i<j){
            while(i<j && nums[j] > pivot){
                j--;
            }
            while(i<j && nums[i] <= pivot){
                i++;
            }
            if(i<j){
                swapValue(nums, j, i);
            }
        }
        swapValue(nums, i, left);
        return i;
    }

    public void sort4(int[] nums){
        for(int i = (nums.length - 1)/2; i>=0 ;i--){
            heapSmallSort(nums, i, nums.length);
        }

        for(int i = (nums.length - 1); i>=0;i--){
            swapValue(nums, 0, i);
            heapSmallSort(nums, 0, i);
        }
    }

    public void heapSort(int[] nums, int rootIndex, int endIndex){
        int maxChildIndex;
        while(2*rootIndex+1 < endIndex){
            maxChildIndex = 2*rootIndex+1;
            if(2 * rootIndex +2 < endIndex && nums[2 * rootIndex + 1] < nums[2 * rootIndex +2]){
                maxChildIndex++;
            }
            if(nums[rootIndex] > nums[maxChildIndex]){
                break;
            }
            swapValue(nums, rootIndex, maxChildIndex);
            rootIndex = maxChildIndex;
        }
    }

    public void heapSmallSort(int[] nums, int rootIndex, int endIndex){
        int minChildIndex;
        while(2 * rootIndex +1 <endIndex){
            minChildIndex = 2 * rootIndex + 1;
            if(2*rootIndex +2 < endIndex && nums[2*rootIndex + 1]>nums[2*rootIndex + 2]){
                minChildIndex ++;
            }
            if(nums[rootIndex] < nums[minChildIndex]){
                break;
            }
            swapValue(nums, rootIndex, minChildIndex);
            rootIndex = minChildIndex;
        }
    }

    public void sort5(int[] nums){
        int[] tempNums = new int[nums.length];
        mergeSort(nums, tempNums, 0, nums.length-1);
    }

    public void mergeSort(int[] nums, int[] tempNums, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(nums, tempNums, left, mid);
            mergeSort(nums, tempNums, mid + 1, right);
            merge(nums, tempNums, left, mid + 1, right);
        }
    }

    public void merge(int[] nums, int[] tempNums, int left, int mid, int right){
        int i = left;
        int j = mid;
        int cur = left;
        while(i<mid && j<=right){
            if(nums[i] < nums[j]){
                tempNums[cur++] = nums[i++];
            }else{
                tempNums[cur++] = nums[j++];
            }
        }
        while(i<mid){
            tempNums[cur++] = nums[i++];
        }
        while(j<=right){
            tempNums[cur++] = nums[j++];
        }
        for(int k = left; k<=right; k++){
            nums[k] = tempNums[k];
        }
    }

    public boolean bucketSort(String a, String b) {
        int[] bucket = new int[26];
        for(char c : a.toCharArray()) bucket[c-'0']++;
        for(char c : b.toCharArray()) bucket[c-'0']--;
        for(int size : bucket){
            if(size!=-0){
                return false;
            }
        }
        return true;
    }

    public void swapValue(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
