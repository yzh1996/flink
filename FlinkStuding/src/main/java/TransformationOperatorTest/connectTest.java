package TransformationOperatorTest;

import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.CoFlatMapFunction;
import org.apache.flink.util.Collector;

/**
 * connect算子：
 * 连接两个流（只能连接两个），流的数据类型可以不一致，连接后是一个连接流，保留了各自流的独立性，可以分别对两个流
 * 进行操作
 * 使用场景：？？？？
 */
public class connectTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> eleSource1 = env.fromElements("flink", "spark");
        DataStreamSource<Integer> eleSource2 = env.fromElements(1, 2, 3);
        ConnectedStreams<String, Integer> connectStream = eleSource1.connect(eleSource2);
        SingleOutputStreamOperator<Object> result = connectStream.flatMap(new CoFlatMapFunction<String, Integer, Object>() {
            @Override
            public void flatMap1(String value, Collector out) throws Exception {
                out.collect(value.toUpperCase());
            }

            @Override
            public void flatMap2(Integer value, Collector<Object> out) throws Exception {
                out.collect(value * 10);

            }
        });
        result.print();
        env.execute();

    }
}
