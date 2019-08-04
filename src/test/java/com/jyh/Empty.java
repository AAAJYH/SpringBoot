package com.jyh;

import org.apache.shiro.util.CollectionUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Empty {

    public static void main(String[] args) throws ParseException {

        List list = new ArrayList();

        /**
         * 不会报空指针异常
         */
        System.out.println(CollectionUtils.isEmpty(list));

        /**
         * 当list为null时回报空指针异常，因为list为空的时候就没法调用List的方法了
         */
        System.out.println(list.isEmpty());

    }

}
