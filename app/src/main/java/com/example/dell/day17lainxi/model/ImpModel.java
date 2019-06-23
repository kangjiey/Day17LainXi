package com.example.dell.day17lainxi.model;

import android.util.Log;

import com.example.dell.day17lainxi.HomeService;
import com.example.dell.day17lainxi.bean.HomeBean;
import com.example.dell.day17lainxi.collback.HomeCollBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2019/6/21.
 */

public class ImpModel implements HomeModel {
    @Override
    public void initData(final HomeCollBack homeCollBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HomeService.baseurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HomeService homeService = retrofit.create(HomeService.class);

        Observable<HomeBean> observable = homeService.initData();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean bean) {
                        if (bean != null) {
                            if (bean.getCode() == 0) {
                                homeCollBack.onsuccess(bean);
                            } else {
                                homeCollBack.onfail("状态吗不为200");
                            }
                        } else {
                            homeCollBack.onfail("数据为空");
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        homeCollBack.onfail("onError:" + e.getMessage());

                        Log.e("tag", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
