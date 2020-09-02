package com.ixyf.example.bubbleSort;

public class BubbleSort_02 {

    public static void main(String[] args) {
        int data[] = {2, 23, 6, 22, 1, 77, 6, 9392, 10}; // 原始数组
        System.out.print("改良版冒泡排序法原始数据为： ");
        int i, j, tmp;
        System.out.print("原始数组为： ");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }

        for (i = data.length - 1; i >= 0; i--) {
            int flag = 0;
            for (j = 0; j < i; j++) {
                if (data[j+1] < data[j]) {
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                    flag++;
                }
            }
            if (flag == 0) break;
        }
        System.out.print("第" + (data.length - i) + "次排序：");
        for (j = 0; j < data.length; j++) {
            System.out.print(data[j] + " ");
            System.out.print("\n");
        }
    }
}
