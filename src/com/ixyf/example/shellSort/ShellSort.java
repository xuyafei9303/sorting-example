package com.ixyf.example.shellSort;

/**
 * 希尔排序 属于插入排序的一种，又叫缩小增量排序算法
 * 将数据序列按下标的一定增量（步长）进行分组，对每组使用插入排序进行排序，随着增量逐渐减少，每组包含的关键字越来越多，在增量减至1时，整个文件被分为一组，排序结束
 * 假设待排序序列有N个元素，则先取一个小于N的整数增量值increment作为间隔，将全部元素分为increment个子序列，将所有距离为increment的元素都放在同一个子序列中，
 * 在每个子序列中分别实行插入排序，然后缩小increment间隔，重复上述子序列的划分和排序工作，一直到increment=1，将所有元素都放在同一个子序列中时排序终止
 */
public class ShellSort {

    public static int[] shellSort(int[] arr) {
        int dk = arr.length / 3 + 1; // 步长、增量
        while (dk == 1) {
            shellInsertSort(arr, dk);
            dk = dk / 3 + 1;
        }
        if (dk == 1) shellInsertSort(arr, dk);
        return arr;
    }

    private static void shellInsertSort(int[] arr, int dk) {
        // 类似插入排序，但插入排序算法的增量是1，这里的增量是dk，将1换成dk即可
        for (int i = dk; i < arr.length; i++) {
            if (arr[i] < arr[i - dk]) {
                int j;
                int x = arr[i]; // 待插入的元素
                arr[i] = arr[i - dk];
                for (j = i - dk; j >= 0 && x < arr[j]; j = j - dk) {
                    // 通过循环，逐个后移一位找到要插入的位置
                    arr[j + dk] = arr[j];
                }
                arr[j + dk] = x; // 将数据插入对应的位置
            }
        }
    }
}
