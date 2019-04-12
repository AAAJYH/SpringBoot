package customannotation;

import java.lang.annotation.*;

/**
 * @Documented:表明这个注解应该被javadoc工具记录，会生成注解类型信息文档
 * @Inherited:注解可以被继承
 * @Target:注解的作用目标
 * @Retention:保留策略
 */
@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @ interface ValidateAnnotation {

    public int min() default 1;

    public int max() default 10;

    public boolean isNotNull() default true;

}
