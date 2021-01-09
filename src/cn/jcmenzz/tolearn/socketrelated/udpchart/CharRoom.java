package cn.jcmenzz.tolearn.socketrelated.udpchart;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CharRoom {
    public static void main(String[] args) {

    }
}

class TCPServer {
    private static final int PORT = 7788;

    public void listen() throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            final Socket client = serverSocket.accept();
            new Thread() {
                public void run() {
                    OutputStream os;
                    try {
                        os = client.getOutputStream();
                        System.out.println("2222");
                        os.write(("ssdd").getBytes());
                        Thread.sleep(5000);
                        System.out.println("2222");
                        os.close();
                        client.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}