package cn.jcmenzz.tolearn.guirelated.sqlfruitery.controller;


import cn.jcmenzz.tolearn.guirelated.sqlfruitery.view.AbstractMainFrame;

/**
 * 主界面操作类
 */
@SuppressWarnings("serial")
public class MainFrameController extends AbstractMainFrame {
    @Override
    public void showAdminDialog() {
        //在该方法中创建管理员界面并显示
        //this--父窗口  true--设置为模态窗口显示
        new AdminDialogController(this, true).setVisible(true);
    }
}
