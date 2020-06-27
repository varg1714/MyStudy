package thread;

import java.util.concurrent.*;

/**
 * @author varg
 * @date 2020/6/4 0:29
 *
 * 锁住Class类后并不影响实例的使用
 */
public class ThreadPoolStudy implements Runnable {

    /**
     * 用于等待争抢ThreadPoolStudy.class锁的两个线程启动完毕
     */
    public static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                5, 3L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });

        // 启动两个线程竞争ThreadFactory.class的锁
        executor.execute(new ThreadPoolStudy());
        executor.execute(new ThreadPoolStudy());

        try {
            // 等待上面线程线程启动
            Thread.sleep(500);

            // 实例对象方法的调用 若阻塞的话证明需要获取ThreadFactory.class的锁
            // 结果：未阻塞,获取的是实例对象的锁
            new ThreadPoolStudy().init();
            System.out.println("--实例方法执行完毕--");

            // 静态方法的调用
            // 结果：阻塞，获取的是ThreadFactory.class的锁
            ThreadPoolStudy.clockSynchronizedMethod();
            System.out.println("clockSynchronizedMethod静态方法执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        // System.exit(0);
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("等待获取锁: " + name);
        synchronized (ThreadPoolStudy.class) {
            System.out.println("获取到锁：" + name);
            try {
                System.out.println("锁住Class三秒: " + name);
                Thread.sleep(3000);
                System.out.println("释放锁: " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }

    public synchronized void init() {
        System.out.println("--获取到锁，实例方法开始执行--");
    }

    public synchronized static void clockSynchronizedMethod() {
        System.out.println("--获取到锁，静态方法开始执行--");
    }

}