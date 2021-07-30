package IO;

import java.io.*;

public class CharStreamTest {
    public static void main(String[] args) throws IOException {
        String path = "e:\\test.txt";
//        FileReader fileReader = new FileReader(path);
////        FileWriter fw = new FileWriter(path);
////        fw.flush();
//        int input;
//        while ((input = fileReader.read())!= -1){
//            System.out.println((char)input);
//        }
        BufferedWriter fw = new BufferedWriter(new FileWriter(path));
        fw.write("yzh");
        fw.newLine();
        fw.write("yzhsg");
        fw.close();
    }
}
