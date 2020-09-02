package com.ixyf.example.bubbleSort;

/**
 * 冒泡排序/交换排序法
 * 示例升序
 * 由第一个元素开始，比较相邻两个元素，如果前者大于后者，则交换两者位置再进行下一个元素的比较
 * 如此扫描过一次之后就能确定最后一个元素为最大的元素，确定下来最大了
 * 逐步进行第二轮比较，直到完成所有元素的排序
 * （如果要进行降序排列，只需要比较最小的后移就可以了）
 * 稳定排序法，空间复杂度最佳，只需要一个额外空间O(1)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int data[] = {2,23,6,22,1,77,6,9392,10}; // 原始数组
        int i, j, tmp;
        System.out.println("冒泡排序法：");
        System.out.print("原始数组为： ");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        for (i = data.length - 1; i > 0; i--) { // 比较次数
            for (j = 0; j < i; j++) { // 比较、交换次数
                // 比较相邻两数，如第一数较大则交换
                if (data[j] > data[j+1]) {
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
            // 把各次扫描后的结果打印
            System.out.print("第" + (data.length - i) + "次排序后的结果是： ");
            for (j = 0; j < data.length; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("排序后的结果为： ");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
    }
}
