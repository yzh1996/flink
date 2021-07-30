package functiontest;

import java.net.InterfaceAddress;
import java.util.function.Function;

public class functest {
    public static void main(String[] args) {
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer o) {
                return o.toString();
            }
        };
        System.out.println(function.apply(1));
        Function<Integer,String> func = Integer ->Integer.toString();
        System.out.println(func.apply(5));
    }
}
