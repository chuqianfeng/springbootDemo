package com.gt.utils;

import com.alibaba.fastjson.JSONArray;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/5/2.
 */
public class CommonUtil {
    private CommonUtil() {
    }
    /**
     * 返回json数据到客户端
     *
     * @param response
     * @param obj
     * @throws IOException
     */
    public static void write(HttpServletResponse response, Object obj) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String result = "";
        if (obj instanceof List || obj instanceof Object[]) {
            result = JSONArray.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
        } else {
            result = com.alibaba.fastjson.JSONObject.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
        }
        response.getWriter().print(result);
        response.getWriter().flush();
        response.getWriter().close();
    }

    /**
     * 判断对象是否为空
     */
    public static boolean isEmpty(Object obj) {
        boolean b = false;
        try {
            if (obj == null || "".equals(obj) || "null".equals(obj)) {
                b = true;
            } else {
                b = false;
            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 判断对象是否不为空
     */
    public static boolean isNotEmpty(Object obj) {
        boolean b = false;
        try {
            if (obj == null || "".equals(obj) || "null".equals(obj)) {
                b = false;
            } else {
                b = true;
            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 转Integer
     */
    public static Integer toInteger(Object obj) {
        try {
            if (!isEmpty(obj)) {
                return Integer.parseInt(obj.toString());
            } else {
                throw new RuntimeException("对象为空，转换失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Integer toIntegerByDouble(double obj) {
        try {
            return (int) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转String
     */
    public static String toString(Object obj) {
        try {
            if (!isEmpty(obj)) {
                return obj.toString();
            } else {
                throw new RuntimeException("对象为空，转换失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转Double
     */
    public static Double toDouble(Object obj) {
        try {
            if (!isEmpty(obj)) {
                return Double.parseDouble(obj.toString());
            } else {
                throw new RuntimeException("对象为空，转换失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验是否是double数据
     */
    public static boolean isDouble(Object obj) {
        try {
            Double.parseDouble(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}