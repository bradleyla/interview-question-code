package InterviewPrep2;

/*
How would you implement a producer-consumer scenario using the wait() and notify() methods?
 */

class Company {
    volatile int item;
    boolean flag = false;

    // starts here
    synchronized void producer(int item) throws InterruptedException {
        System.out.println("1");

        // switches to consumer and pauses
        if(!flag) {
            wait();
        }

        // switches item value 2 to 1
        this.item = item;
        System.out.println("Producer: " + this.item);
        flag = true;
        System.out.println("2");

        // unblocks consumer and continues
        notify();
        System.out.println("3");
    }

    synchronized int consumer() throws InterruptedException {
        System.out.println("4");

        // passes through since producer hasn't switched flag yet
        if(flag) {
            wait();
        }

        item = 2;
        System.out.println("Consumer: " + this.item);
        flag = false;
        System.out.println("5");

        // unblocks producer and continues
        notify();
        System.out.println("6");

        // waits for producer to notify
        if(!flag) {
            wait();
        }
        System.out.println("7");
        return item;
    }
}

class Producer extends Thread {
    Company company;
    public Producer(Company company) {
        this.company = company;
    }

    @Override
    public void run() {
        try {
            company.producer(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    Company company;
    int item;
    public Consumer(Company company) {
        this.company = company;
    }

    @Override
    public void run() {
        try {
            item = company.consumer();
            System.out.println("Returned: " + item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CompanyProducerConsumer {
    public static void main(String[] args) {
        Company company = new Company();
        Producer producer = new Producer(company);
        Consumer consumer = new Consumer(company);
        producer.start();
        consumer.start();
    }
}
