package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

/**
 * Created by 22823 on 2016/11/2.
 */
import java.io.Serializable;

public class HttpJsonResponse implements Serializable {//返回的JSON数据的基类，由于用于返回于网络流，需要序列化
    private static final long serialVersionUID = 1L;
    private String code;
    private Object data;

    public HttpJsonResponse() {
        super();
    }
    public HttpJsonResponse(String code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
