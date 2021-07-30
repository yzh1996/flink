package WindowTest;

import Commen.TupleFlatMap;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * 假设窗口长度设置为5，则在第五个来的时候触发窗口计算，并且，因为是keyby，所以一个key里面的 数据数量达到5次才触发
 * 并不是所有的总数达到5就触发
 */
public class CountWindowTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> socketTextStream = env.socketTextStream("node01", 9997);
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = socketTextStream
                .flatMap(new TupleFlatMap())
                .keyBy(0)
                .countWindow(5)
                .sum(1);
        result.print();
        env.execute();
    }


}