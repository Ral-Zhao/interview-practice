package data.other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    private ReentrantLock lock;
    private int[] products;
    private int count;
    private int putIndex;
    private int takeIndex;
    private int produceNum;
    private int consumeNum;
    private int limit;
    private Condition notFull;
    private Condition notEmpty;

    public ProducerConsumer(int[] products, int limit) {
        this.products = products;
        this.limit = limit;
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
        this.count = 0;
        this.putIndex = 0;
        this.takeIndex = 0;
    }

    public boolean produce(int product, int num) {
        try {
            lock.lock();
            while (produceNum < limit && count == products.length) {
                notFull.await();
            }
            if (produceNum == limit) {
                System.out.println("Produce reach the limit, producer-" + num + " stop!");
                notEmpty.signalAll();
                return false;
            }
            count++;
            products[putIndex] = product;
            produceNum++;
            System.out.println("producer-" + num + " produce " + product);
            putIndex = (putIndex + 1) % products.length;
            notEmpty.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return true;
    }

    public boolean consume(int num) {
        try {
            lock.lock();
            while (consumeNum < limit && count == 0) {
                notEmpty.await();
            }
            if (consumeNum == limit) {
                System.out.println("Consume reach the limit, consumer-" + num + " stop!");
                notFull.signalAll();
                return false;
            }
            count--;
            consumeNum++;
            System.out.println("consumer-" + num + " consume " + products[takeIndex]);
            takeIndex = (takeIndex + 1) % products.length;
            notFull.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return true;
    }


    public static void main(String[] args) {
        int[] products = new int[10];
        ProducerConsumer producerConsumer = new ProducerConsumer(products, 20);
        Thread producer1 = new Producer(producerConsumer, 1);
        Thread producer2 = new Producer(producerConsumer, 2);
        Thread consumer1 = new Consumer(producerConsumer, 1);
        Thread consumer2 = new Consumer(producerConsumer, 2);
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }

    static class Producer extends Thread {
        private ProducerConsumer producerConsumer;
        private int num;

        public Producer(ProducerConsumer producerConsumer, int num) {
            this.producerConsumer = producerConsumer;
            this.num = num;
        }


        @Override
        public void run() {
            int count = 0;
            while (producerConsumer.produce(count + num * 10, this.num)) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }
    }

    static class Consumer extends Thread {
        private ProducerConsumer producerConsumer;
        private int num;

        public Consumer(ProducerConsumer producerConsumer, int num) {
            this.producerConsumer = producerConsumer;
            this.num = num;
        }


        @Override
        public void run() {
            while (producerConsumer.consume(this.num)) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
