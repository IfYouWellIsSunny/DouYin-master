package com.liqy.douyin.search.presenter;


import com.liqy.douyin.search.FoundBanner;
import com.liqy.douyin.search.FoundList;

public interface IPre {
    void onSuccess(FoundBanner bunner);
    void onFailed(String 数据错误);
    void onUserSuccess(FoundList userBean);
    void onUserFailed(String 数据错误);
}
