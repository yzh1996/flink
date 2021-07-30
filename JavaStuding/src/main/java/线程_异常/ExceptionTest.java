package 线程_异常;

/**
 * * 处理异常的方法：
 *          * 1.throws 添加异常声明
 *          * 2.try{
 *          *      编写可能会出现异常的代码
 *          * }catch(异常类型  e){
 *          *      处理异常的代码
 *          *      //记录日志/打印异常信息/继续抛出异常
 *          * }
 */


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * throw 是自己手动决定抛出什么样的异常对象，可以在exception()括号里加自己想要加的提示信息,程序执行到这就不会再往下执行了
 */
public class ExceptionTest {

//     static Logger logger;
    public static void main(String[] args) {


        int a = 1;
        int b = 2;
//        System.out.println("程序执行完下面这句话就不会再往下执行了");
//        throw new ArrayIndexOutOfBoundsException("异常");

        try{
            if (a < b)

                throw  new ArrayIndexOutOfBoundsException("yichang");
        }catch (Exception e ){
            System.out.println("***");
            String message = e.getMessage();
            System.out.println(message);
            System.out.println("%%%");
            e.printStackTrace();
            System.out.println("22222");
            a =2;
            System.out.println( a);
            System.out.println(e);
        }
    }
}
