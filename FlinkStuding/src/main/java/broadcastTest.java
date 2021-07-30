import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.configuration.Configuration;



import java.util.List;

/**
 * 问题：从代码里看出来  广播变量是批处理的Api而我们实时的Api怎么样可以使用到这个广播变量？
 *
 *广播变量：
 * 使用：
 * 1.在open方法里获取到广播变量
 *  getRuntimeContext().getBroadcastVariable("broadcast")   参数为 广播出去的那个变量的名字-》就是 右边这里面的第二个参数withBroadcastSet(toBrocastData, "broadcast")
 *  2.似乎是一个dataset，然后通过.withBroadcastSet就可以将变量广播出去
 *  PS：
 *      代码的执行顺序是：先广播出去 ，然后再获取广播变量
 */
public class broadcastTest {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<Integer> toBrocastData = env.fromElements(1, 2, 3, 4);
//        StreamExecutionEnvironment streamEnv = StreamExecutionEnvironment.getExecutionEnvironment();
        DataSource<String> eleSource = env.fromElements("a", "b");
        MapOperator<String, String> result = eleSource.map(new myFunc()).withBroadcastSet(toBrocastData, "broadcast");

//        result.withBroadcastSet(toBrocastData, "broadcast");

        result.print();

    }

    static class  myFunc extends  RichMapFunction<String,String>{

        @Override
        public void open(Configuration parameters) throws Exception {
            List<Integer> broadCastValue = getRuntimeContext().getBroadcastVariable("broadcast");
            broadCastValue.stream().forEach(System.out::println);
        }

        @Override
        public String map(String word) throws Exception {
            return word.toUpperCase();
        }
    }
}
