import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSynchronisation {
    /*
     * Thread synchronization prevents multiple threads from accessing the same resource at the same time, avoiding race conditions and inconsistent data.
     * 
     * Why Do We Need Synchronization?
     *      Without synchronization:
     *          * Threads interfere with each other.
     *          * Data becomes inconsistent.
     *          * Unpredictable race conditions occur.
     *      Synchronization ensures that only one thread can access a shared resource at a time.
     *  
     * Ways to Synchronize in Java
     *      synchronized method	                   -   Locks the entire method, allowing only one thread at a time.
     *      synchronized block                     -   Locks only a specific block of code instead of the whole method.
     *      Lock (from java.util.concurrent.locks) - More flexible than synchronized, allowing tryLock() and unlocking manually.
     *      Atomic Variables                       - Special variables (AtomicInteger, AtomicLong) that handle synchronization internally.
     */

    // normal method - thread unsafe
    static class BankAccount {
        private int balance = 1000; // Initial balance
        
        void withdraw(int amount) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " completed withdrawal. Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " - Not enough balance!");
            }
        }
    }

    // example of synchronized method
    static class BankAccount1 {
        private int balance = 1000; // Initial balance
        
        synchronized void withdraw(int amount) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " completed withdrawal. Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " - Not enough balance!");
            }
        }
    }

    // example of synchronized Block
    static class BankAccount2 {
        private int balance = 1000; // Initial balance
        
        synchronized void withdraw(int amount) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " completed withdrawal. Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " - Not enough balance!");
            }
        }
    }

    // example of using lock from from java.util.concurrent.locks
    class BankAccount3 {
        private int balance = 1000; // Initial balance
        private final Lock lock = new ReentrantLock(); // 🔒 Creating a lock object
    
        void withdraw(int amount) {
            lock.lock(); // 🔒 Lock the method
            try {
                if (balance >= amount) {
                    System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " completed withdrawal. Balance: " + balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + " - Not enough balance!");
                }
            } finally {
                lock.unlock(); // 🔓 Always unlock to prevent deadlock
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        
        Thread person1 = new Thread(() -> account.withdraw(800), "Person 1");
        Thread person2 = new Thread(() -> account.withdraw(800), "Person 2");

        person1.start();
        person2.start();

        // 🚨 Problem: Two people withdrew money at the same time, causing an incorrect balance.
        // solution is to use synchronized as part of method definition, which makes sure only one thread can accesss single resource at a time - makes a method thread safe.
    }


}
