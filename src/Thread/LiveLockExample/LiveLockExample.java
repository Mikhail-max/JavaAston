package Thread.LiveLockExample;

class LiveLockExample {
    private volatile boolean isReadyForHandshake = true;

    public static void main(String[] args) {
        LiveLockExample example = new LiveLockExample();

        Thread thread1 = new Thread(() -> {
            while (example.isReadyForHandshake) {
                System.out.println("Поток 1: Готов к рукопожатию, жду ответа...");
                example.isReadyForHandshake = false;
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
            System.out.println("Поток 1: Рукопожатие завершено");
        });

        Thread thread2 = new Thread(() -> {
            while (!example.isReadyForHandshake) {
                System.out.println("Поток 2: Готов к рукопожатию, жду ответа...");
                example.isReadyForHandshake = true;
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
            System.out.println("Поток 2: Рукопожатие завершено");
        });

        thread1.start();
        thread2.start();
    }
}
