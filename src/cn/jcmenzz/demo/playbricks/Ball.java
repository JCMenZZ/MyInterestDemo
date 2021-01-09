package cn.jcmenzz.demo.playbricks;

import java.awt.*;

/**
 * 小球类
 */
public class Ball {
    int ball_x, ball_y, length;//小球坐标
    int ball_speed;//小球的速度
    Color color;//小球颜色
    int ball_state;//小球当前状态，共有四个状态（0~3），不同状态对应了小球不同的运动方向

    public Ball() {
        //初始化小球位置
        length = (int) (Math.random() * 20) + 80;
        ball_x = (int) (Math.random() * (600 - length));
        ball_y = (int) (Math.random() * (600 - length));
        //初始化速度、颜色
        ball_speed = (int) (Math.random() * 5) + 1;
        //初始化状态
        ball_state = (int) (Math.random() * 4);
        color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    //小球移动方法
    public void move() {
        //根据状态更改坐标,状态0代表右上，状态1代表右下，状态2代表左下，状态3代表左上
        if (ball_state == 0) {
            ball_x += ball_speed;
            ball_y -= ball_speed;
        }
        if (ball_state == 1) {
            ball_x += ball_speed;
            ball_y += ball_speed;
        }
        if (ball_state == 2) {
            ball_x -= ball_speed;
            ball_y += ball_speed;
        }
        if (ball_state == 3) {
            ball_x -= ball_speed;
            ball_y -= ball_speed;
        }
        //撞到边界更改状态
        if (ball_x <= 0) {
            //撞到左边界
            if (ball_state == 3) {
                ball_state = 0;
            }
            if (ball_state == 2) {
                ball_state = 1;
            }
        }
        if (ball_y <= 0) {
            //撞到上边界
            if (ball_state == 3) {
                ball_state = 2;
            }
            if (ball_state == 0) {
                ball_state = 1;
            }

        }
        if (ball_x + length >= 600) {
            //撞到右边界
            if (ball_state == 0) {
                ball_state = 3;
            }
            if (ball_state == 1) {
                ball_state = 2;
            }
        }
        if (ball_y + length >= 600) {
            //撞到下边界
            if (ball_state == 1) {
                ball_state = 0;
            }
            if (ball_state == 2) {
                ball_state = 3;
            }
        }
    }
}
