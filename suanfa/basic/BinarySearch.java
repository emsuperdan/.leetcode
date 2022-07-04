package basic;

import java.util.Arrays;

// # 二分查找

// 二分的本质并非“单调性”，而是“边界”，只要找到某种性质，使得整个区间一分为二，那么就可以用二分把边界点二分出来。

// ## 算法模板
// 我们做二分题目时，可以按照以下步骤：

// 1. 写出循环条件：`while (left <= right)`，注意是 `left <= right`，而非 `left < right`；(因为这样可能会误导，在
// left=mid+1且right=mid-1情况下，可能出现直接跳出循环条件)
// 1. 循环体内，先无脑写出 `mid = (left + right) >> 1`；
// 1. 根据具体题目，实现 `check()` 函数（有时很简单的逻辑，可以不定义 `check`），想一下究竟要用 `right = mid`（模板 1） 还是 `left = mid`（模板 2）；
//     - 如果 `right = mid - 1`，那么无脑写出 else 语句 `left = mid + 1`；
//     - 如果 `left = mid + 1`，那么无脑写出 else 语句 `right = mid - 1`。
// 1. 循环结束时，left 与 right 相等。

// ## 例题

// -   [在排序数组中查找元素的第一个和最后一个位置](/solution/0000-0099/0034.Find%20First%20and%20Last%20Position%20of%20Element%20in%20Sorted%20Array/README.md)
// -   [x 的平方根](/solution/0000-0099/0069.Sqrt%28x%29/README.md)
// -   [寻找峰值](/solution/0100-0199/0162.Find%20Peak%20Element/README.md)
// -   [第一个错误的版本](/solution/0200-0299/0278.First%20Bad%20Version/README.md)
// -   [不动点](/solution/1000-1099/1064.Fixed%20Point/README.md)

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 4, 4, 5, 7, 8, 8, 9};
        // int[] nums = new int[]{1, 4, 7, 8, 9};
        System.out.println(getResult2(nums, 9));
    }

    //普通二分法
    private static int getResult2(int[] nums, int key){
        int left = 0;
        int right = nums.length - 1;

        //此时 区间取值是[left,right] 左右都闭区间
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
