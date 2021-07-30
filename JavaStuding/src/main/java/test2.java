import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class test2 {
    public static void main(String[] args) throws IOException {
        String path = "E:\\yz\\dir";
        File file = new File(path);
//        if(!file.exists()){
//            file.mkdir();
//        }
        for (File listFile : file.listFiles()) {
            System.out.println(listFile.getName());
            System.out.println(listFile.getParent());
            System.out.println(listFile.getPath());
            System.out.println(listFile.getAbsolutePath());
            System.out.println("**************************");
        }
//        FileOutputStream fos = new FileOutputStream(file);
//        byte[] bytes = "a".getBytes();
//        fos.write(bytes,0,bytes.length);
    }
}
