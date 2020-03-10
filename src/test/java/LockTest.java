import com.vincent.lock.ClhSpinLock;

/**
 * Created by chenjun on 2020-03-01 14:55
 */
public class LockTest {
    public static void main(String[] args) {
        ClhSpinLock clhSpinLock = new ClhSpinLock();

        for(int i=1;i<=3;i++) {
            int finalI = i;
            new Thread(() -> {
                clhSpinLock.lock();
                System.out.println("我是线程"+ finalI);
                if(finalI ==1) {
                    System.out.println("线程"+finalI+"要睡觉了");
                    try {
                        Thread.sleep(5000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                clhSpinLock.unlock();
            }).start();
        }
    }
}
