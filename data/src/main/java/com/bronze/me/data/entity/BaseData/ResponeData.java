package com.bronze.me.data.entity.BaseData;

/**
 * Created by lxg on 2016/3/17.
 */
public abstract class ResponeData<T extends Data> {
    private String state;
    private String message;
    private T data;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
