package com.zy.entity;

/**
 * @author zhuangy
 * @version V1.0
 * @Title: NetworkAddressSymbol
 * @Package com.zy.entity
 * @Description: 网络地址符号
 * @date 2021/3/16 0016 16:00
 **/

public class NetworkAddressSymbol {
    public final static String REQUEST_AGREEMENT = "http";
    public final static String COLON = ":";
    public final static String DOUBLE_SLASH = "//";
    public final static String SLASH = "/";

    public static String getHttpAgreement() {
        return NetworkAddressSymbol.REQUEST_AGREEMENT + NetworkAddressSymbol.COLON + NetworkAddressSymbol.DOUBLE_SLASH;
    }
}
