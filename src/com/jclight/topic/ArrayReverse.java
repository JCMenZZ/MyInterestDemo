package com.jclight.topic;

/*
 * 需求：已知一个数组 arr = {19, 28, 37, 46, 50}; 用程序实现把数组中的元素值交换，
 * ​     交换后的数组 arr = {50, 46, 37, 28, 19}; 并在控制台输出交换后的数组元素。
 */

/**
 * 数组元素反转
 *
 * @author LightZZ
 * @date 2021/1/10 23:22
 */
public class ArrayReverse {
    public static void reverse(int[] arr) {
        for (int start = 0, end = arr.length - 1; start <= end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                System.out.print(arr[x]);
            } else {
                System.out.print(arr[x] + ", ");
            }
        }
        System.out.println("]");
    }
}
