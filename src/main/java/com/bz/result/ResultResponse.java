package com.bz.result;

/**
 * API返回
 *
 * @Author Huanghao
 * @Create 2018-11-13 14:54
 */
public class ResultResponse {

    /**
     * 返回状态值
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 附加数据
     */
    private Object data;

	public Integer getResult() {
		return code;
	}

	public void setResult(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
     * 构造返回数据组装
     *
     * @param code
     * @param msg
     * @param data
     */
    public ResultResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

	public ResultResponse(Integer code, Object data) {
		this.code = code;
		this.data = data;
	}


    @Override
    public String toString() {
        return "ResultResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
