package 线程_异常.MultiThread;

public class test {
    public static void main(String[] args) {
        BaoZi bz = new BaoZi();
        BaoZiPu baoZiPu = new BaoZiPu(bz);
        Consumer consumer = new Consumer(bz);
        baoZiPu.start();
        consumer.start();
    }
}
