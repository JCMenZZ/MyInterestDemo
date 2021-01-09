package cn.jcmenzz.demo.ace;

import javax.swing.*;
import java.awt.*;

/**
 * 子弹类 Bullet
 */
public class Bullet extends FlyObject {
    //属性
    int speed;
    static Image bullet_img;

    static {
        bullet_img = new ImageIcon("F:\\JavaProject\\Example\\Pic\\bullets.png").getImage();
    }

    //构造
    public Bullet(int px, int py) {
        this.x = px;
        this.y = py;
        speed = 2;
    }

    @Override
    public void move() {
        y -= speed;
    }

    @Override
    public boolean outOfBounds() {
        if (y <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
