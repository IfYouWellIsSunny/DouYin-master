package com.liqy.douyin.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.liqy.douyin.R;
import com.liqy.douyin.search.adapter.FoundAdapter;
import com.liqy.douyin.search.presenter.SearchPresenter;
import com.liqy.douyin.search.view.SearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity implements SearchView {


    @BindView(R.id.search_xre)
    XRecyclerView xrc;
    private SearchPresenter presenter;
    private int cursor = 0;
    private int count = 5;
    private List<FoundBanner.BannerBean> ban = new ArrayList<>();
    private List<FoundList.CategoryListBean> list = new ArrayList<>();
    private FoundAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
//        getSupportActionBar().hide();//代码中  隐藏掉标题栏
        presenter = new SearchPresenter(this);
        presenter.getLunbo();
        presenter.getUser(cursor,count);
        //设置可上拉
        xrc.setPullRefreshEnabled(true);
        xrc.setLoadingMoreEnabled(true);
        //设置上拉下拉样式
        xrc.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrc.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);

        xrc.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                cursor++;
                count = count + 5;
                presenter.getUser(cursor, count);
                myAdapter.notifyDataSetChanged();
                xrc.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                // cursor++;
                count = count + 5;
                presenter.getUser(cursor, count);
                myAdapter.notifyDataSetChanged();
                xrc.loadMoreComplete();
            }
        });

    }

    @Override
    public void onSuccess(FoundBanner bunner) {
        List<FoundBanner.BannerBean> bannerBeans=bunner.getBanner();
        ban.addAll(bannerBeans);
    }

    @Override
    public void onFailed(String 数据错误) {

    }

    @Override
    public void onUserSuccess(FoundList userBean) {
        List<FoundList.CategoryListBean> category_list = userBean.getCategory_list();
        list.addAll(category_list);
        xrc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myAdapter = new FoundAdapter(SearchActivity.this, ban, list);
        xrc.setAdapter(myAdapter);
    }

    @Override
    public void onUserFailed(String 数据错误) {

    }
}
