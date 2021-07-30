import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.io.TextInputFormat;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.FileProcessingMode;

/**
 * @ClassName: sourceTest
 * @Author: yzh
 * @Description:
 * @Date: 2021/5/11 22:37
 * @Version: 1.0
 */
public class test90 {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Path path = new Path("e:\\words.txt");
        DataStreamSource<String> source = env.readFile(new TextInputFormat(path), "e:\\words.txt", FileProcessingMode.PROCESS_ONCE, 5, TypeInformation.of(String.class));
        source.map(e->e.split(" ").toString()).print();
        env.execute();
    }
}
