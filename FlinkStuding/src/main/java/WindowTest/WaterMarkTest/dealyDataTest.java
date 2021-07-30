package WindowTest.WaterMarkTest;

import Commen.TimeConstruct;
import Commen.TupleFlatMap;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.OutputTag;

/**
 * allowedLateness：
 * 作用：允许迟到数据继续参与计算，例如当前watermark为5s，窗口的结束时间为5，allowedLateness=2,那么当来了一条时间
 * 戳为1s的数据时，0-5秒这个窗口将会被再打开让1s的这条数据参与计算
 * 使用：
 * 在window算子后.allowedLateness(Time.seconds(2))
 * 如果还想收集迟到的数据：
 * 1.new  OutputTag，
 * 2.sideOutputLateData(outputTag)
 * 3.获取:result.getSideOutput(outputTag); ->   我们还可以对迟到的数据进行其他的一些操作，因为得到的也是一个dataStream
 */

public class dealyDataTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
//        env.getConfig().setAutoWatermarkInterval(1);  设置watermark的生成时间
        OutputTag<Tuple2<String, Integer>> outputTag = new OutputTag<>("out", TypeInformation.of(new TypeHint<Tuple2<String, Integer>>() {
        }));
        DataStreamSource<String> socketTextStream = env.socketTextStream("node01", 9998);
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = socketTextStream
                .assignTimestampsAndWatermarks(new TimeConstruct())
                .flatMap(new TupleFlatMap())
                .keyBy(0)
                .timeWindow(Time.seconds(3))
                .allowedLateness(Time.seconds(2))
                .sideOutputLateData(outputTag)
                .sum(1);
        DataStream<Tuple2<String, Integer>> delayData = result.getSideOutput(outputTag);
//        System.out.println();
        result.print();
        delayData.print("延迟的数据是:");
        env.execute();
    }
}
