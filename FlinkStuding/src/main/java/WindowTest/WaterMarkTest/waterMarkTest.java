package WindowTest.WaterMarkTest;

import Commen.TimeConstruct;
import Commen.TupleFlatMap;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * 注意这里程序的执行顺序，来一条数据就会执行一次TupleFlatmap，进入到window里，当waterkmark的值 超过窗口的结束
 * 时间时，再执行sum
 */

public class waterMarkTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
//        env.getConfig().setAutoWatermarkInterval(1);
        DataStreamSource<String> socketTextStream = env.socketTextStream("node01", 9998);
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = socketTextStream
                .assignTimestampsAndWatermarks(new TimeConstruct())
                .flatMap(new TupleFlatMap())
                .keyBy(0)
                .timeWindow(Time.seconds(3))
                .sum(1);
        System.out.println();
        result.print();
        env.execute();


    }
}
