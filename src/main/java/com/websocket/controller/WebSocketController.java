package com.websocket.controller;
import com.websocket.configuration.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

/**
 * 服务器端主动推送
 * @Author: jyh
 * @Date: 2019/4/10 16:39
 */

@Controller
public class WebSocketController {

    /**
     * websocket页面跳转
     * @return
     */
    @RequestMapping("/webSocketTest")
    public String webSocketTest(){
        return "/websocket/webSocket.html";
    }

    /**
     * 服务器主动推送（群发）
     * @param msg
     * @return
     * @throws IOException
     */
    @RequestMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(String msg) throws IOException {
        WebSocketServer.massMessage(msg);
        return "OK";
    }

}
