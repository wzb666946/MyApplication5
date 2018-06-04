package com.example.com.myapplication.persenter;

import com.example.com.myapplication.base.BasePresenter;
import com.example.com.myapplication.bean.Databean;
import com.example.com.myapplication.canetrac.DataCartract;
import com.example.com.myapplication.net.DataApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DataPresenter extends BasePresenter<DataCartract.View> implements DataCartract.Presenter {
    private DataApi dataApi;
    @Inject
    public DataPresenter(DataApi dataApi) {
        this.dataApi = dataApi;
    }

    @Override
    public void getData(String source, String appVersion, String page) {
        dataApi.getData(source,appVersion,page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Databean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Databean databean) {
                        mView.getDataSuccesss(databean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
