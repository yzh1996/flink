package SinkTest;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

public class UserDefineSinkTest {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> textSource = env.readTextFile("e:\\words.txt");
        textSource.addSink(new SinkFunction<String>() {
/**
 * invoke:  Writes the given value to the sink. This function is called for every record.
 * 继承richSinkFunction的话 就多一个open方法 和上下文方法
  */
            @Override
            public void invoke(String value, Context context) throws Exception {

            }
        });
    }
}
