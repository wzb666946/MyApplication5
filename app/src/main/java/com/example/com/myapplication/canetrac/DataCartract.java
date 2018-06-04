package com.example.com.myapplication.canetrac;

import com.example.com.myapplication.base.BaseCantrace;
import com.example.com.myapplication.bean.Databean;

public interface DataCartract {
    interface View extends BaseCantrace.BaseView{
        void getDataSuccesss(Databean databean);
    }
    interface  Presenter extends BaseCantrace.BasePresente<View>{
        void getData(String source,String appVersion,String page);
    }
}
