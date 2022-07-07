package basic;

//大/小顶堆其实都用到了完全二叉树结构，即除去右下角那个非叶子节点外
//其他非叶子节点都有左右两个节点
//①先构建大顶堆，从下往上，从右往左，让每个非叶子节点是最大的(初始大顶堆)  
//②再次从下往上，从右往左，从每个节点开始构建真正大顶堆，同时断开每轮最后那个元素;
public class HeapSort {
    public static void main(String[] args) {

    }

    private static void heapSort(int[] nums){
        //先构造初始大顶堆
        // for(int i = (nums.length-1)/2, i>=0;i--){
        //     partHeapSort(nums, i, nums.length);
        // }
        
    }

    private static void partHeapSort(int[] nums, int parent, int length) {
        int j;
        while(2*parent + 1<length){//判断有子节点
            j = 2*parent+1;
            // if(2*parent+2<length && nums[j]<nums[j+1]]){
            //     j++;
            // }
        }
    }
}
