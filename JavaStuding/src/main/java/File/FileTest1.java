package File;

import java.io.File;

public class FileTest1 {
    public static void main(String[] args) {
        String path = "E:\\data";
        File file = new File(path);
        String[] list = file.list();
        for (String filestr : list) {
            System.out.println(filestr);
        }
        System.out.println("**************************");
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getName());
        }
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getName());
//        System.out.println(file.length());

    }

}
