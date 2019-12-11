package consumerProducer;

import java.util.ArrayList;
import java.util.List;

class Processor {
    // Methods Producer and Consumer will manipulate with one List object
    // Producer should add integer values to the list
    // Consumer should remove values from the list
    // Synchronization will be handled by Object lock

     private List<Integer> list = new ArrayList<>();
     private final int LIMIT = 10;
     private final int BOTTOM = 0;
     private final Object lock = new Object();
     private int value = 0;

     public void producer() throws InterruptedException {
         synchronized (lock) {
             while(true) {
                 if(list.size() == LIMIT) {
                     System.out.println("Waiting for removing items from the list...");
                     lock.wait();
                 }else {
                     System.out.println("Adding items..." + value);
                     list.add(value);
                     value++;
                     lock.notify();
                 }
                 Thread.sleep(500);
             }
         }
     }

     public void consumer() throws InterruptedException {
         synchronized (lock) {
             while (true) {
                 if(list.size() == BOTTOM) {
                     System.out.println("Waiting for adding items to the list...");
                     lock.wait();
                 }else {
                     System.out.println("Removed item..."+ list.remove(--value));
                     lock.notify();
                 }
                 Thread.sleep(500);
             }
         }
     }
}
