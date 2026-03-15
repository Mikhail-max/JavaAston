package Thread.DeadLockExample;

public class DeadLockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток 1: Захватил lock1");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (lock2) {
                    System.out.println("Поток 1: Захватил lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Поток 2: Захватил lock2");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (lock1) {
                    System.out.println("Поток 2: Захватил lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
