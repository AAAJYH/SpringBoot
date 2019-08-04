package com.jyh.websocket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 设置webSocket终端服务
 * @Author: jyh
 * @Date: 2019/4/10 16:39
 */

//@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

}
