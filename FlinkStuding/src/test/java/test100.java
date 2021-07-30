import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.http.client.methods.HttpPost;

import java.util.Random;

/**
 * @ClassName: test100
 * @Author: yzh
 * @Description:
 * @Date: 2021/5/13 15:29
 * @Version: 1.0
 */
public class test100 {
    public static void main(String[] args) throws Exception {
//        new Random().nextInt()
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> socketTextStream = env.socketTextStream("192.168.52.100", 9999);
        socketTextStream
                .map(e->e)
                .print();
        env.execute();

    }
}
