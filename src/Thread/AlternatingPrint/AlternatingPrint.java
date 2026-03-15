package Thread.AlternatingPrint;

class AlternatingPrint {
    private final Object lock = new Object();
    private boolean printOne = true;
    class ThreadOne extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (!printOne) {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                    System.out.print("1");
                    printOne = false;
                    lock.notify();
                }
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        }
    }

    class ThreadTwo extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (printOne) {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                    System.out.print("2");
                    printOne = true;
                    lock.notify();
                }
                try { Thread.sleep(500); } catch (InterruptedException e) {} // Задержка
            }
        }
    }

    void startThreads() {
        new ThreadOne().start();
        new ThreadTwo().start();
    }

    public static void main(String[] args) {
        new AlternatingPrint().startThreads();
    }
}
