package com.jyh.prome.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author jyh
 * @version 1.0
 * @date 2020/9/28
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    private String uri;

    private String type;

    public HttpServerInitializer(String uri, String type) {
        this.uri = uri;
        this.type = type;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // http 编解码
        pipeline.addLast(new HttpServerCodec());
        // http 消息聚合器
        pipeline.addLast("httpAggregator", new HttpObjectAggregator(512 * 1024));
        // 请求处理器
        pipeline.addLast(new HttpRequestHandler(uri, type));
    }

}
