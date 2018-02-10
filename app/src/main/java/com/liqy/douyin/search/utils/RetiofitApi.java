package com.liqy.douyin.search.utils;


import com.liqy.douyin.search.FoundBanner;
import com.liqy.douyin.search.FoundList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetiofitApi {
    @GET("aweme/v1/find/")
    Observable<FoundBanner> getlun(@Query("aid") String aid,
                                   @Query("retry_type") String retry_type,
                                   @Query("iid") String iid,
                                   @Query("device_id") String device_id);

     @GET("aweme/v1/category/list/")
     Observable<FoundList> getuser(@Query("cursor") int cursor, @Query("count") int count);

//    @GET("aweme/v1/aweme/post/?user_id=58944993917&max_cursor=0&count=20&retry_type=no_retry&iid=24337275068&device_id=12813228518&ac=wifi&channel=update&aid=1128&app_name=aweme&version_code=172&version_name=1.7.2&device_platform=android&ssmix=a&device_type=R8207&device_brand=OPPO&language=zh&os_api=19&os_version=4.4.4&uuid=867275022006944&openudid=c3c9d2a6d8210600&manifest_version_code=172&resolution=720*1280&dpi=320&update_version_code=1722&_rticket=1517450376334&ts=1517450374&as=a1b567d7e6a8fa24520796&cp=7c89a15f6f2f704ae1fiko&mas=00faef3eab6beb9fcce326cfc5cb8558546c9cec0c4cac2c4c8666")
//    Observable<RecommendedBean> getrecom();
    //@Query("max_cursor") int cursor, @Query("count") int count




}
