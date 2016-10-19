package nico.custommvp.utils;


public class Constants {

    public static int env = 1;
    public static final String HTTP_URL_HEADER;

    static {
        HTTP_URL_HEADER = "http://115.29.167.93/api/";
    }

    public static final String HTTP_URL_FM_LOGIN = "fm/login?";


    // Handler返回处理结果类型
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;
    public static final int NET_FAILURE = 2;
    public static final int OTHER_FAILURE = 3;

}
