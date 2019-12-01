package com.jyh.autowired;

import org.springframework.stereotype.Service;

/**
 * @author jyh
 * @date 2019/12/1
 * @description
 */

@Service("aInterfaceImpl")
public class AInterfaceImpl implements AInterface {

    @Override
    public void msg() {
        System.out.println("impl 1");
    }

}
