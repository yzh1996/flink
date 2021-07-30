package Commen;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;



public class TupleFlatMap implements FlatMapFunction<String, Tuple2<String,Integer>> {
    @Override
    public void flatMap(String lines, Collector out) throws Exception {
        String[] words = lines.split(" ");

//            for (String word : words) {
//                out.collect(new Tuple2<>(word,1));
//            }
        out.collect(new Tuple2<>(words[0],1));

//        for (String word : words) {
//            out.collect(new Tuple2<>(word,Integer.parseInt(words[1])));
//        }


    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            Random random1 = new Random();
//            int i1 = random1.nextInt(10);
            double random = Math.random();
            String format = String.format("%.2f", random);
            System.out.println(format);
        }
    }
}
