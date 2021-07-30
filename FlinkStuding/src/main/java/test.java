import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {
    public static void main(String[] args) {
        ArrayList<Object> arr = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<>();
        arr.add(1);
        ArrayList<Object> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(1);
        ArrayList<Object> arr3 = new ArrayList<>();
        arr3.addAll(arr1);
        arr3.addAll(arr);
        System.out.println(arr3);
//        Collections.addAll(arr,null);
//        System.out.println(arr);
//        LinkedHashSet<Object> objects = new LinkedHashSet<>();
//        objects.add("a");
//        objects.add("c");
//        objects.add("b");
//        for (Object object : objects) {
//            System.out.println(object);
//        }
//        HashMap<String, Integer> map = new HashMap<>();
//        Collection<Integer> values = map.values();
////        values.parallelStream().filter(Pre)
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();

    }
}
