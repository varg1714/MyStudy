package thread.threadnotify;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * explain the code
 *
 * @author varg
 * @date 2022/4/23 15:23
 */
@Slf4j
public class ThreadNotifyDemo2 {

    private static final Queue<String> QUEUE = new LinkedList<>();
    private static int msgSize = 5;

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {

            synchronized (QUEUE) {

                int temp = msgSize;
                log.info("读取临时变量 : {}", temp);
                try {
                    // wait以后会释放锁，线程2将会获取到锁
                    QUEUE.wait();
                    //TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                msgSize = temp + 1;
                log.info("temp + 1: {}", msgSize);

                QUEUE.notify();

                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }, "producer");

        Thread consumer = new Thread(() -> {

            synchronized (QUEUE) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                    msgSize = 10;
                    log.info("修改同步代码块中变量到10");
                    QUEUE.notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        }, "consumer");

        producer.start();
        consumer.start();

    }


}
