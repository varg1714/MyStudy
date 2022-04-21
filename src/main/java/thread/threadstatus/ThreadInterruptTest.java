package thread.threadstatus;

import java.util.concurrent.TimeUnit;

/**
 * explain the code
 *
 * @author varg
 * @date 2022/4/21 23:24
 */
public class ThreadInterruptTest implements Runnable {


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("hi");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // 处理中断信号，由线程本身决定是否响应中断

                // 1. 处理1，响应中断，退出循环
                //Thread.currentThread().interrupt();

                // 2. 忽略中断,当按照此种方式处理后，线程并不会退出。当异常抛出后，操作系统会将线程状态复位。
                // 此时当前线程的Interrupt标记仍然为false
                continue;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadInterruptTester = new Thread(new ThreadInterruptTest(), "threadInterruptTester");
        threadInterruptTester.start();

        TimeUnit.MICROSECONDS.sleep(200);

        // 触发中断
        threadInterruptTester.interrupt();

    }

}
