package customannotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * Documented：表明这个注解应该被javadoc工具记录，会生成注解类型信息文档
 * @Target：注解的作用目标
 * @Inherited：注解可以被继承  inherited:遗传的
 * @Retention：注解的保留策略   retention:保留
 */
@Documented
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @ interface InitAnnotation {

    public String value() default "";

}
