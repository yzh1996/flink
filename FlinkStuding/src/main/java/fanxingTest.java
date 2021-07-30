//import org.apache.flink.api.common.functions.FlatMapFunction;
//import org.apache.flink.api.java.tuple.Tuple;
//import org.apache.flink.api.java.tuple.Tuple2;
//import org.apache.flink.streaming.api.datastream.DataStreamSource;
//import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.apache.flink.table.api.java.StreamTableEnvironment;
//import org.apache.flink.util.Collector;
//
///**
// * 泛型使用，如下面代码所示，我们在定义的时候需要指定泛型里面的参数，但是在生成的时候可以不用指定：
// * 就是 Tuple2<String,Integer> tuple2 = new Tuple<>() 左边 <>里面需要填写具体的类型，而右边不需要
// */
//public class fanxingTest {
//    public static void main(String[] args) throws Exception {
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
////        StreamTableEnvironment streamTableEnvironment = StreamTableEnvironment.create(env);
////        streamTableEnvironment.fromDataStream()
//        DataStreamSource<String> socketTextStream = env.socketTextStream("node01", 9998);
//        SingleOutputStreamOperator<Tuple2<String,Integer>> result = socketTextStream.flatMap(new FlatMapFunction<String, Tuple2<String,Integer>>() {
//            @Override
//            public void flatMap(String line, Collector<Tuple2<String,Integer>> out) throws Exception {
//                String[] words = line.split(" ");
//                out.collect(new Tuple2<>(words[0], 1));
//            }
//        });
//        result.print();
//        env.execute();
//    }
//}
