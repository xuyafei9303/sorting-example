package com.ixyf.example.bubbleSort;

/**
 * 依次比较相邻两个元素，如果左边的元素大于右边的元素，就将二者进行交换位置，如此重复，直到没有相邻的元素需要交换位置，排序就完成了
 */
public class BubbleSort_03 {

    public static int[] bubbleSort(int [] arr) {
        // 外层循环控制排序次数
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层控制每一趟排序次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[i] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
