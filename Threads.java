public class Threads {
    /**
     *  Thread Lifecycle
     * 
     *  1. New State - every thread is in this state until we call start() on it.
     * 
     *  2. Active State - every thread is in this state after we call start() on it. It has two sub states - runnable & running.
     * 
     *      running - when the thread is currently running or executed by the cpu.
     *      
     *      runnable - The thread is ready to run, but waiting for the CPU.	The thread is in the run queue, waiting for CPU time from the scheduler.
     * 
     *  3. Blocked State - The thread is waiting for a resource (e.g., a lock held by another thread). The thread cannot proceed until the resource is released by another thread.
     * 
     *  4. Terminated - Every thread is in this state after it's done doing it's required task.
     */
}
