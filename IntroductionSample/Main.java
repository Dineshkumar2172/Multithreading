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
        
        // Runnable interface: we can also use runnable interface to implement multi-threading.
        // only difference when using runnable interface in main multithread class is using "implements Runnable" instead of "extends Thread"
        MultithreadingInterface multithreadingInterface = new MultithreadingInterface(1);
        // but while using multithreading through runnable interface, we need to use different method to start the thread.
        Thread myThread = new Thread(multithreadingInterface);
        myThread.start();

        for (int i = 0; i < 5; i++) {
            MultithreadingInterface multithreadingInterface2 = new MultithreadingInterface(i);
            Thread myThread2 = new Thread(multithreadingInterface2);
            myThread2.start();
        }

        // note: solid thread class take care of everything about start a new thread while we need to take care of starting procedured in interface.
        // note: one advantage of using interface instead of extending Thread class is implementation support multiple inheritance,
    }
}
