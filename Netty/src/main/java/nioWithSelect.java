

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: nioWithSelect
 * @Author: yzh
 * @Description: NIO+多路复用器
 * @Date: 2021/3/21 11:00
 * @Version: 1.0
 */
public class nioWithSelect {
    /*
         1.生成server客户端
         2.注册多路复用器
     */
    public static void main(String[] args) throws IOException {
//        List<SelectableChannel> serverSockets = new ArrayList<>();
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.configureBlocking(false);//"192.168.1.3"
        ss.bind(new InetSocketAddress("192.168.52.111",9999));
        Selector selector = Selector.open();
        ss.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int requestClientNum = selector.select();// 查询是否请求，0 无限期阻塞，1000  阻塞1000ms
            if (requestClientNum > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    if (next.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                        SocketChannel serverAgent = channel.accept();
                        System.out.println("received client is :"+serverAgent+"->>>>>"+serverAgent.getRemoteAddress());
                        serverAgent.configureBlocking(false);
//                        Selector clientSelector = Selector.open();
                        serverAgent.register(selector, SelectionKey.OP_READ,byteBuffer);
                    } else if (next.isReadable()) {
                        while (true){
                            SocketChannel serverAgent = (SocketChannel) next.channel();
                            byteBuffer.clear();
                            int readSymbol = serverAgent.read(byteBuffer);
                            if (readSymbol > 0) {
                                byteBuffer.flip();
                                byte[] byteArr = new byte[byteBuffer.limit()];
                                String s = new String(byteArr);
                                System.out.println("the result is :" + s);
                            }
                            else  break;
                        }
                    }
                    selectionKeys.clear();
                }

            }
        }


    }
}
