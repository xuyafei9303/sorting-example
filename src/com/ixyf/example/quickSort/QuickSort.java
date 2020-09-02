package com.ixyf.example.quickSort;

/**
 * 快速排序算法
 * 是对冒泡排序的一种改进，通过一趟排序将要排序的数据序列分成独立的两部分，其中一部分的所有数据比另一部分的所有数据都要小
 * 然后按此方法对两部分数据分别进行快速排序，整个排序递归进行
 * 1.选取一个基准值，一般是序列的第一个元素，将比基准值大的都放在右边的序列中，将比基准值小的都放在左边的序列中
 * 2.从后往前比较，用基准值和最后一个比较，如果小于基准值，就互换位置，如果大于基准值，则接着查找下一个元素进行比较，一直找到比基准值小的第一个元素交换位置为止
 * 3.找到并交换以后，在从前往后找，如果找到比基准值大的，就互换位置，如果没找到，就接着比较下一个，直到找到并互换位置
 * 4.重复上述流程，直到从前向后比较的索引大于等于从后往前比较的索引，就结束一个循环，这时候对于基准值来说，左右两边都是有序的序列
 * 5.重复循环上述流程，分别比较左右两边的序列，直到整个数据序列有序
 */
public class QuickSort {

    public static int[] quickSort(int [] arr, int low, int high) {
        int start = low; // 从前向后比较的索引
        int end = high; // 从后往前比较的索引
        int key = arr[low]; // 基准值
        while (end > start) {
            // 从后向前比较
            while (end > start && arr[end] >= key)
                end--;
                // 如果没有比基准值小的，则比较下一个，直到有比基准值小的，则交换位置，然后又从前向后比较
                if (arr[end] < key) {
                    int temp = arr[end];
                    arr[end] = arr[start];
                    arr[start] = temp;
                }
                // 从前向后比较
                while (end > start && arr[start] <= key)
                    start++;
                    // 如果没有比基准值大的，则比较下一个，直到有比基准值大的，就交换位置
                    if (arr[start] >= key) {
                        int temp = arr[start];
                        arr[start] = arr[end];
                        arr[end] = temp;
                    }
                    // 此时第一次循环比较结束，基准值的位置已经确定，左边的值逗比基准值小
                    // 右边的值都比基准值大，但是两边的顺序还是可能不一样，接着进行下面的递归调用
                }
                // 递归左边序列：从第一个索引位置到基准位置索引 -1
                if (start > low) quickSort(arr, low, start - 1);
                // 递归右边序列：从基准值索引 + 1 到最后一个位置
                if (end < high) quickSort(arr, end + 1, high);
                return arr;
            }
}
