//package ConnectTest;
//
//import org.apache.flink.api.common.functions.RichFlatMapFunction;
//import org.apache.flink.api.common.serialization.DeserializationSchema;
//import org.apache.flink.api.common.state.MapStateDescriptor;
//import org.apache.flink.api.common.state.ValueStateDescriptor;
//import org.apache.flink.api.common.typeinfo.TypeInformation;
//import org.apache.flink.api.java.tuple.Tuple2;
//import org.apache.flink.configuration.Configuration;
//import org.apache.flink.streaming.api.TimeCharacteristic;
//import org.apache.flink.streaming.api.datastream.DataStreamSource;
//import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
//import org.apache.flink.streaming.api.functions.ProcessFunction;
//import org.apache.flink.streaming.api.watermark.Watermark;
//import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
//import org.apache.flink.util.Collector;
//
//
//import javax.annotation.Nullable;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Properties;
////import java.util.stream.Collectors;
////import org.slf4j.LoggerFactory;
//
//public class KafkaTest {
//    public static void main(String[] args) throws Exception {
////        ArrayList<Object> arr = new ArrayList<>();
////        arr.stream().collect()
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        Properties properties = new Properties();
//        properties.setProperty("bootstrap.servers","node01:9092,node02:9092,node03:9092");
//        properties.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
//        properties.setProperty("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
//        properties.setProperty("connections.max.idle.ms","-1");
//        String topic = "sourceTest";
//        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
//        DeserializationSchema deserializationSchema = new DeserializationSchema() {
//            //TypeInformation 就是 指定返回的类型
//            public TypeInformation getProducedType() {
//                return TypeInformation.of(String.class);
//            }
//
//            ;
//
//
//            public String deserialize(byte[] bytes) throws IOException {
//                return new String(bytes, "UTF-8");
//            }
//
//            public boolean isEndOfStream(Object nextElement) {
//                return false;
//            }
//        };
//        //<>里面的表示  kafka里面的数据类型
//        FlinkKafkaConsumer flinkKafkaConsumer = new FlinkKafkaConsumer<String>(topic, deserializationSchema, properties);
////        flinkKafkaConsumer
//        DataStreamSource kafkaSource = env.addSource(flinkKafkaConsumer);
////        kafkaSource.assignTimestampsAndWatermarks(new AssignerWithPeriodicWatermarks() {
////            @Nullable
////            public Watermark getCurrentWatermark() {
////                return null;
////            }
////
////            public long extractTimestamp(Object element, long previousElementTimestamp) {
////                return 0;
////            }
////        })
//        kafkaSource.process(new ProcessFunction<String, Tuple2<String,Integer>>() {
//            @Override
//            public void open(Configuration parameters) throws Exception {
////                new ValueStateDescriptor<>()
////                new MapStateDescriptor<>()
//            }
//
//            @Override
//            public void onTimer(long timestamp, OnTimerContext ctx, Collector<Tuple2<String, Integer>> out) throws Exception {
////                super.onTimer(timestamp, ctx, out);
//                System.out.println("xxx");
//            }
//
//            public void processElement(String value, Context ctx, Collector<Tuple2<String, Integer>> out) throws Exception {
//                String[] words = value.split(" ");
//                for (String word : words) {
//                    out.collect(new Tuple2<String, Integer>(word,1));
//                }
//
//            }
//
//
//        });
////        SingleOutputStreamOperator singleOutputStreamOperator = kafkaSource.flatMap(new RichFlatMapFunction<String, String>() {
////            @Override
////            public void open(Configuration parameters) throws Exception {
////                int i = 0;
////                i +=1;
////                System.out.println(i);
////            }
////
////            @Override
////            public void flatMap(String lines, Collector out) throws Exception {
////                String[] s = lines.split(" ");
////                for (String s1 : s) {
////
////                    out.collect(s1);
////                }
////
////            }
////        });
////        singleOutputStreamOperator.print();
//        System.out.println("for_source");
//        env.execute();
//
//
//    }
//}
