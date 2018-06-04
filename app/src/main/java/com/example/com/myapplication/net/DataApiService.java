package com.example.com.myapplication.net;

import com.example.com.myapplication.bean.Databean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DataApiService {
    @FormUrlEncoded
    @POST("quarter/getJokes")
    Observable<Databean> getData(@Field("source") String source, @Field("appVersion") String appVersion, @Field("page") String page);
}
