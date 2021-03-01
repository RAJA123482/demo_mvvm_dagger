package com.demo_mvvm_dagger.login;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.demo_mvvm_dagger.BaseApplication;
import com.demo_mvvm_dagger.R;
import com.demo_mvvm_dagger.movies.PopularMoviesActivity;

import java.util.regex.Pattern;

public class MainActivity extends Activity {
    EditText edEmail, edPassword;
    Button btnLogin;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        edEmail = findViewById(R.id.ed_email);
        edPassword = findViewById(R.id.ed_password);
        btnLogin = findViewById(R.id.btn_login);

        edEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length() > 0 && edPassword.getText().toString().trim().length() > 0) {
                    btnLogin.setEnabled(true);
                } else {
                    btnLogin.setEnabled(false);
                }

            }
        });

        edPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length() > 0 && edEmail.getText().toString().trim().length() > 0) {
                    btnLogin.setEnabled(true);
                } else {
                    btnLogin.setEnabled(false);
                }

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edEmail.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
                    edEmail.setError("Please enter valid email-Id!");
                    return;
                }

                if(edPassword.getText().toString().trim().length() < 6 || edPassword.getText().toString().trim().length() > 12) {
                    edPassword.setError("Please enter password between 6-12 characters!");
                    return;
                }

                Intent intent = new Intent(context, PopularMoviesActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}