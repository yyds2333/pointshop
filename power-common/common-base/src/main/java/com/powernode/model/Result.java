package com.powernode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
/**
 * 输出结果的实体类型
 * 数据1 状态码 code
 * 数据2 返回数据 data
 * 数据3 返回消息文本 msg
 */
public class Result<T> {
    private Integer code = 200; // 默认为成功

    private String msg;

    private T data;

    public static <T> Result<T> success(String msg,T data){
        Result<T> result = new Result<>();
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(){
        return success("ok",null);
    }

    public static <T> Result<T> failure(String msg,T data){
        Result<T> result = new Result<>();
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> failure(){
        return success("failed",null);
    }

}
