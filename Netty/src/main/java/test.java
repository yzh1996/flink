import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName: test
 * @Author: yzh
 * @Description: test
 * @Date: 2021/3/18 21:42
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
//        String aa = null;
////        int i = aa == null ? 1 : 2;
//        System.out.println( aa == null ? 1 : 2);
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            iterator.remove();
        }
        System.out.println(list.size());

    }
}
