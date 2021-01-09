package cn.jcmenzz.demo.ace;

import javax.swing.*;
import java.awt.*;

/**
 * 小红心类 Heart
 */
public class Heart extends FlyObject {
    //属性
    int xSpeed, ySpeed;//速度
    static Image[] images = new Image[9];

    //静态代码块
    static {
        for (int i = 0; i < images.length; i++) {
            images[i] = new ImageIcon("F:\\JavaProject\\Example\\Pic\\qq0" + i + ".png").getImage();
        }
    }

    //构造函数
    public Heart() {
        this.xSpeed = ((int) (Math.random() * 2)) >= 1 ? 3 : -3;
        this.ySpeed = (int) (Math.random() * 8) + 2;
        img = new ImageIcon("F:\\JavaProject\\Example\\Pic\\qq00.png").getImage();
        x = (int) (Math.random() * (512 - img.getWidth(null)));
        y = -img.getHeight(null);
        life = 100;
    }

    int index = 0;

    @Override
    public void move() {
        x += xSpeed;
        y += ySpeed;
        if (x <= 0 || x + img.getWidth(null) >= ShootFrame.WIDTH) {
            xSpeed = -xSpeed;
        }
        img = images[index++ / 5 % images.length];
        if (index == Integer.MAX_VALUE) {
            index = 0;
        }
    }
}
