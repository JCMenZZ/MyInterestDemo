package cn.jcmenzz.tolearn.socketrelated.udpchart;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端任务
 */
public class ReceiveTask implements Runnable {
    private int receivePort;//接收数据端口号

    public ReceiveTask(int receivePort) {
        this.receivePort = receivePort;
    }

    @Override
    public void run() {
        try {
            //创建DatagramSocket对象
            DatagramSocket ds = new DatagramSocket(receivePort);
            //创建DatagramPacket对象
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            //接收数据
            while (true) {
                ds.receive(dp);
                //显示数据
                String str = new String(dp.getData(), 0, dp.getLength());
                System.out.println("收到" + dp.getAddress().getHostAddress() + "发送数据" + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
