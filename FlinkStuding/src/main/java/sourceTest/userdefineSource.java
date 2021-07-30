package sourceTest;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

public class userdefineSource {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(2);
        //sourceFunction是单并行度的，多并行度的需要使用parallSourcefunction
        DataStreamSource<Object> userDefineSource = env.addSource(new SourceFunction<Object>() {
            private int number;
            boolean isRunning = true;
            private  String  word;

            @Override
            public void run(SourceContext<Object> ctx) throws Exception {
                //在run方法里面写获取数据源数据的逻辑，之后通过collect下发
                while (isRunning) {
                    word = number+ "flink";
                    number++;
                    ctx.collect(number);
                    ctx.collect(word);
                    Thread.sleep(3000);
                }
            }

            @Override
            public void cancel() {
                isRunning = false;
            }
        }).setParallelism(2);
        userDefineSource.print();
        env.execute();
    }
}
