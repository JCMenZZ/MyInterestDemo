package com.jclight.test.topic;

import org.junit.Test;

import java.io.File;

/**
 * @author LightZZ
 * @date 2021/1/17 23:53
 */
public class TopicTwoTest {
    /**
     * 需求1：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
     * 假如兔子都不死，问第二十个月的兔子对数为多少？
     * 模拟数据：月 1 2 3 4 5 6 ...
     * 模拟数据：对 1 1 2 3 5 8 ...
     * 递归实现
     */
    @Test
    public void question1() {
        System.out.println("第二十个月兔子的对数是：" + f(20));
    }

    /**
     * 需求2：给定一个路径(F:\资料\Practice\java)，通过递归完成遍历该目录下所有内容，并把所有文件的绝对路径输出在控制台
     */
    @Test
    public void question2() {
        File srcFile = new File("F:\\资料\\Practice\\java");
        //调用方法
        getAllFilePath(srcFile);
    }

    /**
     * 递归求解需求1
     *
     * @param month 月份
     * @return 兔子对数
     */
    public static int f(int month) {
        final int janMon = 1;
        final int febMon = 2;
        if (month == janMon || month == febMon) {
            return 1;
        } else {
            return f(month - 1) + f(month - 2);
        }
    }

    /**
     * 递归求解需求2
     *
     * @param srcFile File对象
     */
    public static void getAllFilePath(File srcFile) {
        //获取给定的File目录下所有的文件或者目录的File数组
        File[] fileArray = srcFile.listFiles();
        //遍历该File数组，得到每一个File对象
        if (fileArray != null) {
            for (File file : fileArray) {
                //判断该File对象是否是目录
                if (file.isDirectory()) {
                    getAllFilePath(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
