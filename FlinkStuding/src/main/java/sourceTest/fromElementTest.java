package sourceTest;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class fromElementTest {
    public static void main(String[] args) throws Exception {
//        int[] arr = new int[10];
//        int[] arr1 = new int[]{1,23,1};
//        for (int i : arr1) {
//            System.out.println(i);
//        }
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Integer> eleSource = env.fromElements(1, 2, 3, 4);
        eleSource.print();
    }
}
