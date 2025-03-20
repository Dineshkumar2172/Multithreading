package IntroductionSample;

public class Main {
    public static void main(String[] args) {
        Multithreading multithreading = new Multithreading(-1);
        Multithreading multithreading2 = new Multithreading(-2);

        // since we have implemented the run method by overriding it,
        // we might think we need to start a thread using multithreading.run()
        // but it would just simply execute that run method, but not in a separate thread.
        // in order to run it in a separate thread, we need to use start() which executes and
        // run the run() method in a separate thread.

        multithreading.start();
        multithreading2.start();

        // if we do multithreading.run() instead.
        // it won't create a separate thread, but execute run method as part of main thread.
        // multithreading and multithreading2 will get executed in main thread one after another.
        multithreading.run();
        multithreading2.run();

        // we can create multiple thread using for loop like below
        // operation: all threads will count from 0 to 4 simultaneously in different threads.
        for (int i = 0; i <=3; i++) {
            Multithreading multithreading3 = new Multithreading(i);
            multithreading3.start();
        }

        // thread exception: if any thread throws exception, other threads won't get affected.
        // even if we run into main thread or main method, still the threads we started will run independantly of it.
        
        // Runnable interface: we can also implement runnable interface to implement multi-threading.
    }
}
