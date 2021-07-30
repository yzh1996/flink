package WindowTest;

import Commen.TupleFlatMap;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * 默认的时间是ProcessingTime
 * SingleOutputStreamOperator ：用户自定义算子得到的流
 * DataStream：xxxxx
 * 窗口是左闭右开的
 */
public class TimeWindowTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        TimeCharacteristic streamTimeCharacteristic = env.getStreamTimeCharacteristic();
//        System.out.println(streamTimeCharacteristic);
        DataStreamSource<String> socketTextStream = env.socketTextStream("node01", 9999);
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = socketTextStream
                .flatMap(new TupleFlatMap())
                .keyBy(0)
                .timeWindow(Time.seconds(5))
                .sum(1);
        result.print();
        env.execute();
    }
}
