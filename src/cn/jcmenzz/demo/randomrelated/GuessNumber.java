package cn.jcmenzz.demo.randomrelated;

import java.util.Random;
import java.util.Scanner;

/**
 * 猜十以内的数字
 *
 * @author JCMANZZ
 * @date 2020/10/29 17:46
 */
public class GuessNumber {
    public static void main(String[] args) {
        int randomNumber = new Random().nextInt(10);
        System.out.println("随机数已生成！");
        System.out.println("请输入你所猜的数字：");
        Scanner sc = new Scanner(System.in);
        int enterNumber = sc.nextInt();
        while (enterNumber != randomNumber) {
            if (enterNumber > randomNumber) {
                System.out.println("Sorry 您猜大了！");
            } else {
                System.out.println("Sorry 您猜小了！");
            }
            System.out.println("请重新猜一个数：");
            enterNumber = sc.nextInt();
        }
        System.out.println("恭喜您，答对了！");
    }
}

