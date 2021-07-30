package IO.进阶流.bufferstream;

import java.io.*;

/**
 * 对一个55M的文件进行复制
 * 使用bufferStream 带字节数组参数的read 和write方法  253ms
 * 使用bufferStream流花费 4497ms
 * 使用fileinputStream  1308779ms
 */
public class BufferStreamTest {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        String path = "D:\\test.ev4";
        String outPath = "E:\\test.ev4";
        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(outPath);

        int b;
        while ((b = fis.read())!=-1){
            fos.write(b);
        }
        fos.close();
        fis.close();

        /**
         * 高效buffer流
         */
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outPath));
//        int c;
//        while ((c=bis.read())!=-1){
//            bos.write(c);
//        }
//        bos.close();
//        bis.close();
        long endTime = System.currentTimeMillis();
        System.out.println("total cost time is "+(startTime-endTime));


    }
}
