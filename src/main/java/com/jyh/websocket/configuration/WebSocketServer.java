package com.jyh.websocket.configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;

/**
 * webSocket具体实现类
 * @Author: jyh
 * @Date: 2019/4/10 16:39
 */

@ServerEndpoint("/webSocket")
@Component
public class WebSocketServer {

    private static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    /**与某个客户端的连接会话，需要通过它来给客户端发送数据 */
    private static ArrayList<WebSocketServer> webSocketServers = new ArrayList<WebSocketServer>();

    private Session session;

    /**
     * 连接建立成功调用的方法
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        /** 添加当前session到集合中 */
        this.session = session;
        webSocketServers.add(this);
        logger.info("连接成功");
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message   客户端发送过来的消息
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        logger.info("收到客户端发过来的消息message："+ message);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketServers.remove(this);
        logger.info("连接已关闭，移除当前对象");
    }

    /**
     * 连接发生错误时
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session,Throwable error){
        error.printStackTrace();
        logger.info("发生错误" );
    }

    /**
     * 发消息
     * @param txt
     */
    public void sendMessage(Session currentSession, String txt){
        try{
            currentSession.getBasicRemote().sendText(txt);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     * @param message
     */
    public static void massMessage(String message) throws IOException {
        for (WebSocketServer webSocketServer: webSocketServers) {
            webSocketServer.sendMessage(webSocketServer.session, message);
        }
        logger.info("群发消息message："+ message);
    }

}
