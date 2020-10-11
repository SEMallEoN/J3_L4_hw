package J3_L4_hw_semenov;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Writer writer = new Writer();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                writer.printA();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                writer.printB();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                writer.printC();
            }
        });
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
        executorService.shutdown();

    }
}
