package hpu.edu.xingsi.util;


import hpu.edu.xingsi.Enum.ResponseCodeEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhou'en'xian
 * @date 2020/9/10  20:54
 */
@Data
public  class ResponseResult {
    private Integer code;
    private String msg;
    private Map<String,Object>data=new HashMap<>();

    private ResponseResult(){
    };
    //通用返回成功
    public static ResponseResult success(){
        ResponseResult responseResult=new ResponseResult();
        responseResult.setCode(ResponseCodeEnum.SUCCESS.getCode());
        responseResult.setMsg(ResponseCodeEnum.SUCCESS.getMsg());
        return responseResult;
    }
    //通用返回失败
    public  static ResponseResult fail(){
        ResponseResult responseResult=new ResponseResult();
        responseResult.setCode(ResponseCodeEnum.FAIL.getCode());
        responseResult.setMsg(ResponseCodeEnum.FAIL.getMsg());
        return responseResult;
    }
    //设置数据体
    public  ResponseResult data(Map<String,Object> map){
       this.setData(map);
       return  this;
    }
    public ResponseResult data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
    //定制状态码
    public ResponseResult code(Integer code){
        this.setCode(code);
        return this;
    }
    //定制状态信息
    public ResponseResult msg(String msg){
        this.setMsg(msg);
        return this;
    }
}
