package com.gt.utils;

/**
 * @Describe :
 * @Author : byron
 * @Date 2018/2/5 0005 17:55
 */
public class ResponseMessageConst {
    /**
     * 成功状态
     */
    public static final int SUCCESS = 0;

    /**
     * 失败状态
     */
    public static final int FAIL = 1;

    /**
     * 会话失效状态
     */
    public static final int FAIL_NOSESSION = 2;


    /**
     * 通用成功提示
     */
    public static final String BASE_SUCCESS = "操作成功!";

    /**
     * 通用失败提示
     */
    public static final String BASE_FAIL = "操作失败!";

    /**
     * 保存成功
     */
    public static final String SAVE_SUCCESS = "保存成功!";

    /**
     * 提交成功
     */
    public static final String SUBMIT_SUCCESS = "提交成功!";

    /**
     * 提交失败
     */
    public static final String SUBMIT_FAIL = "提交失败!";

    /**
     * 保存失败
     */
    public static final String SAVE_FAIL = "保存失败!";

    /**
     * 打印成功
     */
    public static final String PRINT_SUCCESS = "打印成功!";

    /**
     * 打印失败
     */
    public static final String PRINT_FAIL = "打印失败!";

    /**
     * 支付成功
     */
    public static final String PAY_SUCCESS = "支付成功!";

    /**
     * 支付失败
     */
    public static final String PAY_FAIL = "支付失败!";

    /**
     * 结算成功
     */
    public static final String BALANCE_SUCCESS = "结算成功!";

    /**
     * 结算失败
     */
    public static final String BALANCE_FAIL = "结算失败!";

    /**
     * 查询失败
     */
    public static final String QUERY_FAIL = "查询失败!";

    /**
     * 删除成功
     */
    public static final String DELETE_SUCCESS = "删除成功!";

    /**
     * 删除失败
     */
    public static final String DELETE_FAIL = "删除失败!";

    /**
     * 缺少必要参数
     */
    public static final String ABSENCE_PARAMS = "缺少必要参数!";

    /**
     * SESSION失效
     */
    public static final String NO_SESSION = "由于您长时间未操作,为保证安全,请重新登录!";

    /**
     * 没开启外卖
     */
    public static final String NO_TAKEAWAY = "该商家很懒，暂无开启外卖功能，敬请期待!";

    /**
     * 没开启预订
     */
    public static final String NO_BOOK = "该商家很懒，暂无开启预订功能，敬请期待!";

    /**
     * 没开启排队
     */
    public static final String NO_QUEUE = "该商家很懒，暂无开启排队功能，敬请期待!";

    /**
     * 不在营业时间内
     */
    public static final String OUT_OF_TIME_RANGE_BUSINESS = "该时间点商家正在休息!";

    /**
     * 不在外卖时间内
     */
    public static final String OUT_OF_TIME_RANGE_TAKEAWAY = "该时间点商家正在休息!";

    /**
     * 不在预订时间范围
     */
    public static final String OUT_OF_TIME_RANGE_BOOK = "该时间点商家不接受预订!";

    /**
     * 计算失败
     */
    public static final String COUNT_FAIL = "计算失败!";

    /**
     * 计算成功
     */
    public static final String COUNT_SUCCESS = "计算成功!";

    /**
     * 取消成功!
     */
    public static final String CANCEL_SUCCESS = "取消成功!";

    /**
     * 取消失败!
     */
    public static final String CANCEL_FAIL = "取消失败!";
}
