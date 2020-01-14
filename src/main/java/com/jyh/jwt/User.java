package com.jyh.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: jyh
 * @date: 2019/10/21
 * @description：
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

     private String openId;
     private String phone;

}
