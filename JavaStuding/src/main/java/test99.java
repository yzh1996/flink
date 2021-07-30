import 线程_异常.myrunnable;

import java.io.*;
        import java.net.ServerSocket;
        import java.net.Socket;




public class test99 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket server = serverSocket.accept();
            System.out.println("获取到客户端连接");
            InputStream is = server.getInputStream();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    while (true) {
                        try {
                            String result = br.readLine();
                            if (result != null) {
                                System.out.println(thread+"-》"+result);
                            } else {
                                br.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}