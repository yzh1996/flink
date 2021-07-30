package StateTest;


import Commen.TupleFlatMap;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import scala.Int;

import java.util.HashMap;
import java.util.Random;

/**
 *
 */
public class MapStateTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> socketTextStream = env.socketTextStream("node01", 9997);
        SingleOutputStreamOperator<Tuple2<String, Integer>> reslut = socketTextStream
                .flatMap(new TupleFlatMap())
                .keyBy(0)
                .process(new ProcessFunction<Tuple2<String, Integer>, Tuple2<String, Integer>>() {
                    private ValueState<HashMap<String, Integer>> mapState;

                    @Override
                    public void open(Configuration parameters) throws Exception {
                        ValueStateDescriptor<HashMap<String, Integer>> mapDescpritor = new ValueStateDescriptor<>("mapDescpritor", TypeInformation.of(new TypeHint<HashMap<String, Integer
                                >>() {
                        }));
                        this.mapState = getRuntimeContext().getState(mapDescpritor);
                    }

                    @Override
                    public void processElement(Tuple2<String, Integer> t1, Context ctx, Collector<Tuple2<String, Integer>> out) throws Exception {
                        HashMap<String, Integer> value = mapState.value();
                        if (null == value) {
                            HashMap<String, Integer> hashMap = new HashMap<>();
                            value = hashMap;
                        }
                        t1.f0 = t1.f0 + String.valueOf(Math.random()*10);
                        value.put(t1.f0, t1.f1);
                        mapState.update(value);
                        for (String key : value.keySet()) {
                            out.collect(new Tuple2<>(key, value.get(key)));
                        }

//                        out.collect(new Tuple2<>(value));

                    }
                });
        reslut.print();
        env.execute();

    }
}
