package IntroductionSample;

public class Multithreading extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);

            // for better visibility during execution - keeping a sleep command
            try {
                Thread.sleep(1000); // 1 sec
            } catch (InterruptedException e) {
            }
        }
    }
}
