package 线程_异常;

public class myrunnable implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread()+"->"+String.valueOf(i));
        }
    }
}
