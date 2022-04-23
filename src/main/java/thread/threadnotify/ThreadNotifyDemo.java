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
public class ThreadNotifyDemo {

    private static Queue<String> queue = new LinkedList<>();
    private static int msgSize = 5;

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {

            int i = 0;

            while (true) {
                synchronized (queue) {

                    while (queue.size() == msgSize) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }


                    log.info("product msg:" + i);
                    queue.add("msg:" + i);
                    i++;
                    queue.notify();

                    try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }


        }, "producer");

        Thread consumer = new Thread(() -> {

            while (true) {
                synchronized (queue) {

                    while (queue.size() == 0) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    log.info("consume msg:" + queue.remove());
                    queue.notify();

                    try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }

        }, "consumer");

        producer.start();
        consumer.start();

    }


}
