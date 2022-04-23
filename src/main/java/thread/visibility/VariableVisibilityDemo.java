package thread.visibility;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * explain the code
 *
 * @author varg
 * @date 2022/4/23 17:15
 */
@Slf4j
public class VariableVisibilityDemo {


    private  static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            int i = 0;
            while (!flag) {
                i++;
                // 可以刷新变量的三种方法
                // 1. 将flag声明为volatile类型

                // 2. synchronized同步块
                // synchronized (VariableVisibilityDemo.class){}

                // 3. IO操作
                // new File("xx.txt");

                // 4. 线程切换
                // Thread.sleep();
                // Thread.yield();

            }
            ;
            log.info("i = {}", i);

        });

        thread.start();
        // 这里更改不会生效
        Thread.sleep(1000);
        flag = true;


    }

}
