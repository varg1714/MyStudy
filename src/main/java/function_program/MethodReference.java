package function_program;

import java.util.function.BiPredicate;
import java.util.function.Supplier;

/**
 * @author varg
 * @date 2020/8/27 17:59
 */
public class MethodReference {

    public static void main(String[] args) {
        BaseObject baseObject = new BaseObject();

        baseObject.setAge(18);

         Supplier<String> username = baseObject::getUsername;
        System.out.println(username);

        BiPredicate<String,String> predicate = String::equals;

        System.out.println(predicate.test("x","x"));

    }

}
