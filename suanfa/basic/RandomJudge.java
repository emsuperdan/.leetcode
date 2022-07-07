package basic;

import java.util.Arrays;

public class RandomJudge {
    
    public static void main(String[] args) {
        int circleTime = 5000000;
        int maxSize = 15;
        int maxValue = 20;

        boolean isSuccess = true;
        int[] failedArr = null;

        for(int i = 0; i<circleTime;i++){
            int[] arr1 = generateRandomArr(maxSize, maxValue);
            int[] arr2 = copyArr(arr1);
            customMethod(arr1);
            standardMethod(arr2);

            if(!isEqual(arr1, arr2)){
                isSuccess = false;
                failedArr = arr1;
                break;
            }
        }

        System.out.println(isSuccess ? "Success" : "Failed"+Arrays.toString(failedArr));
    }

    // Math.random()  [0,1) 0到1的所有小数
    // Math.random() * N  [0,N-1) 0到N的所有小数
    // (int) Math*random() * N  [0,N-1] 0到N-1所有整数
    public static int[] generateRandomArr(int maxSize, int maxValue){
        int[] arr = new int[(int) ((maxSize+1) * Math.random())];
        for(int i =0;i<arr.length;i++){
            arr[i] = (int)((maxValue+1)*Math.random())-(int)(maxValue*Math.random());
        }
        return arr;
    }

    public static int[] copyArr(int[] arr){
        int[] nums = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i] = arr[i];
        }
        return nums;
    }

    public static void customMethod(int[] arr){
        InsertSort.seletSort(arr);
    }

    public static void standardMethod(int[] arr){
        // Arrays.sort(arr);
        InsertSort.seletSort(arr);
    }

    public static boolean isEqual(int[] arr1, int[] arr2){
        if(arr1 == null && arr2 == null){
            return true;
        }
        if(arr1 == null){
            return false;
        }
        if(arr2 == null){
            return false;
        }
        for(int i = 0; i< arr1.length ; i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
