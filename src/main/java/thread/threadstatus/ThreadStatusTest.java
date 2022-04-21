package thread.threadstatus;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * explain the code
 *
 * @author varg
 * @date 2022/4/21 22:23
 */
public class ThreadStatusTest implements Runnable{

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(new ThreadStatusTest(),"thread1").start();
        new Thread(new ThreadStatusTest(),"thread2").start();

    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("thread run");
        boolean b = reentrantLock.tryLock(100,TimeUnit.SECONDS);
        //synchronized (ThreadStatusTest.class){
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        //}

        reentrantLock.unlock();
    }



}
