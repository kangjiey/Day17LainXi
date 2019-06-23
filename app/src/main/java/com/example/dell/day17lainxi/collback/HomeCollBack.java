package com.example.dell.day17lainxi.collback;

import com.example.dell.day17lainxi.bean.HomeBean;

/**
 * Created by dell on 2019/6/21.
 */

public interface HomeCollBack {
    void onsuccess(HomeBean bean);

    void onfail(String error);
}
