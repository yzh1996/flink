package Source;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @ClassName: sourceTest
 * @Author: yzh
 * @Description:
 * @Date: 2021/5/11 22:37
 * @Version: 1.0
 */
public class sourceTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource mysqlstream = env.addSource(new mysqlSource());
        mysqlstream.map(e->e).print();
        env.execute();
    }
}
