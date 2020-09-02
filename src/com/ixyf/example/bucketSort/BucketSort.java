package com.ixyf.example.bucketSort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序算法
 * 将数组分到有限数量的桶中，对每个桶在进行排序（有可能使用其他排序算法或者以递归的方式继续使用桶排序进行排序）,最后将各个桶合并。
 * 找出数组中的最大值和最小值，并根据最大值和最小值定义桶，然后将数据按照大小放入桶中，最后对每个桶进行排序，在每个桶的内部完成排序后，就得到了完整的排序树组
 *
 * 1.在待排序数组中找出最大值max和最小值min，并根据bucketNum = (max - min) / arr.length +1创建bucketNum个桶
 * 2.遍历待排序的数组arr，计算每个元素arr[i]的大小并放入桶中
 * 3.对每个桶进行排序，在每个桶的内部排序完成后就得到了完整的排序树组
 */
public class BucketSort {
    public static int[] bucketSort(int [] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(max, arr[i]);
        }
        // 创建通
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        // 将每个元素都放在桶中
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        // 对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }
        return arr;
    }
}
