package cn.jcmenzz.demo.ace;

import java.awt.*;

/**
 * 抽象类，表示飞行物
 */
public abstract class FlyObject {
    //属性
    int x, y, life, magic;
    Image img;

    //构造函数
    public FlyObject() {
        magic = 100;
    }

    //方法
    public abstract void move();

    //飞行物是否越界
    public boolean outOfBounds() {
        if (y > ShootFrame.HEIGHT) {
            return true;
        } else {
            return false;
        }
    }
}
