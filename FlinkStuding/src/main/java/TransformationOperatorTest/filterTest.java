package TransformationOperatorTest;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * filter算子，返回满足过滤条件的值
 * 例如  Stream.filter(x->x>3)  则返回大于3的
 */
public class filterTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Integer> eleSource = env.fromElements(1, 2, 3, 4);

        SingleOutputStreamOperator<Integer> filterStream = eleSource.filter(new FilterFunction<Integer>() {
            @Override
            public boolean filter(Integer value) throws Exception {
                return value > 3;
            }
        });
        //Lambda表达式的写法
//        SingleOutputStreamOperator<Integer> filterStream= eleSource.filter((x) -> x > 3);
        filterStream.print();
        env.execute();

    }
}
