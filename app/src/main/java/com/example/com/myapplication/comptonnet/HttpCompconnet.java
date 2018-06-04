package com.example.com.myapplication.comptonnet;

import com.example.com.myapplication.MainActivity;
import com.example.com.myapplication.fragment.Fragment_one;
import com.example.com.myapplication.module.HttpModule;

import dagger.Component;
@Component(modules = HttpModule.class)
public interface HttpCompconnet {
    void inject(MainActivity mainActivity);
    void inject(Fragment_one fragment_one);
}
