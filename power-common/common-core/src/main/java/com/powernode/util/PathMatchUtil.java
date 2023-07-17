package com.powernode.util;


import org.springframework.util.AntPathMatcher;

import java.util.List;

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
    public static boolean compare(String[] urls, String uri){
        AntPathMatcher matcher = new AntPathMatcher();
        for (String url:urls) {
            if (matcher.match(url,uri)){
                return true;
            }
        }
        return false;
    }
}
