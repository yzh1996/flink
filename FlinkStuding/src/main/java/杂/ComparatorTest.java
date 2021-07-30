package 杂;

import java.util.*;

/**
 * o1-02>0?1:-1  升序
 * o1-o2>0?-1:1  降序
 *表达式中的数字可以这样解释：
 * 1，表示要换，-1表示不需要调换位置
 * 01-02>0  返回值为1  就表示 第一个元素大于第二个元素   并且第一个元素需要和第二个元素调换位置 所以是升序
 */
public class ComparatorTest {
    public static void main(String[] args) {
////        ArrayList<Integer> arrayList = new ArrayList<>();
////        arrayList.add(1);
////        arrayList.add(5);
//////        arrayList.add(-1);
////        arrayList.add(3);
////        arrayList.sort(new Comparator<Integer>() {
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                return o1-o2>0?1:-1;
////            }
////        });
//
//        arrayList.stream().forEach(System.out::println);

        TreeMap<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 - o2)>0?1:-1;//
            }
        });

        treeMap.put(1,"a");
        treeMap.put(3,"c");
        treeMap.put(2,"b");
        System.out.println(treeMap.firstEntry().getKey());
        Iterator<Map.Entry<Integer, String>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()){
            String value = iterator.next().getValue();
            System.out.println(value);
        }
    }

            }
