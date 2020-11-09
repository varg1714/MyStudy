package base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author varg
 * @date 2020/9/21 0:33
 */
public class NullParamListAddTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());

    }

}
