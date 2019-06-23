package com.example.dell.day17lainxi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.day17lainxi.R;
import com.example.dell.day17lainxi.bean.HomeBean;

import java.util.ArrayList;

/**
 * Created by dell on 2019/6/21.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{
    private Context context;
    private ArrayList<HomeBean.DataBean.ListBean> list;

    public HomeAdapter(Context context, ArrayList<HomeBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(context).load(list.get(position).getPic()).into(holder.iv);
        holder.tv1.setText(list.get(position).getName());
        holder.tv2.setText("库存："+list.get(position).getStockCount()+"个");
        holder.tv3.setText("销售："+list.get(position).getSellCount()+"个");
        holder.tv4.setText(list.get(position).getPrice() + "元");

        holder.rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MyClick!=null){
                    MyClick.OnClickItem(view,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private RadioButton rb;
        private ImageView iv;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        private TextView tv4;

        public ViewHolder(View itemView) {
            super(itemView);
            rb = itemView.findViewById(R.id.rb);
            iv = itemView.findViewById(R.id.iv);
            tv1 =itemView.findViewById(R.id.tv_a);
            tv2 =itemView.findViewById(R.id.tv_b);
            tv3 =itemView.findViewById(R.id.tv_c);
            tv4 =itemView.findViewById(R.id.tv_d);
        }
    }
    public interface MyClick {
        void OnClickItem(View view, int i);
    }

    private MyClick MyClick;

    public void setMyClick(HomeAdapter.MyClick myClick) {
        MyClick = myClick;
    }
}
