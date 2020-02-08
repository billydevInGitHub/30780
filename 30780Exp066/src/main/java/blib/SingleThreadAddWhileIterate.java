package blib;

import java.util.ArrayList;
import java.util.Iterator;

public class SingleThreadAddWhileIterate  {
    static ArrayList l = new ArrayList();

    public static void main(String[] args)
            throws InterruptedException
    {
        System.out.println("SingleThread");//even single thread has the same issue
        l.add("A");
        l.add("B");
        l.add("c");

        // We create a child thread that is
        // going to modify ArrayList l.
        SingleThreadAddWhileIterate t = new SingleThreadAddWhileIterate();


        // Now we iterate through the ArrayList
        // and get exception.
        Iterator itr = l.iterator();
        while (itr.hasNext()) {
            String s = (String)itr.next();
            System.out.println(s);
            Thread.sleep(1000);
            l.add("D");
        }
        System.out.println(l);
    }
}