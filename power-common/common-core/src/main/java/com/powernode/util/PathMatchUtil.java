package com.powernode.util;


public class PathMatchUtil {
    /**
     * http://localhost:8080/doLogin
     * http://localhost:8080/doLogout
     */

    private static final String[] PATH = {
            "http://localhost:8080/doLogin"
    };

    /**
     * 包含在内的地址放行
     * @param uri
     * @return
     */
    public static boolean compare(String uri){
        for (String url:PATH) {
            if (url.equals(uri)){
                return true;
            }
        }
        return false;
    }
}
