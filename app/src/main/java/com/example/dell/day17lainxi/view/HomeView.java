package com.example.dell.day17lainxi.view;

import com.example.dell.day17lainxi.bean.HomeBean;

/**
 * Created by dell on 2019/6/21.
 */

public interface HomeView {
    void onsuccess(HomeBean bean);

    void onfail(String error);
}
