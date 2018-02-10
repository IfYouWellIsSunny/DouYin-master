package com.liqy.douyin.search.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.liqy.douyin.R;
import com.liqy.douyin.search.FoundList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/1/29.
 */

public class MyVideoAdapter extends RecyclerView.Adapter<MyVideoAdapter.ViewHolder1> {
    private Context context;
    private List<FoundList.CategoryListBean> list;

    public MyVideoAdapter(Context context, List<FoundList.CategoryListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyVideoAdapter.ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_layout_video, null);
        ViewHolder1 viewHolder = new ViewHolder1(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyVideoAdapter.ViewHolder1 holder, int position) {

        holder.userText.setText(list.get(position).getDesc());
        List<FoundList.CategoryListBean.AwemeListBean> aweme_list = list.get(position).getAweme_list();
        for (int i = 0; i < aweme_list.size(); i++) {
            String desc = aweme_list.get(i).getDesc();
            holder.userContent.setText(desc);
        }
        List<FoundList.CategoryListBean.AwemeListBean> aweme_list1 = list.get(position).getAweme_list();
        MyVideoAdapter2 myVideoAdapter2 = new MyVideoAdapter2(context, aweme_list1);
        holder.rcVideo.setAdapter(myVideoAdapter2);
        holder.rcVideo.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.user_text)
        TextView userText;
        @BindView(R.id.user_content)
        TextView userContent;
        @BindView(R.id.rc_video)
        RecyclerView rcVideo;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
