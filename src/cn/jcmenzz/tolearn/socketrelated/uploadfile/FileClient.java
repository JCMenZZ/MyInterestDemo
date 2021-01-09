package cn.jcmenzz.tolearn.socketrelated.uploadfile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 10001);
        OutputStream out = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("F:\\Practice\\java\\BZ00.jpg");
        byte[] buf = new byte[1024];
        int len;
        while ((len = fis.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        socket.shutdownOutput();//关闭客户端输出流
        InputStream in = socket.getInputStream();
        byte[] bufMsg = new byte[1024];
        int num = in.read(bufMsg);
        String Msg = new String(bufMsg, 0, num);
        System.out.println(Msg);
        fis.close();
        socket.close();
    }
}
