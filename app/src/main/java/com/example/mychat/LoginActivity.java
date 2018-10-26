package com.example.mychat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText userName;
    private EditText passWd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText)findViewById(R.id.userName);
        passWd = (EditText)findViewById(R.id.passWd);
        Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String pwd = passWd.getText().toString();
                if("admin".equals(name) && "123456".equals(pwd)){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

