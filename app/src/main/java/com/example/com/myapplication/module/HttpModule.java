package com.example.com.myapplication.module;

import android.app.Application;

import com.example.com.myapplication.net.DataApi;
import com.example.com.myapplication.net.DataApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder myOkhttp(){
        return new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .connectTimeout(20,TimeUnit.SECONDS);
    }
    @Provides
    DataApi myDataapi(OkHttpClient.Builder builder){
        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.zhaoapi.cn/")
                .client(builder.build())
                .build();
        DataApiService dataApiService=retrofit.create(DataApiService.class);
        return DataApi.getDataApi(dataApiService);
    }
}
