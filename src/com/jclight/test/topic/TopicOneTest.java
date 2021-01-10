package com.jclight.test.topic;

import org.junit.Test;

/**
 * @author LightZZ
 * @date 2021/1/10 2:05
 */
public class TopicOneTest {
    /**
     * 需求：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
     * 假如兔子都不死，问第二十个月的兔子对数为多少？
     */
    @Test
    public void question1(){
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for(int x=2; x<arr.length; x++) {
            arr[x] = arr[x-2] + arr[x-1];
        }
        System.out.println("第二十个月兔子的对数是：" + arr[19]);
    }

}
