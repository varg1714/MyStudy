package stream;

import java.util.Arrays;

/**
 * @author varg
 * @date 2020/7/28 18:23
 */
public class StreamStart {

    Integer[] nums = new Integer[]{1, 2, 3, 4, 5};

    public void foreachUse() {
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().forEach(i -> {
            if (i == 2) {
                return;
            }
            System.out.println(i);
        });
    }

    public static void main(String[] args) {
        StreamStart streamStart = new StreamStart();
        streamStart.foreachUse();
    }

}
