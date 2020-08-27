package function_program;

import lombok.Data;

/**
 * @author varg
 * @date 2020/8/27 17:57
 */
@Data
public class BaseObject {

    private String username;
    private int age;

    public int grow(int year){

        return age += year;

    }

}
