package com.princedev.coddinggeek;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.princedev.coddinggeek.Utils.Connection;
import com.princedev.coddinggeek.Utils.NodeJsAPI;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext = RegisterActivity.this;
    private EditText inputEmail, inputPassword;
    private Button btnRegister;

    private NodeJsAPI api;
    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        api = Connection.getAPI();
        compositeDisposable = new CompositeDisposable();

        inputEmail = findViewById(R.id.register_email);
        inputPassword = findViewById(R.id.register_password);
        btnRegister = findViewById(R.id.register_submit_button);

        btnRegister.setOnClickListener(this);
    }

    private void getDataRegister(String email, String password){
        compositeDisposable.add(api.registerUser(email, "-", password, "-", "-", "-","-")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    if (s.equals("Register Success")){
                        startActivity(new Intent(mContext, LoginActivity.class));
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
            case R.id.register_submit_button:
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                getDataRegister(email, password);
                break;
        }

    }

    private static boolean isStringNull(String string){
        return string.equals("");
    }
}
