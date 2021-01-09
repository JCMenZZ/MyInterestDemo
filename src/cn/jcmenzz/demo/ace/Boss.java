package cn.jcmenzz.demo.ace;

import javax.swing.*;
import java.awt.*;

/**
 * Boss，在一定的机制下在屏幕的下方产生后向上运动
 * 运动上屏幕上方后再往下返回（此过程是无敌状态），
 * 当返回到一定的位置后，开始左右移动，解除无敌状态，可以被攻击
 * @author lenovo
 */
public class Boss extends FlyObject {
    //属性
    static Image[] beginImg = new Image[2];

    //静态代码块
    static {
        for (int i = 0; i < beginImg.length; i++) {
            beginImg[i] = new ImageIcon("F:\\JavaProject\\Example\\Pic\\bosss" + i + ".PNG").getImage();
        }
    }

    //构造方法
    public Boss() {
        img = new ImageIcon("F:\\JavaProject\\Example\\Pic\\bosss0.PNG").getImage();
    }

    //自定义方法
    @Override
    public void move() {

    }
}
