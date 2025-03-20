package IntroductionSample;

public class Main {
    public static void main(String[] args) {
        Multithreading multithreading = new Multithreading();
        Multithreading multithreading2 = new Multithreading();

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
    }
}
