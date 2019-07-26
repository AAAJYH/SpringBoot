import io.netty.util.internal.MathUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/4/8 10:22
 */

/**
 *
 * Assert断言：assert包含一个布尔表达式，当该布尔表达式为空，程序则被认为是正确的；当布尔值为假，则系统会抛出错误；
 * jdk1.4引入，jvm断言默认不开启，idea设置vm options：-ea 开启断言
 *
 *  Junit Assert
 *  Assert.assertEquals（message, expected, actual）如果真实的值和预期的值不一致，则程序抛出java.lang.AssertionError：message
 *  Assert.assertTrue(message, condition)：如果condition为false，则程序抛出java.lang.AssertionError：message
 */
public class Assertion {

    public static void main(String[] args) {
        Assert.assertTrue("操作成功", false);
    }

    @Test
    public void assertOne() {
        Assert.assertEquals("字符串不相等", "123","123a");
        Assert.assertTrue("????", false);
        Assert.assertEquals("预期和真实的对象不相等", true, false);
    }

}
