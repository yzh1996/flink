package 函数式接口;

public class demo1 {
    public static void main(String[] args) {
        funcA(2,()-> System.out.println("hello"));
    }
    public  static void funcA(int a ,myinterface intf){
        if (a == 1){
            System.out.println("xxx");
        }

    }
}
