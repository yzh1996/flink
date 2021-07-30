package 线程_异常.MultiThread;

public class BaoZiPu extends Thread {
    private BaoZi bz;

    public BaoZiPu(BaoZi bz){
        this.bz = bz;
    }
    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if (bz.flag == true){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("生产包子");
                bz.setFlag(true);
                bz.notify();
            }
        }

    }
}
