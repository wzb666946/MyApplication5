package com.example.com.myapplication.fragment;

import android.view.View;

import com.example.com.myapplication.R;
import com.example.com.myapplication.base.BaseFragment;
import com.example.com.myapplication.bean.Databean;
import com.example.com.myapplication.canetrac.DataCartract;
import com.example.com.myapplication.comptonnet.DaggerHttpCompconnet;
import com.example.com.myapplication.module.HttpModule;
import com.example.com.myapplication.persenter.DataPresenter;

public class Fragment_one extends BaseFragment<DataPresenter> implements DataCartract.View{

    @Override
    public int getCounLoayout() {
        return R.layout.fragment_d;
    }

    @Override
    public void inject() {
        DaggerHttpCompconnet.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void getDataSuccesss(Databean databean) {

    }
}
