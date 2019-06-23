package com.example.dell.day17lainxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.day17lainxi.adapter.HomeAdapter;
import com.example.dell.day17lainxi.bean.HomeBean;
import com.example.dell.day17lainxi.model.ImpModel;
import com.example.dell.day17lainxi.presenter.ImpPresenter;
import com.example.dell.day17lainxi.view.HomeView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, HomeView, HomeAdapter.MyClick {

    /**
     * 手机号
     */
    private EditText mShouHome;
    /**
     * 确认手机号
     */
    private EditText mShou2Home;
    /**  */
    private TextView mTvHome;
    private RecyclerView mHomeRel;
    /**
     * 取消
     */
    private Button mBtn1;
    /**
     * 确认兑换
     */
    private Button mBtn2;
    private String mString;
    private String mString1;
    private ArrayList<HomeBean.DataBean.ListBean> mList = new ArrayList<>();
    private HomeAdapter mAdapter;
    private View pst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initData();
        initView();
    }

    private void initData() {
        ImpPresenter impPresenter = new ImpPresenter(new ImpModel(), this);
        impPresenter.initData();
    }

    private void initView() {
        mShouHome = (EditText) findViewById(R.id.shou_home);
        mShou2Home = (EditText) findViewById(R.id.shou2_home);
        mTvHome = (TextView) findViewById(R.id.tv_home);
        mHomeRel = (RecyclerView) findViewById(R.id.home_rel);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);

        mString = mShou2Home.getText().toString();
        mString1 = mShouHome.getText().toString();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeActivity.this);
        mHomeRel.setLayoutManager(linearLayoutManager);

        Intent intent = getIntent();
        String qian = intent.getStringExtra("qian");
        mTvHome.setText(qian);

        //解析

        mAdapter = new HomeAdapter(HomeActivity.this, mList);
        mHomeRel.setAdapter(mAdapter);

        mAdapter.setMyClick(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn1:
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                if (mString.equals(mString1)) {

                    Intent intent1 = new Intent(HomeActivity.this, Main2Activity.class);
                    startActivity(intent1);
                } else {
                    Toast.makeText(HomeActivity.this, "手机号不一致", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onsuccess(HomeBean bean) {
        mList.addAll(bean.getData().getList());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onfail(String error) {

        Toast.makeText(HomeActivity.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnClickItem(View view, int i) {
        pst = view;
    }
}
