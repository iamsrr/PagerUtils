package org.github.iamsrr;

/**
 * @Description:
 * @Author: Shihy
 * @Date: 2018/4/9 17:01
 */
public class Code {

    private String code;
    private String message;
    private boolean success;
    private Object body;

    public Code() {
    }

    public Code(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Code(String code, String message, Object body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public Code(Object body) {
        this.body = body;
    }

    public Code buildSuccess(String message) {
        this.setCode("1");
        this.setMessage(message);
        this.success = true;
        return this;
    }

    public Code buildSuccess() {
        this.buildSuccess("操作成功");
        return this;
    }

    public Code buildWarning(String message) {
        this.setCode("2");
        this.setMessage(message);
        this.success = true;
        return this;
    }

    public Code buildWarning() {
        this.buildWarning("请求成功,警告!");
        return this;
    }

    public Code buildError(String message) {
        this.setCode("0");
        this.setMessage(message);
        this.success = false;
        return this;
    }

    public Code buildError() {
        this.setMessage("操作失败");
        return this;
    }

    public Code body(Object obj) {
        this.body = obj;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":\"")
                .append(code).append('\"');
        sb.append(",\"message\":\"")
                .append(message).append('\"');
        sb.append(",\"success\":")
                .append(success);
        sb.append(",\"body\":")
                .append(body);
        sb.append('}');
        return sb.toString();
    }
}
