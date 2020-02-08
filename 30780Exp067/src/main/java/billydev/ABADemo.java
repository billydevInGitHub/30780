package billydev;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ABADemo {
    private static AtomicInteger atomicI = new AtomicInteger(100);

    public static void main(String[] args) {

    Thread thread1 =new Thread(()->{
        System.out.println("thread1: before change atomicI:"+atomicI.get());
        atomicI.compareAndSet(100,110);
        System.out.println("thread1: atomicI:"+atomicI.get());
    });



    Thread thread2 = new Thread(()->{
        try {
            TimeUnit.SECONDS.sleep(6); //if thread2 sleep longer than thread3 , then thread 3 will be ignored
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread2: before change atomicI:"+atomicI.get());
        atomicI.compareAndSet(110,120);
        System.out.println("thread2: atomicI:"+atomicI.get());

    });

    Thread thread3 = new Thread(()->{
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread3: before change atomicI:"+atomicI.get());
        atomicI.compareAndSet(120,100);
        System.out.println("thread 3: atomicI:"+atomicI.get());
    });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
