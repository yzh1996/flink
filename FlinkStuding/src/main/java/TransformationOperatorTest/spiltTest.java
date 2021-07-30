package TransformationOperatorTest;

import org.apache.flink.streaming.api.collector.selector.OutputSelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SplitStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;

/**
 * spilt算子：
 * 作用：根据规则把一个数据流切分为多个流
 * 使用：详见下面代码
 * 原理：
 * spilt 并不是真正的分流  就是将原来的流打上标签，然后你再对这个流使用select，选择自己要的标签
 * 使用场景：
 * 可能在实际工作中，源数据流中混合了多种类似的数据，多种类型的数据处理规则不一样，所以就可以在根据一定的规则，
 * 把一个数据流切分成多个数据流，这样每个数据流就可以使用不同的处理逻辑了
 */
public class spiltTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        DataStreamSource<Integer> eleStream = env.fromElements(1, 2, 3, 4);
        SplitStream<Integer> splitStream = eleStream.split(new OutputSelector<Integer>() {//<>里的是输入的参数类型，亦或者是输出的类型？？
//            List<String> out = new ArrayList<>();
            /**
             * 这里将new ArrayList 写在select方法外面时，得到的结果是没有筛选功能的，分析原因如下：
             * select的本质 我猜测 就是给来的数据打上标签，来一条打一条，如果是将new ArrayList放在外面，那么就是
             * 这种情况，上一条奇数，打上odd标签,下一条打上偶数even标签，但是，最终返回的，数据的标签out是既有odd又
             * 有even所以就没有 筛选效果
             */
            @Override
            public Iterable<String> select(Integer value) {
                ArrayList<String> out = new ArrayList<>();
                if (value % 2 == 1)
                    out.add("odd");
                out.add("even");
                return out;
            }
        });
//      lambda表达式实现
//        SplitStream<Integer> splitStream = eleStream.split(data -> {
//            ArrayList<String> out = new ArrayList<>();
//            if (data % 2 == 1)
//                out.add("odd");
//            out.add("even");
//            return out;
//
//        });
        DataStream<Integer> oddStream = splitStream.select("odd");
//        DataStream<Integer> evenStream = splitStream.select("even");
        oddStream.print();
//        evenStream.print();
        env.execute();
    }
}
