package cn.jcmenzz.demo.ace;

import javax.swing.*;

/**
 * 主界面类 ShootFrame
 */
public class ShootFrame extends JFrame {
    //属性（宽和高）
    public static final int WIDTH = 512; //静态常量，表示屏幕宽度
    public static final int HEIGHT = 768;  //静态常量，表示屏幕高度
    ShootPanel shootPanel = new ShootPanel();//声明面板类对象

    //构造函数
    public ShootFrame() {
        this.setTitle("雷霆战机");
        this.setSize(WIDTH, HEIGHT);
        shootPanel.action();
        this.add(shootPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //程序运行的入口
    public static void main(String[] args) {
        ShootFrame shootFrame = new ShootFrame();
    }
}
