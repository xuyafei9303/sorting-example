package com.ixyf.example.mergeSort;

/**
 * 归并排序 分治法
 * 将待排序序列分为若干个子序列，先对每个子序列进行排序，等每个子序列都有序后，再将有序子序列合并为整体的有序序列
 * 若将两个有序表合并成一个有序表，则称之为二路归并
 *
 */
public class mergeSort {
    public static int[] mergeSort(int [] data) {
        sort(data, 0, data.length - 1);
        return data;
    }

    // 对左右两边的数据进行递归
    public static void sort(int[] data, int left, int right) {
        if (left >= right) return;
        // 找到中间索引
        int center = (left + right) / 2;
        // 对左边的数组进行递归排序
        sort(data, left, center);
        // 对右边的数组进行递归排序
        sort(data, center + 1, right);
        // 将两个数组合并
        merge(data, left, center, right);
    }

    private static void merge(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];
        // 右边数组第一个元素的索引
        int mid = center = 1;
        // 记录临时数组的索引
        int third = left;
        // 缓存左边数组第一个元素的数组
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的值放在临时数组中
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 将剩余部分依次放入临时数组中
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容复制到原数组中
        // (原left - right范围内的内容被复制到原数组中)
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }
}
