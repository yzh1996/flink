package IO;

import java.io.*;

public class IOtest1 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        String path = "D:\\test.ev4";
        String outPath = "E:\\test2.ev4";
//        FileInputStream fis = new FileInputStream(path);
//        FileOutputStream fos = new FileOutputStream(outPath);
//
//        int b;
//        while ((b = fis.read())!=-1){
//            fos.write(b);
//        }
//        fos.close();
//        fis.close();

        /**
         * 高效buffer流
         */
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outPath));
        int len = 0;
        byte [] by = new byte[1024];
        while ((len=bis.read(by))!=-1){
            bos.write(by,0,len);
        }
        bos.close();
        bis.close();
        long endTime = System.currentTimeMillis();
        System.out.println("total cost time is "+(startTime-endTime));

    }
}
