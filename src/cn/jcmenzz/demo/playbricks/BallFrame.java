package cn.jcmenzz.demo.playbricks;

import javax.swing.*;

/**
 * 程序运行主窗体
 */
public class BallFrame extends JFrame {
    public BallFrame() {
        setTitle("打砖块");
        setSize(600, 600);
        BallPanel ballPanel = new BallPanel();
        ballPanel.action();
        this.add(ballPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BallFrame frame = new BallFrame();
    }
}
