package com.jyh.prome.netty;

/**
 * @author jyh
 * @version 1.0
 * @date 2020/9/28
 */
public class Application {

    private static final String METRIC_TYPE = "metric";
    private static final String ALERT_TYPE = "alert";

    public static void main(String[] args) throws Exception {
        HttpServer server = new HttpServer(8081, "/receive", METRIC_TYPE);
        server.start();

    }

}
