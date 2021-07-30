package TransformationOperatorTest;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * union算子：
 * 作用：把2个流的数据进行合并，形成一个新的流，已经无法辨认流中的数据原先是哪个流来的了
 * 2个流的数据类型必须保持一致，connect可以不保持一致，但是只能连接俩
 * 使用：stream1.union(stream2)
 * 使用场景：？？？
 */
public class UnionTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Integer> eleSource1 = env.fromElements(1, 2, 3);
        DataStreamSource<Integer> eleSource2 = env.fromElements(4, 5, 6);
        DataStream<Integer> result = eleSource1.union(eleSource2);
        result.print();
        env.execute();
    }
}
