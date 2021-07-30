package TransformationOperatorTest;

import org.apache.flink.api.common.functions.Partitioner;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * 分区：
 * partitionCustom:自定义分区
 * partitionCustom(Partitioner<K> partitioner, KeySelector<T, K> keySelector)
 * 最复杂的这个有两个参数，一个分区器，一个选择器，选择器将选出来的结果，给前面的分区器作为参数key，决定要分到哪个分区
 */
public class partitionTest {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Integer> eleStream = env.fromElements(1, 2, 3, 4);
//        eleStream.partitionCustom(new Partitioner<Integer>() {
//            @Override
//            public int partition(Integer key, int numPartitions) {
//                return 0;
//            }
//        }, new KeySelector<Integer, Integer>() {
//            @Override
//            public Integer getKey(Integer value) throws Exception {
//                return null;
//            }
//        })
    }
}
