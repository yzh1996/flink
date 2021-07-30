package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class inputStreamTest {
    public static void main(String[] args) throws IOException {
        String path = "E:\\test.txt";
        FileInputStream fis = new FileInputStream(path);
        int  input;
        while(( input = fis.read())!= -1){
            System.out.println((char)input);
        }
//        String read = String.valueOf(fis.read());
//        System.out.println(read);

    }
}
