package com.example.com.myapplication.base;

public interface BaseCantrace {

    interface BasePresente<T extends BaseView>{
        void attchView(T view);
        void dachView();
    }
    interface BaseView{
        void showLoding();
        void dimissLoding();
    }
}
