package IntroductionSample;

public class Multithreading extends Thread{
    
    private int threadNumber;

    // we can set unique id to thread.
    public Multithreading(int thread) {
        this.threadNumber = thread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ": from thread number " +  this.threadNumber);

            // for better visibility during execution - keeping a sleep command
            try {
                Thread.sleep(1000); // 1 sec
            } catch (InterruptedException e) {
            }
        }
    }
}
