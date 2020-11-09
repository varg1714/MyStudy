package binary_operation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author varg
 * @date 2020/6/3 22:13
 */
public class BitCompute{

    public static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE;

    public static int orCompute(int capacity){
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ?
                MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
         System.out.println(BitCompute.orCompute(11));
         Map<Object,Object> map = new HashMap<>();
    }

}
