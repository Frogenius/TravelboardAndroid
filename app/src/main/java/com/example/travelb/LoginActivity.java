package com.example.travelb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText mail, pass, repass, name1;
    Button signup, login;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  Window w = getWindow();
      //  w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_window);


        mail = (EditText) findViewById(R.id.emailField);
        pass = (EditText) findViewById(R.id.passField);
        repass = (EditText) findViewById(R.id.repass1);
        name1 = (EditText) findViewById(R.id.nameField);
        signup = (Button) findViewById(R.id.btnSign1);
        login = (Button) findViewById(R.id.btnLog1);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = mail.getText().toString();
                String password = pass.getText().toString();
                String repassword = repass.getText().toString();
                String nameU = name1.getText().toString();

                if(user.equals("") || password.equals("")|| repassword.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(password.equals(repassword)){
                        Boolean checkuser = DB.checkemail(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, password, nameU);
                            if(insert==true) {
                                Toast.makeText(LoginActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(LoginActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Password not matching ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }
}

