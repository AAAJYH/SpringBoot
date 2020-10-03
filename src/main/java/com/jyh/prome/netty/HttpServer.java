package com.jyh.prome.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;


/**
 * @author jyh
 * @version 1.0
 * @date 2020/9/28
 */
public class HttpServer {

    private int port;

    private String uri;

    private String type;

    public HttpServer(int port, String uri, String type) {
        this.port = port;
        this.uri = uri;
        this.type = type;
    }

    public void start() throws Exception{
        ServerBootstrap bootstrap = new ServerBootstrap();
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        bootstrap.group(boss, work).handler(new LoggingHandler(LogLevel.DEBUG))
                .channel(NioServerSocketChannel.class)
                .childHandler(new HttpServerInitializer(uri, type));

        ChannelFuture channelFuture = bootstrap.bind(new InetSocketAddress(port)).sync();
        System.out.println("server start up on port : " + port);
        channelFuture.channel().closeFuture().sync();
    }

}
