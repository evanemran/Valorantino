package com.evanemran.valorantgg.Models;

public class ApiResponse<T> {
    int status = 0;
    T data = null;

    public int getStatus() {
        return status;
    }

    public T getResponse() {
        return data;
    }
}
