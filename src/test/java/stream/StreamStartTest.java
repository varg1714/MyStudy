package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author varg
 * @date 2020/7/28 18:36
 */
public class StreamStartTest {

    StreamStart streamStart = new StreamStart();

    @Test
    public void foreachUse(){
        streamStart.foreachUse();
    }

    @Test
    public void streamInit(){
        List<Integer> integers = Arrays.asList(streamStart.nums);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

}
