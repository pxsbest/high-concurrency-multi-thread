package org.pinery;

/**
 * 客户提交的任何业务受理请求都会被封装成 Request 对象
 **/
public class Request {
    private final String buniess;

    public Request(String buniess) {
        this.buniess = buniess;
    }

    @Override
    public String toString() {
        return buniess;
    }

}
