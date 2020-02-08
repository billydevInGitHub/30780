package billydev;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {

    private static AtomicStampedReference asr = new AtomicStampedReference(100,1000);

    public static void main(String[] args) {

        new Thread(()->{
            asr.compareAndSet(100,101,1000,1001);
        })
    }

}
