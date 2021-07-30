package IO.进阶流.bufferstream.Serializable;

import java.io.*;

/**
 * 加上transient关键字的 属性就不会被序列化，反序列化时 就是null
 */
public class serializableStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Person p1 = new Person("ws", 17);
//        FileOutputStream fos = new FileOutputStream("D:\\test99.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
//        objectOutputStream.writeObject(p1);
//        objectOutputStream.close();
//        fos.close();
//        objectOutputStream.close();
        FileInputStream fis = new FileInputStream("D:\\test99.txt");
        ObjectInputStream objInputStream = new ObjectInputStream(fis);
        Person p2 = (Person)objInputStream.readObject();
        System.out.println(p2);
        objInputStream.close();
        fis.close();



    }
}
