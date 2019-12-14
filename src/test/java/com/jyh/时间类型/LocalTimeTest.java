package com.jyh.时间类型;

import org.junit.Test;

import java.time.LocalTime;

/**
 * @author jyh
 * @date 2019/12/11
 * @description
 */

public class LocalTimeTest {

    @Test
    public void a() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getNano());

        LocalTime localTime1 = LocalTime.of(0, 2, 0);
        System.out.println(localTime1.getMinute());

        LocalTime localTime2 = LocalTime.ofSecondOfDay(60);
        System.out.println(localTime2.getHour() + " " +localTime2.getSecond());

        String localTimeStr = "11:25:11";
        LocalTime localTime3 = LocalTime.parse(localTimeStr);
        System.out.println(localTime3);
    }

}
