package cn.jcmenzz.demo.ace;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * 英雄飞机类
 */
public class Hero extends FlyObject {
    //属性
    int doubleFire;//1表示单倍火力，2表示双倍火力
    int score, gold;//分数、金币
    Image[] images = new Image[10];

    //构造函数
    public Hero() {
        this.x = 210;//英雄战机的左顶点的x坐标
        this.y = 500;//英雄战机的左顶点的y坐标
        this.life = 100;
        this.magic = 100;
        this.img = new ImageIcon("F:\\JavaProject\\Example\\Pic\\ws00.png").getImage();
        this.doubleFire = 1;
        this.score = 0;
        this.gold = 0;
        for (int i = 0; i < images.length; i++) {
            this.images[i] = new ImageIcon("F:\\JavaProject\\Example\\Pic\\ws0" + i + ".png").getImage();
        }
    }

    @Override
    public void move() {

    }

    //自定义方法  射击
    public ArrayList<Bullet> shoot() {
        ArrayList<Bullet> bullets = new ArrayList<Bullet>();
        if (doubleFire == 1) {
            Bullet bullet = new Bullet(x + img.getWidth(null) / 2, y);
            bullets.add(bullet);
        } else if (doubleFire == 2) {
            Bullet b1 = new Bullet(x, y);
            Bullet b2 = new Bullet(x + img.getWidth(null), y);
            bullets.add(b1);
            bullets.add(b2);
        }
        return bullets;
    }

    int index = 0;

    //实现英雄战机的动态效果
    public void step() {
        img = images[index++ / 10 % images.length];
        if (index == Integer.MAX_VALUE) {
            index = 0;
        }
    }
}
