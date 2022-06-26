package com.evanemran.valorantgg.Manager;

import android.content.Context;

import com.evanemran.valorantgg.Listeners.ApiResponseListener;
import com.evanemran.valorantgg.Models.ApiResponse;
import com.evanemran.valorantgg.Models.BuddiesResponse;
import com.evanemran.valorantgg.Models.BundlesResponse;
import com.evanemran.valorantgg.Models.Datum;
import com.evanemran.valorantgg.Models.EventsResponse;
import com.evanemran.valorantgg.Models.MapsResponse;
import com.evanemran.valorantgg.Models.Weapons;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://valorant-api.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void GetAgents(ApiResponseListener<List<Datum>> listener){
        CallAgents callAgents = retrofit.create(CallAgents.class);
        Call<ApiResponse<List<Datum>>> call = callAgents.callAgents("en-US", true);
        call.enqueue(new Callback<ApiResponse<List<Datum>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Datum>>> call, Response<ApiResponse<List<Datum>>> response) {
                if (!response.isSuccessful()){
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body().getResponse(), response.message());
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Datum>>> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void GetWeapons(ApiResponseListener<List<Weapons>> listener){
        CallWeapons callWeapons = retrofit.create(CallWeapons.class);
        Call<ApiResponse<List<Weapons>>> call = callWeapons.callWeapons("en-US");
        call.enqueue(new Callback<ApiResponse<List<Weapons>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Weapons>>> call, Response<ApiResponse<List<Weapons>>> response) {
                if (!response.isSuccessful()){
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body().getResponse(), response.message());
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Weapons>>> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void GetMaps(ApiResponseListener<List<MapsResponse>> listener){
        CallMaps callMaps = retrofit.create(CallMaps.class);
        Call<ApiResponse<List<MapsResponse>>> call = callMaps.callWeapons("en-US");
        call.enqueue(new Callback<ApiResponse<List<MapsResponse>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<MapsResponse>>> call, Response<ApiResponse<List<MapsResponse>>> response) {
                if (!response.isSuccessful()){
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body().getResponse(), response.message());
            }

            @Override
            public void onFailure(Call<ApiResponse<List<MapsResponse>>> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void GetEvents(ApiResponseListener<List<EventsResponse>> listener){
        CallEvents callEvents = retrofit.create(CallEvents.class);
        Call<ApiResponse<List<EventsResponse>>> call = callEvents.callWeapons("en-US");
        call.enqueue(new Callback<ApiResponse<List<EventsResponse>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<EventsResponse>>> call, Response<ApiResponse<List<EventsResponse>>> response) {
                if (!response.isSuccessful()){
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body().getResponse(), response.message());
            }

            @Override
            public void onFailure(Call<ApiResponse<List<EventsResponse>>> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void GetBuddies(ApiResponseListener<List<BuddiesResponse>> listener){
        CallBuddies callBuddies = retrofit.create(CallBuddies.class);
        Call<ApiResponse<List<BuddiesResponse>>> call = callBuddies.callWeapons("en-US");
        call.enqueue(new Callback<ApiResponse<List<BuddiesResponse>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<BuddiesResponse>>> call, Response<ApiResponse<List<BuddiesResponse>>> response) {
                if (!response.isSuccessful()){
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body().getResponse(), response.message());
            }

            @Override
            public void onFailure(Call<ApiResponse<List<BuddiesResponse>>> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void GetBundles(ApiResponseListener<List<BundlesResponse>> listener){
        CallBundles callBundles = retrofit.create(CallBundles.class);
        Call<ApiResponse<List<BundlesResponse>>> call = callBundles.callWeapons("en-US");
        call.enqueue(new Callback<ApiResponse<List<BundlesResponse>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<BundlesResponse>>> call, Response<ApiResponse<List<BundlesResponse>>> response) {
                if (!response.isSuccessful()){
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body().getResponse(), response.message());
            }

            @Override
            public void onFailure(Call<ApiResponse<List<BundlesResponse>>> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    private interface CallAgents {
        @GET("agents")
        Call<ApiResponse<List<Datum>>> callAgents(
                @Query("language") String lang,
                @Query("isPlayableCharacter") boolean isPlayable
        );
    }

    private interface CallWeapons {
        @GET("weapons")
        Call<ApiResponse<List<Weapons>>> callWeapons(
                @Query("language") String lang
        );
    }

    private interface CallMaps {
        @GET("maps")
        Call<ApiResponse<List<MapsResponse>>> callWeapons(
                @Query("language") String lang
        );
    }

    private interface CallEvents {
        @GET("events")
        Call<ApiResponse<List<EventsResponse>>> callWeapons(
                @Query("language") String lang
        );
    }

    private interface CallBuddies {
        @GET("buddies")
        Call<ApiResponse<List<BuddiesResponse>>> callWeapons(
                @Query("language") String lang
        );
    }

    private interface CallBundles {
        @GET("bundles")
        Call<ApiResponse<List<BundlesResponse>>> callWeapons(
                @Query("language") String lang
        );
    }


}
