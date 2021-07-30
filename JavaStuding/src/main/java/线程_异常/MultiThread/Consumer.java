package 线程_异常.MultiThread;

public class Consumer extends  Thread {
    private BaoZi bz;
    public Consumer(BaoZi bz){
        this.bz = bz;
    }
    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if (bz.flag == false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("吃包子");
                bz.setFlag(false);
                bz.notify();
            }

        }

    }
}
