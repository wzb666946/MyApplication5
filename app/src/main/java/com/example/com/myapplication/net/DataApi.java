package com.example.com.myapplication.net;

import com.example.com.myapplication.bean.Databean;

import io.reactivex.Observable;

public class DataApi {
    private static DataApi dataApi;
    private DataApiService dataApiService;

    public DataApi(DataApiService dataApiService) {
        this.dataApiService = dataApiService;
    }

    public static DataApi getDataApi(DataApiService dataApiService) {
        if(dataApi==null){
            dataApi=new DataApi(dataApiService);
        }
        return dataApi;
    }
    public Observable<Databean> getData(String source, String appVersion, String page){
        return dataApiService.getData(source,appVersion,page);
    }
}
