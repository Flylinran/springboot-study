package cn.flylinran.exception;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description: 封装API异常码
 * version: 1.0
 */
public enum ExceptionCode {

    EX_10000(10000, "业务异常"),
    EX_10001(10001, "参数异常"),
    EX_10002(10002, "Unknown异常");

    private int code;
    private String message;

    /**
     * 构造方法，默认private
     *
     * @param code    状态码
     * @param message 状态码描述
     */
    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获得状态码
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * 获得状态码描述
     *
     * @return
     */
    public String getMessage() {
        return message;
    }
}
