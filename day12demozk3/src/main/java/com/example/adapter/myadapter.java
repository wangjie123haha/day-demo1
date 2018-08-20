package com.example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.news;
import com.example.day12demozk3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lenovo on 2018/8/19.
 */

public class myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<com.example.bean.news.DataBean> list;
    private  onItemClickListen  onItemClickListen;
    public myadapter(Context context, List<news.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    //创建接口
    public  interface  onItemClickListen{
        void  onItemClick(int layoutPosition);
    }
    //提供接口
    public  void  setOnItemClickListen( onItemClickListen  onItemClickListen){
        this.onItemClickListen =onItemClickListen;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder;
        view = LayoutInflater.from(context).inflate(R.layout.include1, null);
        holder = new oneholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      if(holder instanceof  oneholder){
          ((oneholder) holder).title1.setText(list.get(position).getTitle());
          String[] images = list.get(position).getImages().split("\\|");
          Picasso.get().load(images[0]).into(((oneholder) holder).img02);
      }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class  oneholder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView title1;
        private final ImageView img02;

        public oneholder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title1 = itemView.findViewById(R.id.title1);
            img02 = itemView.findViewById(R.id.img02);

        }

        @Override
        public void onClick(View view) {
            int layoutPosition = getLayoutPosition();
            onItemClickListen.onItemClick(layoutPosition);
        }
    }
}
