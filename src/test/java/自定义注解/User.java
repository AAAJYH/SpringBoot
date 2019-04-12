package 自定义注解;

import lombok.Data;
import 自定义注解.CustomAnnotation;

@Data
public class User {

    @CustomAnnotation(value=40)
    private int age;

}
