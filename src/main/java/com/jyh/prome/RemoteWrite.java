package com.jyh.prome;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @author jyh
 * @version 1.0
 * @date 2020/9/9
 */

@RestController
public class RemoteWrite {


    /**
     * 值样例
     * labels {
     *   name: "__name__"
     *   value: "node_network_carrier"
     * }
     * labels {
     *   name: "instance"
     *   value: "192.168.31.94:9100"
     * }
     * labels {
     *   name: "interface"
     *   value: "lo"
     * }
     * labels {
     *   name: "job"
     *   value: "ser3"
     * }
     * samples {
     *   value: 1.0
     *   timestamp: 1601196944995
     * }
     *
     * ------------------
     * labels {
     *   name: "__name__"
     *   value: "mysql_global_status_delayed_writes"
     * }
     * labels {
     *   name: "instance"
     *   value: "192.168.31.40:9101"
     * }
     * labels {
     *   name: "job"
     *   value: "ser4"
     * }
     * samples {
     *   timestamp: 1601196946516
     * }
     * @param body
     * @param request
     * @throws IOException
     * @throws InterruptedException
     */
    @RequestMapping(value = "/receive")
    public void write(@RequestBody byte[] body, HttpServletRequest request) throws IOException, InterruptedException {


    }
//
//    public static byte[] uncompress1(String compressedStr) {
//        if (compressedStr == null) {
//            return null;
//        }
//        return Base64.decodeBase64(compressedStr);
//    }


        //        System.out.println(request.getHeader("Content-Encoding"));
//        System.out.println(new String(Snappy.uncompress(body.getBytes("UTF-8")), "UTF-8"));
//        System.out.println(body);
//        JsonNode jsonNode = new ObjectMapper().readTree(body);
//        System.out.println(jsonNode.toString());

//        BufferedReader bufferedReader = request.getReader();
//        String s;
//        StringBuffer sb = new StringBuffer();
//        while((s = bufferedReader.readLine()) != null){
//            sb.append(s+"\n");
//        }
//        bufferedReader.close();
//        System.out.println(sb);

//        System.out.println(Snappy.uncompress(body.getBytes()));
//        CodedInputStream codedInputStream = CodedInputStream.newInstance(body.getBytes());
//        System.out.println(Remote.WriteRequest.parseFrom(body.getBytes()));
//        System.out.println(codedInputStream.readTag());
//        System.out.println(Remote.WriteRequest.parseFrom(codedInputStream));
//        System.out.println(body.getBytes().length);
//        Snappy snappy = new Snappy();
//        ByteBuf buf = Unpooled.buffer(200);
//        byte[] bytes  = body.getBytes();
//        byte[] newByte = new byte[101];
//        for (int i = 0; i < 100; i++) {
//         newByte[i] = bytes[i];
//        }
//        ByteBuf byteBuf = Unpooled.wrappedBuffer(newByte);
//        snappy.decode(byteBuf, buf);
////
////        System.out.println(buf);
//        System.out.println(buf);
//        ProtobufDecoder protobufDecoder = new ProtobufDecoder(Remote.WriteRequest.getDefaultInstance());
//
//        Remote.ReadResponse writeRequest = Remote.ReadResponse.parseFrom(body.getBytes());
//        System.out.println(writeRequest);
//        Remote.WriteRequest.Builder builder = Remote.WriteRequest.newBuilder();
//        builder.mergeFrom(body.getBytes(), 0, body.getBytes().length);
//        Remote.WriteRequest writeRequest = builder.build();
//        byte[] byteArray = writeRequest.toByteArray();
//        Remote.WriteRequest parseFrom = Remote.WriteRequest.parseFrom(byteArray);
////        System.out.println(parseFrom);
//    FileWriter writer;
//        try {
//
//        writer = new FileWriter("/Applications/aaa/" + UUID.randomUUID().toString().replace("-", "")+".txt");
//        writer.write("");//清空原文件内容
//        writer.write( "----------------------------   "+ body + "    ------------------------------");
//        writer.flush();
//        writer.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }


}





