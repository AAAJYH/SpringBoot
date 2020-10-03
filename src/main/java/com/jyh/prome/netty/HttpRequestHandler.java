package com.jyh.prome.netty;

import com.jyh.prome.protobuf.Remote;
import com.jyh.prome.protobuf.Types;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import org.xerial.snappy.Snappy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jyh
 * @version 1.0
 * @date 2020/9/28
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private String uri;

    private String type;

    public HttpRequestHandler(String uri, String type) {
        this.uri = uri;
        this.type = type;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest fullHttpRequest) throws Exception {

        // 1. 获取请求标志符uri
        String requestri = fullHttpRequest.uri();
        if (uri.equals(uri)) {
            // 返回请求的内容
            ByteBuf byteBuf = fullHttpRequest.content();

            // 2. ByteBuf中读取byte[]
            // 返回可读字节数
            byte[] bytes = new byte[byteBuf.readableBytes()];

            // 将此缓冲区的数据传输到bytes
            byteBuf.readBytes(bytes);

                // 3.解压缩
                byte[] a = Snappy.uncompress(bytes);

                // 4.protobuf解码
                List<Types.TimeSeries> timeSeriesList = Remote.WriteRequest.parseFrom(a).getTimeseriesList();

                // 5. 封装收集对象
                for (Types.TimeSeries timeSeries : timeSeriesList) {
                    // 样例值
                    List<Types.Sample> samples = timeSeries.getSamplesList();
                    // 标签
                    List<Types.Label> labels = timeSeries.getLabelsList();

                    Map<String, Object> map = new LinkedHashMap<>();
                    for (Types.Label label : labels) {
                        map.put(label.getName(), label.getValue());
                    }
                    for (Types.Sample sample : samples) {
                        map.put("timestamp", sample.getTimestamp());
                        map.put("value", sample.getValue());
                    }
                    // {__name__=node_schedstat_waiting_seconds_total, cpu=2, instance=192.168.31.168:9100, job=ser2, timestamp=1601257802081, value=3585.638624391}
                    // 6. flink收集
                    System.out.println(map);
                }
                System.out.println("------------------");
        }


//        Map<String, String> resMap = new HashMap<>();
//        resMap.put("method", fullHttpRequest.method().name());
//        resMap.put("uri", uri);
//        String msg = "你请求的uri为：" + uri;
//
//        System.out.println("method: " + fullHttpRequest.method().name());
//        System.out.println("uri: " + fullHttpRequest.uri());
//
//        // 创建http响应
//        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
//                Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
//
//        //设置头信息
//        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=UTF-8");
//
//        // 讲html写到客户端
//        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }



}
