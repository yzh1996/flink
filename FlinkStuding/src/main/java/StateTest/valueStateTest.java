package StateTest;

import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

/**
 * State的使用：
 * 1.先构建ValueStateDescriptor<>，该方法中有两个参数，第二个参数建议使用typeinformation，因为使用class可能会失败，
 * 然后当state的数据类型为泛型时 使用typeHint
 * 2.获取getRuntimeContext().getState(descriptor)
 */
public class valueStateTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> socketTextStream = env.socketTextStream("node01", 9997);
        SingleOutputStreamOperator<Tuple2<String, Integer>> tuple2Stream = socketTextStream.flatMap(new myFlatMap1());
        SingleOutputStreamOperator<Tuple2<String, Float>> result = tuple2Stream
                .keyBy(0)
                .process(new ProcessFunction<Tuple2<String, Integer>, Tuple2<String, Float>>() {
                    private ValueState<Tuple2<Integer, Integer>> state;

                    @Override
                    public void open(Configuration parameters) throws Exception {
//            new ValueStateDescriptor<>("state", TypeInformation.of(new TypeHint<Tuple2<Integer,Integer>>()));
                        ValueStateDescriptor<Tuple2<Integer, Integer>> descriptor = new ValueStateDescriptor<>("xxx", TypeInformation.of(new TypeHint<Tuple2<Integer, Integer>>() {
                        }));
                        this.state = getRuntimeContext().getState(descriptor);
                    }

                    @Override
                    public void processElement(Tuple2<String, Integer> t1, Context ctx, Collector<Tuple2<String, Float>> out) throws Exception {
                        Tuple2<Integer, Integer> value = state.value();
                        if (null == value) {
                            Tuple2<Integer, Integer> tuple2 = new Tuple2<>(0, 0);
                            value = tuple2;
                        }
                        System.out.println("上一次的次数：" + value.f0);
                        value.f0 = value.f0 + 1;
                        System.out.println("这一次的次数：" + value.f0);
                        value.f1 = value.f1 + t1.f1;
                        state.update(value);
                        out.collect(new Tuple2<String, Float>(t1.f0, (float) value.f1 / value.f0));
                    }
                });
        result.print();
        env.execute();
    }

    static class myFlatMap1 extends RichFlatMapFunction<String, Tuple2<String, Integer>> {


        @Override
        public void flatMap(String lines, Collector out) throws Exception {
            String[] words = lines.split(" ");
            out.collect(new Tuple2<>(words[0], Integer.parseInt(words[1])));
//            Tuple2<Integer, Integer>
        }
    }
}
