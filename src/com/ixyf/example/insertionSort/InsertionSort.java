package com.ixyf.example.insertionSort;

/**
 * 插入排序
 * 将一个数据插入已经排好序的序列中，从而得到一个新的有序数据，适用于数据量小的序列的排序，是稳定的排序方法
 * 排序的时候将原始数据拆分成两个子集，一个是有序的L子集，开始为空，可以设置原始数据的第一个元素为L的第一个元素，一个是无序的R子集
 * 排序的时候把R的数据挨个和L子集的数据比较，大的就放到后面，小的就放到前面，保证L任何时候都是有序的,当R为空的时候排序完成
 */
public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 插入的数
            int insertVal = arr[i];
            // 被插入的位置，（准备和前一个数据进行比较）
            int index = i - 1;
            // 如果插入的数比被插入的数据小
            while (index >= 0 && insertVal < arr[index]) {
                // 则将arr[index]向后移动
                arr[index+1] = arr[index];
                // 将index向后移动
                index--;
            }
            // 将插入的数放入合适的位置
            arr[index + 1] = insertVal;
        }
        return arr;
    }
}
