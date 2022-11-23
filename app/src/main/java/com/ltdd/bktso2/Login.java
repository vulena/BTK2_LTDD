package com.ltdd.bktso2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    FirebaseAuth mAuth;
    String email,password;
    TextView btlogin,btsignup;
    EditText emaildk,pasdk,emaill,passl;
    Button button;
    LinearLayout loginLayout, signupLayout;
    Boolean ktra=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        emaildk = (EditText) findViewById(R.id.eMails);
        pasdk = (EditText) findViewById(R.id.passwordss);
        emaill = (EditText) findViewById(R.id.eMail);
        passl = (EditText) findViewById(R.id.passwords);
        btlogin = (TextView) findViewById(R.id.login);
        btsignup = (TextView) findViewById(R.id.singUp);
        loginLayout = (LinearLayout) findViewById(R.id.loginLayout);
        signupLayout = (LinearLayout) findViewById(R.id.singUpLayout);
        button = (Button) findViewById(R.id.singIn);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenGD();
            }
        });
        btsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               chuyenGD();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ktra){
                    startActivity(new Intent(Login.this,List.class));
                    System.out.println("login");
                }else
                    xuLyDangKy();
                    System.out.println("sigup");
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void chuyenGD() {
        if(ktra){
            loginLayout.setVisibility(View.GONE);
            signupLayout.setVisibility(View.VISIBLE);
            btsignup.setTextColor(R.color.textColor);
            btsignup.setBackgroundResource(R.drawable.switch_trcks);
            btlogin.setTextColor(R.color.pinkColor);
            btlogin.setBackgroundResource(R.drawable.switch_tumbs);
            button.setText("SignUp");
            ktra=false;
        }else{
            loginLayout.setVisibility(View.VISIBLE);
            signupLayout.setVisibility(View.GONE);
            btlogin.setBackgroundResource(R.drawable.switch_trcks);
            btlogin.setTextColor(R.color.textColor);
            btsignup.setBackgroundResource(R.drawable.switch_tumbs);
            btsignup.setTextColor(R.color.pinkColor);
            button.setText("Log in");
            ktra=true;
        }
    }

    private void xuLyDangKy() {
        email=emaildk.getText().toString().trim();
        password= pasdk.getText().toString().trim();
        System.out.println(email +" "+ password);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this,"Đăng ký thành công",Toast.LENGTH_LONG);
                           chuyenGD();
                        } else {
                            Toast.makeText(Login.this,"Đăng ký thất bại",Toast.LENGTH_LONG);
                        }
                    }
                });
    }

    private void xuLyDangNhap() {

        email=emaill.getText().toString().trim();
        password= passl.getText().toString().trim();
        mAuth = FirebaseAuth.getInstance();
        System.out.println(email +" "+ password);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Login.this,"Đăng nhập thành công",Toast.LENGTH_LONG);
                    startActivity(new Intent(Login.this,List.class));
                } else {
                    Toast.makeText(Login.this,"Đăng nhập thất bại",Toast.LENGTH_LONG);
                }
            }
        });
    }
}