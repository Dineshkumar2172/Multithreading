public class DaemonThreads {
    public static void main(String[] args) {
        /*
         *  Daemon and user threads
         *  
         *  1. In Java, threads are classified into User Threads and Daemon Threads based on their lifecycle and purpose.
         *      * user threads
         *      * daemon threads.
         * 
         *  2. Think of User Threads as important workers doing real tasks in a company.
         *     Think of Daemon Threads as janitors cleaning the office while workers are working.
         *     Now, imagine this:
         *          * If all the workers (User Threads) leave the office, the company shuts down (JVM stops).
         *          * The janitors (Daemon Threads) also stop immediately, even if they're still cleaning.
         * 
         *  3. User Thread (Main Work): It does the actual job. VM waits for it to finish before shutting down.
         *     Daemon Thread (Background Task): It does background work. JVM does NOT wait for it. If only daemon threads are left, JVM stops immediately. Example: GC
         * 
         */
    }
}
