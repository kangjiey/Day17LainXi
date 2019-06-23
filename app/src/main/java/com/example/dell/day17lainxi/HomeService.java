package com.example.dell.day17lainxi;

import com.example.dell.day17lainxi.bean.HomeBean;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by dell on 2019/6/21.
 */

public interface HomeService {
//    http://106.13.63.54:8080/sys/xin195yk/jiekou.json
    String baseurl = "http://106.13.63.54:8080/";
    @GET("sys/xin195yk/jiekou.json")
    Observable<HomeBean> initData();
}
