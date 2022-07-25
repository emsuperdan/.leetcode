package basic;

public class MergeSort {

    public static void main(String[] args) {

    }

    public static void merge(int[] data, int[] temp, int left, int right) {
        //递归出口，注意是>=，否则会有元素遗漏
        if (left >= right) {
            return;
        }
        //防止int越界
        int mid = left + (right - left) >> 2;
        //merge作用是分治，切割原来的数组
        merge(data, temp, left, mid);
        merge(data, temp, mid + 1, right);
        //真正排序是realMerge
        realMerge(data, temp, left, mid, right);
    }

    public static void realMerge(int[] data, int[] temp, int left, int mid, int right) {
        // 先复制一份left和mid副本
        int p1 = left;
        int p2 = mid + 1;
        int cur = left; // temp数组下表索引
        while (p1 <= mid && p2 <= right) {//迭代条件，两指针都不越界
            //每轮都从左右两边取较小的数
            temp[cur++] = data[p1] < data[p2] ? data[p1++] : data[p2++];
        }
        while (p1 <= mid) {
            //把每轮左边剩余的数直接添加都temp数组后面
            temp[cur++] = data[p1++];
        }
        while (p2 <= right) {
            //把每轮右边剩余的数直接添加都temp数组后面
            temp[cur++] = data[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            //将temp数组元素拷贝回原来数组
            data[left + i] = temp[i];
        }
    }
}
