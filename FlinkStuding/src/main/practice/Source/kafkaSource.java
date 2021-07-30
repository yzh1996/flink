package Source;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;


/**
 * @ClassName: kafkaSource
 * @Author: yzh
 * @Description: consumer from kafka
 * @Date: 2021/5/12 22:00
 * @Version: 1.0
 */
public class kafkaSource {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        env.addSource(new FlinkKafkaConsumer011<Object>())
    }
}
