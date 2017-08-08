package com.sauce.mytablayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by even1415 on 2017-08-08.
 */

public class Password extends Activity {
    EditText input_ps;
    Button insert_ps;
    String PW = "admin0000";
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.password);

        input_ps = (EditText)findViewById(R.id.input_ps);
        insert_ps = (Button)findViewById(R.id.insert_ps);
        intent = getIntent();

        insert_ps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = getIntent();
                if(PW.equals(input_ps.getText().toString())) {
                    intent.putExtra("password", true);
                    Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    intent.putExtra("password", false);
                    Toast.makeText(getApplicationContext(), "login fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*
        //비밀번호 유효성 검사 코드(예시)
        if(!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", PW)) {
            Toast.makeText(SignupActivity.this,"비밀번호 형식을 지켜주세요.",Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        }
         */
    }
}
