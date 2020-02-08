package billydev;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {

    private static AtomicStampedReference asr = new AtomicStampedReference(100,1000);

    public static void main(String[] args) {

        new Thread(()->{
            asr.compareAndSet(100,101,1000,1001);
            System.out.println(asr.getReference());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            asr.compareAndSet(101,100,1001,1002);
            System.out.println(asr.getReference());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //if we use original expected Stamp from 1000 to 1002, then change will proceed successfully
            //asr.compareAndSet(100,102,1000,1003);//this is original code, timestamp will be block ABA change
            asr.compareAndSet(100,102,1002,1003);
            System.out.println(asr.getReference());
        }).start();


    }

}
