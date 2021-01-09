package cn.jcmenzz.demo.playbricks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 程序运行的内窗体
 * @author lenovo
 */
public class BallPanel extends JPanel implements MouseMotionListener {
    //使用集合初始化小球
    ArrayList<Ball> ballArray = new ArrayList<Ball>();
    int initBallNum = 1;
//    ArrayList<Brick> bricks = new ArrayList<Brick>();
//    int initBrickNum = 60;
    //初始化挡板
    int apron_x = 500, apron_y = 500, apron_width = 200, apron_height = 20;

    public BallPanel() {
        for (int i = 0; i < initBallNum; i++) {
            ballArray.add(new Ball());
        }
//
//        for (int i = 0; i < initBrickNum; i++) {
//            Brick brick = new Brick();
//            bricks.add(brick);
//            for (int j = 0; j < i; j++) {
//                int j_x = bricks.get(j).brick_x + bricks.get(j).brick_width / 2;
//                int i_x = brick.brick_x + brick.brick_width / 2;
//                int distance = Math.abs(j_x - i_x);
//                if (distance < brick.brick_width && bricks.get(i).brick_y == brick.brick_y) {
//                    bricks.remove(i);
//                    i--;
//                    break;
//                }
//            }
//        }
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(apron_x, apron_y, apron_width, apron_height);
        for (int i = 0; i < ballArray.size(); i++) {
            Ball ball = ballArray.get(i);
            g.setColor(ball.color);
            g.fillOval(ball.ball_x, ball.ball_y, ball.length, ball.length);
        }
//        for (int i = 0; i < bricks.size(); i++) {
//            Brick brick = bricks.get(i);
//            g.drawImage(brick.img, brick.brick_x, brick.brick_y, brick.brick_width, brick.brick_height, null);
//        }
    }

    public void action() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < ballArray.size(); i++) {
                    Ball ball = ballArray.get(i);
                    ball.move();
                }
                //碰撞
                hit();
                repaint();
            }
        }, 0, 10);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        apron_x = mouseEvent.getX() - apron_width / 2;
    }

    //小球撞到挡板的处理方法
    public void hit() {
        //得到挡板的坐标
        int apron_x1 = apron_x;//左上角x
        int apron_y1 = apron_y;//左上角y
        int apron_x2 = apron_x + apron_width;//右上角x
        int apron_y3 = apron_y + apron_height;//左下角y
        for (int i = 0; i < ballArray.size(); i++) {
            Ball ball = ballArray.get(i);
            int ball_x = ball.ball_x + ball.length / 2;
            int ball_y = ball.ball_y + ball.length;
            //挡板接球
            if (ball_x >= apron_x1 && ball_x <= apron_x2 && ball_y >= apron_y1 && ball_y <= apron_y3) {
                if (ball.ball_state == 1) {
                    ball.ball_state = 0;
                }
                if (ball.ball_state == 2) {
                    ball.ball_state = 3;
                }
            }
            //左边没接住小球
            if (ball_x <= apron_x1 && ball_y >= apron_y1) {
                ballArray.remove(i);
            }
            //右边没接住小球
            if (ball_x >= apron_x2 && ball_y >= apron_y1) {
                ballArray.remove(i);
            }

        }
    }
}
