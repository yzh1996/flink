package functiontest;

import java.util.function.Predicate;

public class predicatetest {
    public static void main(String[] args) {
      Predicate<Integer> pre =  i->i>5;
        System.out.println(pre.test(1));
    }
}
