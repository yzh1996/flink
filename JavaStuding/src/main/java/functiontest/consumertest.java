package functiontest;

import java.util.ArrayList;
import java.util.function.Consumer;

public class consumertest  {
    public static void main(String[] args) {
        Consumer<Integer> consumer = new Consumer<Integer>() {

            @Override
            public void accept(Integer o) {
                System.out.println(o);
            }
        };
        consumer.accept(1);
        consumer = i->System.out.println(i+1);
        consumer.accept(1);
        ArrayList<Object> objects = new ArrayList<>();
        objects.forEach(i->System.out.println(i));

    }

//    @Override
//    public void accept(Object o) {
//        System.out.println("hello");
//    }
}
