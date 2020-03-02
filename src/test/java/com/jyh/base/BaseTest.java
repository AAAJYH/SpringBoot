package com.jyh.base;

import com.jyh.TestRun;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: jyh
 * @date: 2019/8/4
 * @description：SpringBoot基础测试类
 */

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRun.class)
public class BaseTest {

    @Before
    public void before() {
      log.info("开始测试 - - - - - -");
    }

    @After
    public void after() {
        log.info("测试结束 - - - - - -");
    }

}
