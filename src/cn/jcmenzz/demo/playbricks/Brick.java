package cn.jcmenzz.demo.playbricks;

import javax.swing.*;
import java.awt.*;

/**
 * 砖块类
 */
public class Brick {
    int brick_x, brick_y;//砖块的位置
    int brick_width, brick_height;//砖块的大小
    Color color;//砖块的颜色
    Image img;//砖块图片

    public Brick() {
        //初始化砖块的大小
        brick_width = 80;
        brick_height = 20;
        //初始化砖块颜色
        color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        //初始化砖块的位置
        brick_x = (int) (Math.random() * (600 - brick_width));
        brick_y = (int) (Math.random() * 5) * brick_height;
        img = new ImageIcon("F:\\JavaProject\\Example\\Img\\brick.png").getImage();
    }
}
