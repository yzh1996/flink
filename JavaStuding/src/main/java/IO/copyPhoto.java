package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyPhoto {
    public static void main(String[] args) throws IOException {
        String picturePath = "D:\\1.png";
        String outPath = "E:\\out.png";
        FileInputStream fis = new FileInputStream(picturePath);
        FileOutputStream fos = new FileOutputStream(outPath);
        byte [] bytes= new byte[2];
        int length = 0;
//        int read = fis.read();
        while ((length = fis.read())!= -1){
            fos.write(length);
        }
        fos.close();
        fis.close();
    }
}
