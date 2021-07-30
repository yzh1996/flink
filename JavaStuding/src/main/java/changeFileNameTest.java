import java.io.*;

/**
 * @ClassName: changeFileNameTest
 * @Author: yzh
 * @Description:
 * @Date: 2021/5/31 23:09
 * @Version: 1.0
 */
public class changeFileNameTest {
    public static void main(String[] args) throws IOException {
        changeFileName("E:\\data");
    }

    private static void changeFileName(String path) throws IOException {
        File file = new File(path);
        File[] files = file.listFiles();
        if (files== null || files.length<=0){
            System.out.println("WARN:空文件夹");
        }else {
            int i = 0;
            for (File file1 : files) {
                if (file1.isDirectory()){
                    changeFileName(file1.getAbsolutePath());
                }else {
                    String absolutePath = file1.getAbsolutePath();
                    String  pathHead = "E:\\yzh";
                    String fileName1 = absolutePath.substring("E:\\data".length());
                    String fileName = pathHead+fileName1;
                    copyfile(absolutePath,fileName);

                    i++;
                }
            }
        }


    }
   public static void copyfile(String fileIn, String fileOut) throws IOException {
       BufferedInputStream buffIn = null;
       BufferedOutputStream buffOut = null;
       buffIn = new BufferedInputStream(new FileInputStream(fileIn));
        buffOut = new BufferedOutputStream(new FileOutputStream(fileOut));
       byte[] container = new byte[1024];
       int len = 0;
       while ((len = buffIn.read())!=-1){
            buffOut.write(container,0,len);
        }
        buffIn.close();
       buffOut.close();
   }
}
