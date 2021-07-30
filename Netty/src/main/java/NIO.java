
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @ClassName: NIO
 * @Author: yzh
 * @Description: 需要设置两个地方非阻塞，一个是读取是否有客户端连接时，另一个是读取客户端是否有发送数据时
 * @Date: 2021/3/17 22:10
 * @Version: 1.0
 */
public class NIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);  //false为非阻塞  //todo first way need to set NONBLOCK
        ssc.bind(new InetSocketAddress("192.168.52.111",9999));
        while (true) {
            Thread.sleep(3000);
            SocketChannel serverAgent = ssc.accept();
              //todo  the second way need to set NonBlock
            System.out.println("the request Client is ：" + (serverAgent == null ? serverAgent:serverAgent.getClass().getSimpleName()));
            ByteBuffer byteBuffer = ByteBuffer.allocate(4096);//allocate堆内缓存，directallocate堆外缓存
            if (serverAgent != null) {
                Thread.sleep(3000);
                serverAgent.configureBlocking(false);
                int receMessage = serverAgent.read(byteBuffer);
                if (receMessage > 0) {  //>0有数据， =0 没发数据，-1异常
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.limit()];
                    String accMess = new String(bytes);
                    System.out.println("received Message is :" + accMess);
                    byteBuffer.clear();
                }
            }
        }

    }
}
