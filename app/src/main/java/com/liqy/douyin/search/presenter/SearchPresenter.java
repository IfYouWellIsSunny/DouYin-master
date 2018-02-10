package com.liqy.douyin.search.presenter;

import com.liqy.douyin.search.FoundBanner;
import com.liqy.douyin.search.FoundList;
import com.liqy.douyin.search.model.SearchModel;
import com.liqy.douyin.search.view.SearchView;

/**
 * Created by lenovo on 2018/2/10.
 */

public class SearchPresenter implements IPre {
    private SearchView iView;
    private SearchModel model;

    public SearchPresenter(SearchView iView) {
        this.iView = iView;
        model = new SearchModel();
    }

    public void getLunbo() {
        model.getLunbo(this);
    }

    public void getUser(int cursor, int count) {
        model.getUser(cursor, count, this);
    }



    @Override
    public void onSuccess(FoundBanner bunner) {
        iView.onSuccess(bunner);
    }

    @Override
    public void onFailed(String 数据错误) {
        iView.onFailed(数据错误);
    }

    @Override
    public void onUserSuccess(FoundList userBean) {
        iView.onUserSuccess(userBean);
    }

    @Override
    public void onUserFailed(String 数据错误) {
        iView.onUserFailed(数据错误);
    }
}
