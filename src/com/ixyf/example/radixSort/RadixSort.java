package com.ixyf.example.radixSort;

/**
 * 基数排序
 * 桶排序算法的扩展，将数据按位切割为不同的数字，位数不够的补0，然后在每个位数上分别进行比较，最终得到排好序的序列
 * 将所有带比较的数据统一为同一长度，在位数不够时前面补0，然后从低位到高位根据每个位上整数的大小依次对数据进行排序，最终得到一个有序序列
 */
public class RadixSort {
    /**
     *
     * @param array 数组
     * @param maxDigit 数组最大位数
     * @return
     */
    public static int[] radixSort(int[] array, int maxDigit) {
        // 数组最大位数的数据上限，比如三位数的最大上限为1000
        double max = Math.pow(10, maxDigit + 1);
        int n = 1; // 代表位数对应的1，10，100...
        int k = 0; // 保存每一位排序后的结果用于下一位的排序输入
        int length = array.length;
        // bucket用于保存每次排序后的结果，将当前位上排序结果相同的数字放在同一个桶中
        int[][] bucket = new  int[10][length];
        int[] order = new int[length]; // 用于保存每个桶里有多少数字
        while (n < max) {
            for (int num: array) { // 将数组array里的每个数字都放在相应的桶里
                int digit = (num / n) % 10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }
            // 将前一个循环生成的桶里的数据覆盖到原数组中，用于保存这一位的排序结果
            for (int i = 0; i < length; i++) {
                // 在这个桶里有数据，从上往下遍历这个痛并将数据保存到原数组中
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        array[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0; // 将桶中的计算器设置为0，用于下一次排序
            }
            n *= 10;
            k = 0; // 将k设置为0，用于下一轮保存位排序结果
        }
        return array;
    }
}
