package IntroductionSample;

public class MultithreadingInterface implements Runnable{
    private int threadId;

    public MultithreadingInterface(int threadId) {
        this.threadId = threadId;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "from thread " + threadId + ": using runnable interface");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
