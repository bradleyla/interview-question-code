package InterviewPrep2;

public class ImplementRunnable {
    public static void main(String[] args) {
        Runnable task = () -> {
            for(int i = 0; i < 10; i++) {
                System.out.println("Thread is processing number " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}
