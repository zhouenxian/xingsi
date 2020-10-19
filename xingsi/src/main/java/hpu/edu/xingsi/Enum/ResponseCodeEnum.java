package hpu.edu.xingsi.Enum;

/**
 * @author zhou'en'xian
 * @date 2020/9/10  20:39
 */
public enum ResponseCodeEnum {
    SUCCESS(0,"成功"),
    FAIL(1,"失败");
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResponseCodeEnum() {
    }
    ResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }



}
