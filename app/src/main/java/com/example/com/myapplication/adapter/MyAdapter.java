package com.example.com.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.com.myapplication.R;
import com.example.com.myapplication.bean.Databean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final LayoutInflater inflater;
    private Context context;
    private List<Databean.DataBean> list;

    public MyAdapter(Context context, List<Databean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.lsit,parent,false);
        ClassViewHolder myViewHolder=new ClassViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //赋值
      ClassViewHolder myViewHolder= (ClassViewHolder) holder;
           String s= (String) list.get(position).getUser().getIcon();
           myViewHolder.img.setImageURI(s);
           myViewHolder.name.setText(list.get(position).getContent());
           myViewHolder.cter.setText(list.get(position).getCreateTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ClassViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView img;
        private final TextView name;
        private final TextView cter;

        public ClassViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.swimg);
            name=itemView.findViewById(R.id.wz);
            cter=itemView.findViewById(R.id.ceter);
        }
    }
    //刷新
    public  void refresh(List<Databean.DataBean> temlist){
        this.list.clear();
        this.list.addAll(temlist);
    }
    //加载更多
    public  void loadMore(List<Databean.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}
