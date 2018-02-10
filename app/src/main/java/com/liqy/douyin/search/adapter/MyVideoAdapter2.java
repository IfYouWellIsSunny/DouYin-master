package com.liqy.douyin.search.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.liqy.douyin.R;
import com.liqy.douyin.search.FoundList;
import com.liqy.douyin.search.VideoPlayActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/1/29.
 */

public class MyVideoAdapter2 extends RecyclerView.Adapter<MyVideoAdapter2.ViewHolder> {
    private Context context;
    private List<FoundList.CategoryListBean.AwemeListBean> list;

    public MyVideoAdapter2(Context context, List<FoundList.CategoryListBean.AwemeListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyVideoAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(context);
        View view = LayoutInflater.from(context).inflate(R.layout.search_layout_video2, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyVideoAdapter2.ViewHolder holder, final int position) {
        String s = list.get(position).getVideo().getCover().getUrl_list().get(0);

        Uri parse = Uri.parse(s);
        // holder.sim.setImageURI(parse);
        //也可以控制图片请求的一些特性
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(parse)
                //设置支持jpeg渐进式展示（从模糊到清晰）
                .setProgressiveRenderingEnabled(true)
                .build();
        AbstractDraweeController builder = Fresco.newDraweeControllerBuilder()
                //图片的地址
                .setImageRequest(imageRequest)
                .setUri(parse)
                //设置图片自动播放属性
                .setAutoPlayAnimations(true)
                .build();
        holder.sim.setController(builder);

        holder.sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, VideoPlayActivity.class);
                intent.putExtra("url",list.get(position).getVideo().getDownload_addr().getUrl_list().get(0));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.sim)
        SimpleDraweeView sim;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
