package classloader;
/**
 * @author varg
 * @date 2020/6/21 17:48
 *
 * 在main方法执行之前被执行的方法：
*     1.static代码块中调用了静态方法 静态方法会先执行
 *
 */

public class MethodInvokeBeforeMain {

    // 静态代码块
    static {
        // 该方法会在main方法执行之前被调用 调用时间发生在类加载期静态代码块的初始化过程中
        System.out.println("静态代码块初始化");
        MethodInvokeBeforeMain.start();
    }
    
    public static void main(String[] args) {
        System.out.println("main invoke");
    }

    public static void start() {
        System.out.println("before main invoke");
    }
}
