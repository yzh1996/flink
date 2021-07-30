//package TransformationOperatorTest;
//
//import org.apache.flink.api.common.functions.FlatMapFunction;
//import org.apache.flink.api.java.tuple.Tuple2;
//import org.apache.flink.streaming.api.datastream.DataStreamSource;
//import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.apache.flink.util.Collector;
//
///**
// * reduce:
// * 假设 依次发送a,b,c   a+b的结果collect发送一次， 当c来时   之前a+b的结果再+c再发送一次
// * 注意：
// *      并不是将a,b,c的结果都相加后再发送，因为这里是流计算，数据是一条一条来的
// *  和sum的差异：
// *      个人认为就是，reduce能够实现更复杂的累加逻辑，因为sum传入的就是单单的一个int或者string参数
// */
//
//public class reduce_sum {
//    public static void main(String[] args) throws Exception {
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        DataStreamSource<String> socketTextStream = env.socketTextStream("node01", 9998);
//        SingleOutputStreamOperator<Tuple2<String, Integer>> wordTupleStream = socketTextStream.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
//            //下面的使用lambda表达式该如何写
//            @Override
//            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
//                String[] words = value.split(" ");
//                for (String word : words) {
//                    out.collect(new Tuple2<>(word, 1));
//                }
//            }
//        });
//
//
//        SingleOutputStreamOperator<Tuple2<String, Integer>> result = wordTupleStream
//                .keyBy(0)
//                //reduce的 参数就是lambda 的参数，所以可以使用lambda表达式 而前面的flatmap  还有一个context 所以不可以使用lambda
////                .reduce((t1, t2) -> new Tuple2<>(t1.f0, t1.f1 + t2.f1));
//                .sum(1);
//
//        result.print();
//        env.execute();
//    }
//}
