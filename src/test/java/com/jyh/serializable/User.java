package com.jyh.serializable;

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * @author jyh
 * @date 2019/11/11
 * @description：
 */

@AllArgsConstructor
public class User implements Serializable {


    private static final long serialVersionUID = 5936476746653719866L;

    private String userId;

    private String userName;

}
