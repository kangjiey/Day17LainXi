package com.example.dell.day17lainxi.api;

import com.example.dell.day17lainxi.DbApp;
import com.example.dell.day17lainxi.bean.DaoBean;
import com.example.dell.day17lainxi.dao.DaoBeanDao;
import com.example.dell.day17lainxi.dao.DaoMaster;
import com.example.dell.day17lainxi.dao.DaoSession;

import java.util.List;

/**
 * Created by dell on 2019/6/20.
 */

public class DbHelper {
    private static DbHelper dbHelper;
    private final DaoBeanDao mDaoBeanDao;

    public DbHelper getDbHelper() {
        if (dbHelper == null) {
            synchronized (DbHelper.class) {
                if (dbHelper == null) {
                    dbHelper = new DbHelper();
                }
            }
        }
        return dbHelper;
    }

    private DbHelper() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(DbApp.getApp(), "my.db");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());

        DaoSession daoSession = daoMaster.newSession();

        mDaoBeanDao = daoSession.getDaoBeanDao();
    }

    public void insert(DaoBean bean) {
        if (!ishas(bean)) {
            mDaoBeanDao.insert(bean);
        }

    }

    public void delete(DaoBean bean) {
        if (ishas(bean)) {
            mDaoBeanDao.delete(bean);
        }

    }

    public void update(DaoBean bean) {
        if (ishas(bean)) {
            mDaoBeanDao.update(bean);
        }

    }

    public List<DaoBean> queryAll() {
        return mDaoBeanDao.queryBuilder().list();
    }


    private boolean ishas(DaoBean bean) {
        List<DaoBean> list = mDaoBeanDao.queryBuilder().where(DaoBeanDao.Properties.Desc.eq(bean.getDesc())).list();
        if (list.size() > 0 && list != null) {
            return true;
        }
        return false;
    }
}
