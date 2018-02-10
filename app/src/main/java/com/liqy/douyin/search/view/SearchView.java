package com.liqy.douyin.search.view;

import com.liqy.douyin.search.FoundBanner;
import com.liqy.douyin.search.FoundList;

/**
 * Created by lenovo on 2018/2/10.
 */

public interface SearchView {

    void onSuccess(FoundBanner bunner);
    void onFailed(String 数据错误);
    void onUserSuccess(FoundList userBean);
    void onUserFailed(String 数据错误);

}
