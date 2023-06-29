package com.hero.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: pzhu
 * @Date: 2023/6/26 10:21
 */

@Getter
@Setter
public class Result<T> {
    // 是否成功
    private boolean flag;
    // 返回状态码
    private Integer code;
    // 返回消息
    private String message;
    // 返回数据
    private T data;

    public Result(boolean flag, Integer code, String message, T data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(true, StatusCode.OK, message, data);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(true, StatusCode.OK, "操作成功",data);
    }

//    public static <T> Result<T> success(String message, T data){
//        return new Result<T>(true, StatusCode.OK, message, null);
//    }

//    public static Result<String> success(String data){
//        return new Result<>(true, StatusCode.OK, "", data);
//    }


    public static <T> Result<T> error(Integer code, T data){
        return new Result<>(true, code, "操作失败",data);
    }





}
