package com.jclight.test.topic;

import com.jclight.topic.ArrayReverse;
import org.junit.Test;

/**
 * @author LightZZ
 * @date 2021/1/10 2:05
 */
public class TopicOneTest {
    /**
     * 需求：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
     * 假如兔子都不死，问第二十个月的兔子对数为多少？
     * 模拟数据：月 1 2 3 4 5 6 ...
     * 模拟数据：对 1 1 2 3 5 8 ...
     */
    @Test
    public void question1() {
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int x = 2; x < arr.length; x++) {
            arr[x] = arr[x - 2] + arr[x - 1];
        }
        System.out.println("第二十个月兔子的对数是：" + arr[19]);
    }

    /**
     * 需求：我国古代数学家张丘建在《算经》一书中提出的数学问题：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。
     * 百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
     * 解析：
     * 鸡的数量：0 < x <= 20 （鸡翁）  0 < y <= 33 （鸡母）  0 < z <= 100 （鸡雏）
     * 鸡的价钱：5 * x + 3 * y + z / 3 = 100    z % 3 = 0
     */
    @Test
    public void question2() {
        int count = 0;
        //第1层循环：用于表示鸡翁的范围
        for (int x = 0; x <= 20; x++) {
            //第2层循环：用于表示鸡母的范围
            for (int y = 0; y <= 33; y++) {
                int z = 100 - x - y;
                //判断表达式 z%3==0 和表达式 5*x + 3*y + z/3 = 100 是否同时成立
                if (z % 3 == 0 && 5 * x + 3 * y + z / 3 == 100) {
                    System.out.println("鸡翁：" + x + "只 " + "鸡母：" + y + "只 " + "鸡雏：" + z + "只");
                    count++;
                }
            }
        }
        System.out.println("满足条件的情况有" + count + "种");
    }

    /**
     * 数组反转测试
     */
    @Test
    public void question3() {
        int[] arr = {19, 28, 37, 46, 50};
        //输出数组
        System.out.print("反转前：");
        ArrayReverse.printArray(arr);
        //调用反转的方法
        ArrayReverse.reverse(arr);
        //输出数组
        System.out.print("反转后：");
        ArrayReverse.printArray(arr);
    }
}
