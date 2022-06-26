package com.evanemran.valorantgg.Listeners;

public interface ApiResponseListener<T> {
    void didFetch(T response, String message);
    void didError(String message);
}
