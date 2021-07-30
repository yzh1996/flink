package Map;

import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.mutable.DefaultEntry;
import scala.collection.mutable.HashMap;

public class test {
    public static void main(String[] args) {
//        HashMap<String, person> map = new HashMap<>();
//        map.put("yzh",new person("yzh",18));
//        map.put("yzh",new person("yzh",17));
//        Iterable<person> values = map.values();
//        Iterator<person> iterator = values.iterator();
//        while (iterator.hasNext()){
//            person next = iterator.next();
//            System.out.println(next);
//        }

        HashMap<String, Integer> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("lihua",17);
        objectObjectHashMap.put("yzh",17);
        objectObjectHashMap.put("yzzh",17);
        Iterator<DefaultEntry<String, Integer>> iterator = objectObjectHashMap.entriesIterator();
        while(iterator.hasNext()){
            DefaultEntry<String, Integer> next = iterator.next();
            System.out.println(next);
        }

    }
}
