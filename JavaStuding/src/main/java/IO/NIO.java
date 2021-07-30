package IO;

import scala.math.Ordering;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIO {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ss = ServerSocketChannel.open();
            ss.bind(new InetSocketAddress(9999));
            ss.configureBlocking(false) ; //设置为非阻塞,调用ss.accept()就会是非阻塞的了
            while (true){
                SocketChannel serverSocket = ss.accept();   //要么返回一个SocketChannel对象，要么返回一个null
                serverSocket.configureBlocking(false);       //
                System.out.println("有客户端请求");
                while (true){
                    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);
                    int result = serverSocket.read(byteBuffer);     //result:  0客户端没发送数据，-1出错，》0客户端有发送数据
                    if (result>0){
                       byteBuffer.flip();
                        byte[] bytes = new byte[byteBuffer.limit()];
                         byteBuffer.get(bytes);//将buffer里面的数据复制到bytes字节数组中
                        String finallyResult = new String(bytes);
                        System.out.println(finallyResult);
                        byteBuffer.clear();

                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
