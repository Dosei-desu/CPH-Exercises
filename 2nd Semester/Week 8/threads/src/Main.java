public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new WorkerClass());
        Thread t2 = new Thread(new DeWorkerClass());
        Thread t3 = new Thread(new WorkerClass());
        Thread t4 = new Thread(new DeWorkerClass());
        Thread t5 = new Thread(new WorkerClass());
        Thread t6 = new Thread(new DeWorkerClass());

        /*
        //test to see if there's an discernible difference between user and daemon thread in this example (there isn't)
        t1.setDaemon(true);
        t2.setDaemon(true);
        t3.setDaemon(true);
        t4.setDaemon(true);
        t5.setDaemon(true);
        t6.setDaemon(true);
        */

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        //joins to ensure that Threads finish before the result is printed
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();

        System.out.println(sharedResource.number);
    }
}

class sharedResource {
    public static int number = 10;
    //synchronised voids that do what the Decrement and Increment methods did in the Worker Classes, this prevents
    //multi-threading issues when two or more threads access the same variable
    //synchronised "locks" the code block so that it cannot be interfered with and thus prevents basic multi-
    //threading problems
    public static synchronized void decr(){number--;}
    public static synchronized void incr(){number++;}
}

class DeWorkerClass implements Runnable {
    @Override
    public void run() {
        decrement();
    }

    public void decrement() {
        for(int i=0; i < 1000000; i++) {
            sharedResource.decr();
        }
    }

}

class WorkerClass implements Runnable {
    @Override
    public void run() {
        increment();
    }

    public void increment() {
        for(int i=0; i < 1000000; i++) {
            sharedResource.incr();
        }
    }
}
