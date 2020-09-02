package com.ixyf.example.binarySearch;

/**
 * 二分查找法
 * 必要条件：要查找的集合必须是有序的
 */
public class BinarySearch {
    public static int binarySearch(int [] arrays, int target) {
        int low = 0; // 头
        int high = arrays.length - 1; // 尾
        int mid; // 中间
        while (low <= high) {
            mid = (high - low) / 2 + low; // 中间位置
            if (arrays[mid] == target) {
                return mid;
            } else if (target > arrays[mid]) { // 要查找的元素在mid后面 则去后面部分找
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
