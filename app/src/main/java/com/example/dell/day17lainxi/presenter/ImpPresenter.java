package com.example.dell.day17lainxi.presenter;

import com.example.dell.day17lainxi.bean.HomeBean;
import com.example.dell.day17lainxi.collback.HomeCollBack;
import com.example.dell.day17lainxi.model.HomeModel;
import com.example.dell.day17lainxi.model.ImpModel;
import com.example.dell.day17lainxi.view.HomeView;

/**
 * Created by dell on 2019/6/21.
 */

public class ImpPresenter implements HomePresenter, HomeCollBack {
    private ImpModel mImpModel;
    private HomeView mHomeView;

    public ImpPresenter(ImpModel impModel, HomeView homeView) {
        mImpModel = impModel;
        mHomeView = homeView;
    }

    @Override
    public void initData() {
        if (mImpModel != null) {
            mImpModel.initData(this);
        }

    }

    @Override
    public void onsuccess(HomeBean bean) {
        if (mHomeView != null) {
            mHomeView.onsuccess(bean);
        }
    }

    @Override
    public void onfail(String error) {

        if (mHomeView != null) {
            mHomeView.onfail(error);
        }
    }
}
