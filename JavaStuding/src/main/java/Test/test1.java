package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class test1 {
    public static void main(String[] args) {
//        Person [] arr= {new Person("zs", 17),new Person("ls", 18)};
        Person p1 = new Person("zs", 17);
        Person p2 = new Person("ls", 18);
        ArrayList<Person> arr = new ArrayList<>();
        arr.add(p1);
        arr.add(p2);
        Collections.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        });
        Collections.sort(arr,(p3,p4)->
             p3.getAge()-p4.getAge()
    );
//        Arrays.sort(arr,(p1,p2)->{return p1.getAge()-p2.getAge()>0?-1:1;});
        for (Person person : arr) {
            System.out.println(person);
        }

    }

}
