import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: BIO
 * @Author: yzh
 * @Description: 服务端接受客户端发送来的数据并打印
 * @Date: 2021/3/17 20:37
 * @Version: 1.0
 */
public class BIO {
    /*
    步骤：
        1.启动服务端
        2.等待客户端响应
        3.获取输入流，读取数据
        4.打印输出
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true){
            Socket serverAgent = server.accept();
            System.out.println("有客户端连接");
            InputStream is = serverAgent.getInputStream();// todo 把这段代码放进new Thread里面和放在这里有什么区别？？
            new Thread(() -> {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));  //这段放在thread里面和放在上面有什么区别
                while (true) {
                    String receMessage = null;
                    try {
                        receMessage = br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (receMessage != null) {
                        System.out.println("received message is :" + receMessage);
                    }
                }
            }).start();
            //todo 为什么下面这段代码 放进上面的一个新的线程里面就会报ioException,而放在这里就不会
           /* while (true){
                InputStream is = serverAgent.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String receMessage = br.readLine();
                while (receMessage !=null){
                    System.out.println("received message is :"+receMessage);
                }
            }*/
        }


    }
}
