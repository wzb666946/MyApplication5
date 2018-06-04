package com.example.com.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.com.myapplication.intert.IBase;

import javax.inject.Inject;

public abstract class BaseActivity<T extends BaseCantrace.BasePresente> extends AppCompatActivity implements IBase,BaseCantrace.BaseView{
    @Inject
    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        //绑定
        mPresenter.attchView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑
        mPresenter.dachView();
    }

    @Override
    public void showLoding() {

    }

    @Override
    public void dimissLoding() {

    }
}
