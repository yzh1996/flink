package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class generic_paradigm {
    public static void main(String[] args) {
//        Collection<Object> collection = new ArrayList<String>();

        Collection<String> collection = new ArrayList<String>();

        collection.add("a");
        collection.add("b");
//        collection.add(1);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            System.out.println( next.length());
        }
    }
}
