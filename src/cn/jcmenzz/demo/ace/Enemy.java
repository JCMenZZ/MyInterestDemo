package cn.jcmenzz.demo.ace;

import javax.swing.*;
import java.awt.*;

/**
 * 敌机类 Enemy
 */
public class Enemy extends FlyObject {
    //属性
    int speed;//速度
    static Image[] images = new Image[7];

    //静态代码块
    static {
        for (int i = 0; i < images.length; i++) {
            images[i] = new ImageIcon("F:\\JavaProject\\Example\\Pic\\flys" + i + ".png").getImage();
        }
    }

    //构造方法
    public Enemy() {
        img = new ImageIcon("F:\\JavaProject\\Example\\Pic\\flys0.png").getImage();
        this.x = (int) (Math.random() * (512 - this.img.getWidth(null)));
        this.y = -this.img.getHeight(null);
        this.life = 100;
        this.speed = (int) (Math.random() * 5) + 2;
    }

    int index = 0;

    @Override
    public void move() {
        y += speed;
        //实现动态效果
        img = images[index++ / 8 % images.length];
        if (index == Integer.MAX_VALUE) {
            index = 0;
        }
    }
}
