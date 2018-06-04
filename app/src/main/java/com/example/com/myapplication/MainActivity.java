package com.example.com.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.com.myapplication.adapter.MyAdapter;
import com.example.com.myapplication.base.BaseActivity;
import com.example.com.myapplication.bean.Databean;
import com.example.com.myapplication.canetrac.DataCartract;
import com.example.com.myapplication.comptonnet.DaggerHttpCompconnet;
import com.example.com.myapplication.module.HttpModule;
import com.example.com.myapplication.persenter.DataPresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<DataPresenter> implements DataCartract.View {

    /**
     * 推荐
     */
    private TextView mMainTitle;
    private ViewPager mVp;
    /**
     * 推荐
     */
    private RadioButton mTj;
    /**
     * 段子
     */
    private RadioButton mDz;
    /**
     * 发现
     */
    private RadioButton mFx;
    /**
     * 视频
     */
    private RadioButton mSp;
    private String t="android";
    private XRecyclerView rl;
    private int num=1;
    private boolean isRefresh=true;
    private MyAdapter myAdapter;
    private List<Databean.DataBean> list;
    private List<Databean.DataBean>  allList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl=findViewById(R.id.rl);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false);
        rl.setLayoutManager(gridLayoutManager1);
        mPresenter.getData(t,""+100,""+num);
        init();
    }

    private void init() {
        rl.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                isRefresh=true;
                num=1;
                mPresenter.getData(t,""+100,""+num);
            }

            @Override
            public void onLoadMore() {
                isRefresh=false;
                num++;
                mPresenter.getData(t,""+100,""+num);
            }
        });
    }


    @Override
    public void getDataSuccesss(Databean databean) {
        Log.d("dakj",""+ databean.toString());
         list = databean.getData();
         allList.addAll(list);
        setadapter();
    }

    private void setadapter() {
        if(isRefresh){
            myAdapter=new MyAdapter(this,list);
            rl.setAdapter(myAdapter);
            myAdapter.refresh(allList);
            rl.refreshComplete();//设置刷新完成
        }else{
            if(myAdapter!=null){
                myAdapter.loadMore(allList);
                rl.loadMoreComplete();//设置加载更多完成
            }
        }
        if (myAdapter==null){
            return;
        }

    }
    @Override
    public int getCounLoayout() {
        return 0;
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
}
