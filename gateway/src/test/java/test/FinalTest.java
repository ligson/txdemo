package test;

import java.util.concurrent.locks.ReentrantLock;

public class FinalTest {
    public static void main(String[] args) {
        String name = "aaa";
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            name = "11111";
            throw new OutOfMemoryError("sss");
        } finally {
            lock.unlock();
            System.out.println("oooooo");
        }
    }
}
