package cn.jcmenzz.tolearn.socketrelated.udpchart;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 发送端任务
 */
public class SendTask implements Runnable {
    private int sendPort;//发送端端口号

    //构造方法
    public SendTask(int sendPort) {
        this.sendPort = sendPort;
    }

    @Override
    public void run() {
        try {
            //创建DatagramSocket对象
            DatagramSocket ds = new DatagramSocket();
            //输入发送的数据
            Scanner sc = new Scanner(System.in);
            while (true) {
                String data = sc.nextLine();
                //将数据封装到DatagramPacket对象
                byte[] buf = data.getBytes();
                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.255"), sendPort);
                //发送数据
                ds.send(dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
