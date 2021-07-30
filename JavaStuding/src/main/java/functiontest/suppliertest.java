package functiontest;

import java.util.function.Supplier;

public class suppliertest {
    public static void main(String[] args) {
        Supplier<Integer> supplier = new Supplier<Integer>() {

            @Override
            public Integer get() {
                return 1;
            }
        };
        System.out.println(supplier.get());
    }
}
