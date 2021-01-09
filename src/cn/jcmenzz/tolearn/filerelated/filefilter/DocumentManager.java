package cn.jcmenzz.tolearn.filerelated.filefilter;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentManager {
    /**
     * 指令1:指定关键字检索文件
     */
    private static void searchByKeyWorld() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要检索的目录位置：");
        String path = sc.next();
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println(path + "(不是有效目录)");
            return;
        }
        System.out.print("请输入搜索关键字：");
        String key = sc.next();
        //在目标目录下获取所有包含关键字的文件路径
        ArrayList<String> list = FileUtils.listFiles(file, key);
        for (Object obj : list) {
            System.out.println(obj);//将路径打印在控制台
        }
    }

    /**
     * 2：指定后缀名检索文件
     */
    private static void searchBySuffix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要检索的目录位置：");
        String path = sc.next();
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println(path + "(不是有效目录)");
            return;
        }
        System.out.print("请输入搜索后缀：");
        String suffix = sc.next();
        String[] suffixArray = suffix.split(",");
        ArrayList<String> list = FileUtils.listFiles(file, suffixArray);
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    /**
     * 复制文件/目录
     *
     * @throws Exception
     */
    private static void copyDirectory() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入源目录:");
        String srcDirectory = sc.next();
        File srcFile = new File(srcDirectory);
        if (!srcFile.exists() || !srcFile.isDirectory()) {
            System.out.println("无效目录");
            return;
        }
        System.out.print("请输入目标位置：");
        String destDirectory = sc.next();
        File destFile = new File(destDirectory);
        if (!destFile.exists() || !destFile.isDirectory()) {
            System.out.println("无效位置！");
            return;
        }
        FileUtils.copySrcPathToDestPath(srcFile, destFile);
    }

    /**
     * 退出
     */
    private static void exit() {
        System.out.println("您已退出系统，谢谢使用！！！");
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("--1：指定关键字检索文件  2：指定后缀名检索文件  3：复制文件/目录  4：退出--");
        while (true) {
            System.out.print("请输入指令：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    searchByKeyWorld();
                    break;
                case 2:
                    searchBySuffix();
                    break;
                case 3:
                    copyDirectory();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("您输入的指令有误！");
                    break;
            }
        }
    }
}
