package sourceTest;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class fileTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        DataStreamSource<String> fileSource = env.readTextFile("e:\\words.txt");
        SingleOutputStreamOperator<Tuple2<String, Integer>> wordTupleStream = fileSource.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            public void flatMap(String lines, Collector<Tuple2<String, Integer>> out) throws Exception {
                String[] words = lines.split(" ");
                for (String word : words) {
                    out.collect(new Tuple2<String, Integer>(word, 1));
                }
            }
        });

        SingleOutputStreamOperator<Tuple2<String, Integer>> result = wordTupleStream
                .keyBy(0)
//                .sum();
                //sum和reduce有什么区别
                .reduce(new ReduceFunction<Tuple2<String, Integer>>() {
                    public Tuple2<String, Integer> reduce(Tuple2<String, Integer> t1, Tuple2<String, Integer> t2) throws Exception {
                        return new Tuple2<String, Integer>(t1.f0, t1.f1 + t2.f1);
                    }
                });

        result.writeAsText("e:\\result");
        env.execute("xxx");

    }
}
