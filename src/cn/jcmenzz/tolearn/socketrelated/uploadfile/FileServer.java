package cn.jcmenzz.tolearn.socketrelated.uploadfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端程序
 */
public class FileServer {
    public static void main(String[] args) throws Exception {
        //创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(10001);
        while (true) {
            //调用accept()方法接收客户端请求，得到Socket对象
            Socket s = serverSocket.accept();
            //每当和客户端建立Socket连接后，单独开启一个线程处理和客户端的交互
            new Thread(new ServerThread(s)).start();
        }
    }
}

class ServerThread implements Runnable {//服务器端开启新线程
    private Socket socket;//持有一个Socket类型的属性

    //构造方法中把Socket对象作为实参传入
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //获取客户端IP地址
        String ip = socket.getInetAddress().getHostAddress();
        int count = 1;//上传图片的个数
        try {
            InputStream in = socket.getInputStream();
            //创建上传图片目录的File对象
            File parentFile = new File("F:\\Practice\\java\\PIC");
            //若不存在这个目录，就创建这个目录
            if (!parentFile.exists()) {
                parentFile.mkdir();
            }
            //把客户端IP地址作为上传文件的文件名
            File file = new File(parentFile, ip + "(" + count + ").jpg");
            while (file.exists()) {
                //文件名存在，count+1
                file = new File(parentFile, ip + "(" + (count++) + ").jpg");
            }
            //创建FileOutputStream对象
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {//循环读取数据
                fos.write(buf, 0, len);
            }
            OutputStream out = socket.getOutputStream();
            out.write("上传成功".getBytes());
            fos.close();
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
