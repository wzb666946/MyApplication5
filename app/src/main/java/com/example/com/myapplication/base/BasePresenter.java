package com.example.com.myapplication.base;

public class BasePresenter<T extends BaseCantrace.BaseView> implements BaseCantrace.BasePresente<T> {
    protected T mView;
    @Override
    public void attchView(T view) {
        this.mView=view;
    }

    @Override
    public void dachView() {
        if(mView!=null){
            mView=null;
        }
    }
}
