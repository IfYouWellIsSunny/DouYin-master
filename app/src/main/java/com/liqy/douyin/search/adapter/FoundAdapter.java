package com.liqy.douyin.search.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.liqy.douyin.R;
import com.liqy.douyin.search.FoundBanner;
import com.liqy.douyin.search.FoundList;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/1/29.
 */

public class FoundAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    private Context context;
    private List<FoundBanner.BannerBean> ban;
    private List<FoundList.CategoryListBean> list;
    private ArrayList<String> listimg;
    private boolean flag;

    public FoundAdapter(Context context, List<FoundBanner.BannerBean> ban, List<FoundList.CategoryListBean> list) {
        this.context = context;
        this.ban = ban;
        this.list = list;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }


    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.search_banner, null);
            ViewHolder0 viewHolder0 = new ViewHolder0(view);
            return viewHolder0;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.search_list, null);
            ViewHolder1 viewHolder1 = new ViewHolder1(view);
            return viewHolder1;
        }
    }
    

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder0) {
            ViewHolder0 v0 = (ViewHolder0) holder;

            listimg = new ArrayList<>();
            ArrayList<String> listtitle = new ArrayList<>();
            listimg.clear();
            listtitle.clear();
            for (int i = 0; i < ban.size(); i++) {
                String s = ban.get(i).getBanner_url().getUrl_list().get(0);
                String title = ban.get(i).getTitle();
                listimg.add(s);
                listtitle.add(title);
            }
            if (!flag) {
                v0.banner.setData(listimg, null);
                v0.banner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(context).load(listimg.get(position)).into((ImageView) view);
                    }

                });
                flag = true;
            } else {

            }

            v0.banner.setPageTransformer(com.stx.xhb.xbanner.transformers.Transformer.Default);
            v0.banner.setPageChangeDuration(1000);
        } else {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            viewHolder1.user_rc.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false));
            MyVideoAdapter myVideoAdapter = new MyVideoAdapter(context, list);
            viewHolder1.user_rc.setAdapter(myVideoAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    static class ViewHolder0 extends XRecyclerView.ViewHolder{
        @BindView(R.id.banner)
        XBanner banner;

        ViewHolder0(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolder1 extends XRecyclerView.ViewHolder{
        @BindView(R.id.user_rc)
        RecyclerView user_rc;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
