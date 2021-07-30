package TransformationOperatorTest;

//import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

/**
 * 遗留问题：如果要使用lambda表达式实现flatmapfunction  该怎么写？
 */

public class FlatMapTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        env.readFile(new TextInputFormat())
        DataStreamSource<String> wordStream = env.readTextFile("e:\\words.txt");
//        wordStream.process(new myProcessFunc)
        wordStream.flatMap(new myFlatMap());
        wordStream.print();
        env.execute(FlatMapTest.class.getName());
    }

    private static class myFlatMap extends RichFlatMapFunction<String, String> {
        @Override
        public void open(Configuration parameters) throws Exception {
            System.out.println("sdasdasdasd");
        }

        public void flatMap(String line, Collector<String> out) throws Exception {
            String[] words = line.split(" ");
            for (String word : words) {
                out.collect(word);
            }


        }
    }

    private static class myProcessFunc extends ProcessFunction<String, String> {
        @Override
        public void onTimer(long timestamp, OnTimerContext ctx, Collector<String> out) throws Exception {
            super.onTimer(timestamp, ctx, out);
        }

        @Override
        public void open(Configuration parameters) throws Exception {
            super.open(parameters);
        }

        public void processElement(String value, Context ctx, Collector<String> out) throws Exception {


        }
    }
}
