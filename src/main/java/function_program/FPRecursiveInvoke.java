package function_program;

/**
 * @author varg
 * @date 2020/8/27 17:19
 */
public class FPRecursiveInvoke {

    static FpCall fpCall;

    public static void main(String[] args) {
        fpCall = i -> i == 0 ? 1 : fpCall.call(i - 1) * i;

        for (int i = 0; i < 5; i++) {
            System.out.println(fpCall.call(i));
        }

        fpCall = i -> i == 0 ? 1 : i == 1 ? 1 : fpCall.call(i - 1)  + fpCall.call(i - 2);

        for (int i = 0; i < 10; i++) {
            System.out.println(fpCall.call(i));
        }

    }

}

interface FpCall{
    int call(int parm);
}