package com.jyh;

import lombok.Data;

import java.io.Serializable;

/**
 * 主题内容BO类
 *
 * @author liujc
 * @date 2019/7/26
 **/
@Data
public class ThemeContentBO implements Serializable {

    private static final long serialVersionUID = 6452825220633092044L;

    /**
     * 图片地址
     */
    private String img_url;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 链接调整地址
     */
    private String link;

    /**
     * 每天签到次数
     */
    private Integer qdnum;

    /**
     * 积分数
     */
    private Integer jfnum;

    /**
     * 优惠券id
     */
    private Integer coupons;

    /**
     * 赠送的积分数
     */
    private Integer integral;
}
