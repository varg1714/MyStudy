package stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static reactor.core.publisher.Mono.when;

/**
 * @author varg
 * @date 2020/7/28 18:36
 */
@RunWith(MockitoJUnitRunner.class)
public class StreamStartTest {

    StreamStart streamStart = new StreamStart();

    @Mock
    List<Integer> list;

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

    @Test
    public void mockUseTest(){
        Mockito.when(list.get(0)).thenReturn(0);
        System.out.println(list.get(0));
        Mockito.verify(list.get(0));
    }


}
