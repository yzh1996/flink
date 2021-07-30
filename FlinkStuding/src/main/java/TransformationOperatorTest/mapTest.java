package TransformationOperatorTest;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class mapTest {
    public static void main(String[] args) throws Exception {
//        int[] arr = new int[10];
//        int[] arr1 = new int[]{1,23,1};
//        for (int i : arr1) {
//            System.out.println(i);
//        }
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Integer> eleSource = env.fromElements(1, 2, 3, 4);
        SingleOutputStreamOperator<Integer> mapStream = eleSource.map(new MapFunction<Integer, Integer>() {
            @Override
            public Integer map(Integer value) throws Exception {
                return value * 10;
            }
        });
//        SingleOutputStreamOperator<Integer> map = eleSource.map(x -> x * 10);
        mapStream.print();
        env.execute();
    }
}
