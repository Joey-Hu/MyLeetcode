
/**
 * @author: huhao
 * @time: 2021/6/15 10:07
 * @desc:
 */
public class DeadLock {

    public static void main(String[] args) {
        String a = "资源A";
        String b = "资源B";


        new Thread(new MyResource(a, b), "ThreadA").start();
        new Thread(new MyResource(b, a), "ThreadB").start();

    }
}

class MyResource implements Runnable{

    /*两个共享资源*/
    private String a;
    private String b;

    public MyResource(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (a) {
            System.out.println(Thread.currentThread().getName() + " 获取到 " + a);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + " 获取到 " + b);
            }
        }
    }
}
