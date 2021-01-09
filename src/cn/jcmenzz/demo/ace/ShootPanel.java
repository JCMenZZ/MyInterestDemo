package cn.jcmenzz.demo.ace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 面板类 ShootPanel
 * @author lenovo
 */
public class ShootPanel extends JPanel implements MouseMotionListener {
    /**
     * backgroundImg 设置背景图片
     * gg,jj 标签图像属性
     */
    Image backgroundImg = new ImageIcon("F:\\JavaProject\\Example\\Pic\\background.jpg").getImage();
    Image gg, jj;
    int backgroundX = 0, backgroundY = 0;//背景图片的坐标
    Hero hero = new Hero();//英雄战机对象
    Boss boss = new Boss();//Boss对象
    ArrayList<FlyObject> flyObjects = new ArrayList<FlyObject>();//存储飞行物的集合

    //构造方法
    public ShootPanel() {
        addMouseMotionListener(this);//添加鼠标事件的监听对象
        //标签图像
        gg = new ImageIcon("F:\\JavaProject\\Example\\Pic\\gg.png").getImage();
        jj = new ImageIcon("F:\\JavaProject\\Example\\Pic\\jj.png").getImage();
    }

    //重写paint方法
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        //设置Panel的背景图片并使其可以连续滚动
        graphics.drawImage(backgroundImg, backgroundX, backgroundY, ShootFrame.WIDTH, ShootFrame.HEIGHT, null);
        graphics.drawImage(backgroundImg, backgroundX, backgroundY - ShootFrame.HEIGHT, ShootFrame.WIDTH, ShootFrame.HEIGHT, null);
        //绘制英雄战机
        graphics.drawImage(hero.img, hero.x, hero.y, null);
        //绘制小图标
        graphics.drawImage(gg, 5, 660, null);
        //绘制关卡
        graphics.drawImage(jj, 340, 10, null);
        //绘制飞行物
        flyObjectPaint(graphics);
        //绘制分数、金币
        scorePaint(graphics);
        //绘制Boss
//        graphics.drawImage(boss.img, 100, ShootFrame.HEIGHT, null);
//        graphics.drawImage(boss.img, 100, backgroundY, null);

    }

    //自定义方法，表示游戏启动
    public void action() {
        //创建定时器对象
        Timer timer = new Timer();
        //启动定时器
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                backgroundY++;//背景图片运动
                //将两张图片拼接起来
                if (backgroundY >= ShootFrame.HEIGHT) {
                    backgroundY = 0;
                }
                repaint();//重绘
                hero.step();//调用方法  实现英雄战机的动态效果
                bulletHitEnemy();//子弹碰到敌机
                HeroHitHeart();//战机碰到红心
                flyObjectAction();//产生飞行物
                outOfBounds();//飞行物越界处理
                flyObjectMove();//飞行物的移动
            }
        }, 0, 10);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        //获取坐标并赋值给战机
        hero.x = mouseEvent.getX() - hero.img.getWidth(null) / 2;
        hero.y = mouseEvent.getY() - hero.img.getHeight(null) / 2;
    }

    //控制变量 对产生的Enemy对象进行约束
    int flyObjectIndex = 0;

    //产生飞行物
    public void flyObjectAction() {
        flyObjectIndex++;
        if (flyObjectIndex % 35 == 0) {
            flyObjects.add(new Enemy());
        }
        if (flyObjectIndex % 25 == 0) {
            flyObjects.add(new Heart());
        }

        if (flyObjectIndex % 15 == 0) {
            //发射子弹
            flyObjects.addAll(hero.shoot());
        }
        if (flyObjectIndex == Integer.MAX_VALUE) {
            flyObjectIndex = 0;
        }

    }

    //绘制飞行物
    public void flyObjectPaint(Graphics graphics) {
        for (int i = 0; i < flyObjects.size(); i++) {
            FlyObject f = flyObjects.get(i);
            //判断集合中得到的对象是否是Bullet类型的对象
            if (f instanceof Bullet) {
                Bullet b = (Bullet) f;
                graphics.drawImage(b.bullet_img, b.x, b.y, null);
            }
            graphics.drawImage(f.img, f.x, f.y, null);
        }
    }

    //移动飞行物
    public void flyObjectMove() {
        for (int i = 0; i < flyObjects.size(); i++) {
            FlyObject f = flyObjects.get(i);
            f.move();
        }
    }

    //飞行物越界处理
    public void outOfBounds() {
        for (int i = 0; i < flyObjects.size(); i++) {
            FlyObject f = flyObjects.get(i);
            if (f.outOfBounds()) {
                flyObjects.remove(i);
            }
        }
    }

    //绘制分数生命金币等
    public void scorePaint(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("宋体", Font.BOLD, 28));
        graphics.drawString("得分：" + hero.score, 350, 710);
        graphics.drawString("金币：" + hero.gold, 230, 710);
        graphics.drawString("生命：" + hero.life, 80, 710);
        graphics.setColor(Color.GREEN);
        graphics.drawString("关卡：" + (hero.score / 1000 + 1), 370, 30);
    }

    //子弹碰到敌机或战机碰到敌机
    public void bulletHitEnemy() {
        ArrayList<Bullet> bs = new ArrayList<Bullet>();
        ArrayList<Enemy> es = new ArrayList<Enemy>();
        for (int i = 0; i < flyObjects.size(); i++) {
            FlyObject f = flyObjects.get(i);
            if (f instanceof Bullet) {
                bs.add((Bullet) f);
            } else if (f instanceof Enemy) {
                es.add((Enemy) f);
            }
        }
        //判断坐标是否重叠（战机碰到敌机）
        for (int i = 0; i < es.size(); i++) {
            Enemy e = es.get(i);
            if (hero.x >= e.x && hero.x <= e.x + e.img.getWidth(null) && hero.y >= e.y &&
                    hero.y <= e.y + e.img.getHeight(null)) {
                hero.life--;
                if (hero.life == 0) {
                    //弹出对话框并提示游戏结束
                }
            }
        }
        //判断坐标是否重叠（子弹碰到敌机）
        for (int i = 0; i < bs.size(); i++) {
            Bullet b = bs.get(i);
            for (int j = 0; j < es.size(); j++) {
                Enemy e = es.get(j);
                if (b.x >= e.x && b.x <= e.x + e.img.getWidth(null) &&
                        b.y >= e.y && b.y <= e.y + e.img.getHeight(null)) {
                    hero.score++;
                    flyObjects.remove(b);
                    flyObjects.remove(e);
                }
            }
        }
    }

    //战机碰到红心
    public void HeroHitHeart() {
        ArrayList<Heart> hearts = new ArrayList<Heart>();
        for (int i = 0; i < flyObjects.size(); i++) {
            FlyObject f = flyObjects.get(i);
            if (f instanceof Heart) {
                hearts.add((Heart) f);
            }
        }
        //判断坐标是否重叠
        for (int i = 0; i < hearts.size(); i++) {
            Heart h = hearts.get(i);
            if (hero.x >= h.x && hero.x <= h.x + h.img.getWidth(null) && hero.y >= h.y &&
                    hero.y <= h.y + h.img.getHeight(null)) {
                hero.gold++;
                if (hero.gold >= 30 || (hero.gold >= 20 && hero.gold <= 30)) {
                    if (hero.gold >= 30) {
                        hero.doubleFire = 2;
                        hero.gold = 0;
                    } else {
                        hero.doubleFire = 1;
                    }
                }
                flyObjects.remove(h);
            }
        }
    }

}
