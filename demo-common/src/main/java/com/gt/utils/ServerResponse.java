package com.gt.utils;

import java.io.Serializable;

/**
 * @Describe : 统一响应类
 * @Author :byron
 * @Date 2018/2/5 0005 17:54
 */
public class ServerResponse<T> implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 状态码 0成功 1失败 2会话失效
     */
    private int code = 1;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 泛型数据
     */
    private T data;


    private Class<T> clz;


    public Class<T> getClz() {
        return clz;
    }

    public void setClz(Class<T> clz) {
        this.clz = clz;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ServerResponse() {
    }

    private ServerResponse(Class<T> clz) {
    }

    private ServerResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }




    private ServerResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private ServerResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ServerResponse<T> createServerResponse() {
        return new ServerResponse<>();
    }

    public static <T> ServerResponse<T> createServerResponse(Class<T> clz) {

        return new ServerResponse<>(clz);
    }

    /**
     * 创建一个默认的"操作成功"的响应  -- 不带任何自定义数据
     *
     * @return
     */
    public static <T> ServerResponse<T> createBySuccss() {
        return new ServerResponse<>(ResponseMessageConst.SUCCESS, ResponseMessageConst.BASE_SUCCESS);
    }

    /**
     * 创建一个默认的"操作失败"的响应 -- 不带任何自定义数据
     *
     * @return
     */
    public static <T> ServerResponse<T> createByFail() {
        return new ServerResponse<>(ResponseMessageConst.FAIL, ResponseMessageConst.BASE_FAIL);
    }

    /**
     * 创建一个默认的"操作成功"的响应
     *
     * @param data 自定义数据
     * @return
     */
    public static <T> ServerResponse<T> createBySuccss(T data) {
        return new ServerResponse<>(ResponseMessageConst.SUCCESS, ResponseMessageConst.BASE_SUCCESS, data);
    }

    /**
     * 创建一个自定义的成功响应
     *
     * @param message 提示语句
     * @return
     */
    public static <T> ServerResponse<T> createBySuccss(String message) {
        return new ServerResponse<>(ResponseMessageConst.SUCCESS, message);
    }

    /**
     * 创建一个自定义的失败响应
     *
     * @param message 提示语句
     * @return
     */
    public static <T> ServerResponse<T> createByFail(String message) {
        return new ServerResponse<>(ResponseMessageConst.FAIL, message);
    }

    /**
     * 创建一个自定义的成功返回响应
     *
     * @param message 提示语句
     * @param data    返回数据
     * @return
     */
    public static <T> ServerResponse<T> createBySuccss(String message, T data) {
        return new ServerResponse<>(ResponseMessageConst.SUCCESS, message, data);
    }

    /**
     * 创建一个会话失效返回响应
     *
     * @param data
     * @return
     */
    public static <T> ServerResponse<T> createNoSession(T data) {
        return new ServerResponse<>(ResponseMessageConst.FAIL_NOSESSION, ResponseMessageConst.NO_SESSION, data);
    }

    /**
     * 创建一个自定义类型
     *
     * @param code
     * @param data
     * @return
     */
    public static <T> ServerResponse<T> createCustom(int code, T data) {
        return new ServerResponse<>(code, data);
    }

    /**
     * 创建一个自定义类型
     *
     * @param code
     * @param msg
     * @return
     */
    public static <T> ServerResponse<T> createCustom(int code, String msg) {
        return new ServerResponse<>(code, msg);
    }

    /**
     * 创建一个自定义类型
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static <T> ServerResponse<T> createCustom(int code, String msg, T data) {
        return new ServerResponse<>(code, msg, data);
    }

    public void createByFail(ServerResponse<?> sr, String message) {
        msg = message;
    }
}
