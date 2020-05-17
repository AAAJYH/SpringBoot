package com.jyh.regex;

import com.jyh.base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jyh
 * @version 1.0
 * @date 2020/5/9
 */
public class RegexTest extends BaseTest {

    @Test
    public void a() {
        Pattern pattern = Pattern.compile("error");
        Matcher matcher = pattern.matcher("kafka is error");

        boolean flag = matcher.find();

        Assert.assertTrue(true);
    }

}
