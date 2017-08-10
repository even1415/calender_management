package com.sauce.mytablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by even1415 on 2017-08-11.
 */

public class View_contents extends AppCompatActivity {
    Button edit;
    TextView view_title, view_cal, view_alm, view_memo;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contents);

        edit = (Button) findViewById(R.id.edit);
        view_title = (TextView)findViewById(R.id.view_title);
        view_cal = (TextView)findViewById(R.id.view_cal);
        view_alm = (TextView)findViewById(R.id.view_alm);
        view_memo = (TextView)findViewById(R.id.view_memo);

        intent = getIntent();

        view_title.setText(intent.getExtras().getString("title"));
        view_memo.setText("내용 : " + intent.getExtras().getString("memo"));
    }
}
