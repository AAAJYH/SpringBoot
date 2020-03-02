package com.jyh.autowired;

import org.springframework.stereotype.Service;

/**
 * @author jyh
 * @date 2019/12/1
 * @description
 */

@Service("bInterfaceImpl")
public class BInterfaceImpl implements AInterface {

    @Override
    public void msg() {
        System.out.println("impl 2");
    }

}
