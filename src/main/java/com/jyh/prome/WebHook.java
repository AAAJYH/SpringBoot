package com.jyh.prome;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jyh
 * @version 1.0
 * @date 2020/9/9
 */

@RestController
public class WebHook {

    @RequestMapping("/send")
    public String a(@RequestBody String body) {
        System.out.println(body);
        return "";
    }

}
