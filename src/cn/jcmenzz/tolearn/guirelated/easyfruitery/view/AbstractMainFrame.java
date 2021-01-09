package cn.jcmenzz.tolearn.guirelated.easyfruitery.view;


import cn.jcmenzz.tolearn.guirelated.sqlfruitery.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 主窗口类
 */
@SuppressWarnings("serial")
public abstract class AbstractMainFrame extends JFrame {
    //组件
    private JLabel titleLabel = new JLabel(new ImageIcon("F:\\JavaProject\\Example\\Img\\超市.png"));
    private JButton btn = new JButton("进入系统");

    //初始化操作
    private void init() {
        this.setTitle("水果超市欢迎您！");
        this.setSize(600, 400);
        GUITools.center(this);
        GUITools.setTitleImage(this, "F:\\JavaProject\\Example\\Img\\超市图标.png");
        this.setResizable(false);//固定窗体大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //添加组件
    private void addComponent() {
        //窗体使用默认的边界布局，北部放入图片
        this.add(this.titleLabel, BorderLayout.NORTH);
        JPanel btnPanel = new JPanel();
        //清除布局，使JPanel中的组件可以自定义位置
        btnPanel.setLayout(null);
        this.add(btnPanel);
        //定义按钮的边界位置
        btn.setBounds(240, 20, 120, 50);
        btnPanel.add(btn);
    }

    //添加监听器
    private void addListener() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showAdminDialog();
            }
        });
    }

    //展示管理员界面方法
    public abstract void showAdminDialog();

    //构造函数
    public AbstractMainFrame() {
        this.init();
        this.addComponent();
        this.addListener();
    }
}
