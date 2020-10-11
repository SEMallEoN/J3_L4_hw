package J3_L4_hw_semenov;

public class Writer {
    private Object lock = new Object();
    private char currentLetter = 'A';

    public void printA() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        lock.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'B';
                    lock.notifyAll();
                }
            } catch (Exception e) {
                throw new RuntimeException("SWW", e);
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        lock.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'C';
                    lock.notifyAll();
                }
            } catch (Exception e) {
                throw new RuntimeException("SWW", e);
            }
        }
    }

    public void printC() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        lock.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'A';
                    lock.notifyAll();
                }
            } catch (Exception e) {
                throw new RuntimeException("SWW", e);
            }
        }
    }
}
