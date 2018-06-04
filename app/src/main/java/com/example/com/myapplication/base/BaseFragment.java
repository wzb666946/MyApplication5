package com.example.com.myapplication.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.myapplication.intert.IBase;

import javax.inject.Inject;

public abstract class BaseFragment<T extends BaseCantrace.BasePresente> extends Fragment implements IBase,BaseCantrace.BaseView{
    @Inject
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定
        mPresenter.attchView(this);
        inject();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解绑
        mPresenter.dachView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(getCounLoayout(),null);
        initView(view);
        return view;
    }

    @Override
    public void showLoding() {

    }

    @Override
    public void dimissLoding() {

    }

}
