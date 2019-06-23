package com.example.dell.day17lainxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 200
     */
    private EditText mEtMain;
    /**
     * 进入兑换页面
     */
    private Button mBtnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mEtMain = (EditText) findViewById(R.id.et_main);
        mBtnMain = (Button) findViewById(R.id.btn_main);
        mBtnMain.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_main:
                Editable text = mEtMain.getText();
                String string = text.toString();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);

               intent.putExtra("qian",string);
                startActivity(intent);
                break;
        }
    }

}
