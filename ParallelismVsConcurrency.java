import java.util.stream.IntStream;

public class ParallelismVsConcurrency {
    /*
     *  Concurrency Vs Parallelism
     *      
     *      1. Concurrency refers to the ability of a system to execute multiple tasks at the same time or nearly overlapping time so it seem like it executed at the same time.
     *         example: A Java program handling multiple network requests with a single thread pool.
     *      
     *      2. Parallelism is when multiple tasks run simultaneously on multiple processors/cores.
     *         example: A multi-threaded program performing matrix multiplication on different CPU cores.
     * 
     *      3. Concurrency enables parallelism, but they are not the same.
     */

    public void concurrencyExample() {
        // Concurrency = Task switching (Single-core possible, no simultaneous execution).
        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 1 - " + i);
            }
        };
        
        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 2 - " + i);
            }
        };
        
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();  // Tasks are interleaved, but not necessarily running in parallel
    }

    public void parallelismExample() {
        // Parallelism = Simultaneous execution (Requires multiple cores/processors).
        // The .parallel() method uses multiple CPU cores for execution.
        IntStream.range(1, 10).parallel().forEach(i -> 
            System.out.println("Parallel Task " + i + " - " + Thread.currentThread().getName()));
    }
}

