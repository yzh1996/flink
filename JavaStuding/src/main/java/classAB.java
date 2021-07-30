import java.io.File;

/**
 * @ClassName: classAB
 * @Author: yzh
 * @Description:
 * @Date: 2021/5/31 22:51
 * @Version: 1.0
 */
public class classAB {

    public static void main(String[] args) {
        changeFileName("E:\\data\\data1");
    }


    public static void changeFileName(String path){
        File file = new File(path);
        if(file.exists()){
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                int i =0;
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        changeFileName(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                        String filePath = file2.getAbsolutePath();
                        //E:\data\data1
                        String fileName = filePath.substring(0,filePath.length()-4);
                        File oriFile = new File(filePath);
                        boolean b = oriFile.renameTo(new File(fileName));
                        System.out.println(b);
                        i++;
                    }
                }
            }
        }else{
            System.out.println("该路径不存在");
        }

    }
}
