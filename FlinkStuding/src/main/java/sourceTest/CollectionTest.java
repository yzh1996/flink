package sourceTest;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;

public class CollectionTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(3);
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("flink spark");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        DataStreamSource<Integer> collectionSource = env.fromCollection(arr);
        DataStreamSource<String> collSource2 = env.fromCollection(arr1);
        //当设置的并行度为1时，collsource2和collectionsource是随机抢占资源 输出，并不是collsource.print在前就先输入它
        collSource2.print();
        System.out.println("**********");
        collectionSource.print();
        env.execute();
    }
}
