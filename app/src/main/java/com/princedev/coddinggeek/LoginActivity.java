package com.princedev.coddinggeek;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.princedev.coddinggeek.Model.User;
import com.princedev.coddinggeek.Utils.NodeJsAPI;
import com.princedev.coddinggeek.Utils.Connection;
import com.princedev.coddinggeek.Utils.SaveDataPreference;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext = LoginActivity.this;
    private EditText inputEmail, inputPassword;
    private Button btnLogin, btnRegister;

    private NodeJsAPI api;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        api = Connection.getAPI();
        compositeDisposable = new CompositeDisposable();

        inputEmail = findViewById(R.id.login_email);
        inputPassword = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.login_button);
        btnRegister = findViewById(R.id.register_button);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    private void getDataLogin(String email, String password){
       compositeDisposable.add(api.loginUser(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    if (!s.isEmpty()){
                        SaveDataPreference.setUserID(mContext, s);
                        Log.d("DATA LOGIN", "accept: " + s);
                        startActivity(new Intent(mContext, HomeActivity.class));
                        finish();
                    }else {
                        Toast.makeText(mContext, ""+s, Toast.LENGTH_SHORT).show();
                    }
                }
            }));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_button:
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                if(email.equals("") || password.equals("")){
                    Toast.makeText(mContext, "Email and Password do not empty", Toast.LENGTH_SHORT).show();
                }else {
                    getDataLogin(email, password);
                }
                break;

            case R.id.register_button:
                startActivity(new Intent(mContext, RegisterActivity.class));
                finish();
                break;
        }
    }
}
