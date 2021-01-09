package cn.jcmenzz.demo.iorelated;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 简单的控制台记事本程序
 *
 * @author JCMANZZ
 * @date 2020/10/30 15:59
 */
public class Notepad {

    private static String filePath;
    private static String message = "";

    /**
     * 新建文件  从控制台获取内容
     */
    private static void createFile() {
        message = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件内容，停止编写时请输入\"stop\":");
        //用来后期输入内容的拼接
        StringBuffer stb = new StringBuffer();
        String inputMessage = "";
        //判断当输入stop时，停止输入
        while (!inputMessage.equals("stop")) {
            if (stb.length() > 0) {
                //追加换行符
                stb.append("\r\n");
            }
            //拼接输入信息
            stb.append(inputMessage);
            //获取输入信息
            inputMessage = sc.nextLine();
        }
        //将输入内容暂存
        message = stb.toString();
    }

    /**
     * 打开文件
     *
     * @throws Exception
     */
    private static void openFile() throws Exception {
        //打开文件时，将暂存内容清空
        message = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入打开文件的位置：");
        //接收文件路径
        filePath = sc.next();
        //判断路径最后是否为.txt文件
        if (filePath != null && !filePath.endsWith(".txt")) {
            System.out.print("请选择文本文件！");
            return;
        }
        FileReader in = new FileReader(filePath);
        //缓冲数组
        char[] charArray = new char[1024];
        int len = 0;
        StringBuffer sb = new StringBuffer();
        //循环读取，一次读取一个字符数组
        while ((len = in.read(charArray)) != -1) {
            sb.append(charArray);
        }
        //将打开文件内容暂存
        message = sb.toString();
        System.out.println("打开文件内容：" + "\r\n" + message);
        in.close();
    }

    /**
     * 修改文件内容  通过字符串替换的方式
     */
    private static void editFile() {
        if (message == "" && filePath == null) {
            System.out.println("请先新建文件或者打开文件！");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的内容（以\"修改的目标文字：修改之后的文字\"格式），" + "停止修改请输入\"stop\"：");
        String inputMessage = "";
        while (!inputMessage.equals("stop")) {
            inputMessage = sc.nextLine();
            if (inputMessage != null && inputMessage.length() > 0) {
                //将输入的文字根据":"拆分成数组
                String[] editMessage = inputMessage.split(":");
                if (editMessage != null && editMessage.length > 1) {
                    //根据输入的信息将文件中的内容替换
                    message = message.replace(editMessage[0], editMessage[1]);
                }
            }
        }
        System.out.println("修改后的内容：" + "\r\n" + message);
    }

    /**
     * 保存 新建文件存在用户输入的路径  打开的文件将原文件覆盖
     *
     * @throws IOException
     */
    private static void saveFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter out = null;
        //文件是由"打开"载入的
        if (filePath != null) {
            //将原文件覆盖
            out = new FileWriter(filePath);
        } else {//新建的文件
            System.out.print("请输入文件保存的绝对路径:");
            String path = sc.next();
            filePath = path;
            //将输入路径中大写字母替换成小写字母后判断是不是文本格式
            if (!filePath.toLowerCase().endsWith(".txt")) {
                filePath += ".txt";
            }
            out = new FileWriter(filePath);
        }
        //写入暂存的内容
        out.write(message);
        out.close();//关闭输出流
        message = "";
        filePath = null;
    }

    /**
     * 退出
     */
    private static void exit() {
        System.out.println("您已退出系统，谢谢使用！");
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("--1：新建文件  2：打开文件  3：修改文件  4：保存  5：退出--");
        while (true) {
            System.out.print("请输入操作指令：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    createFile();//1：新建文件
                    break;
                case 2:
                    openFile();//2：打开文件
                    break;
                case 3:
                    editFile();//3：修改文件
                    break;
                case 4:
                    saveFile();//4：保存文件
                    break;
                case 5:
                    exit();//5：退出
                    break;
                default:
                    System.out.println("输入指令有误！！！");
                    break;
            }
        }
    }
}


