package com.example.faizankhan.logindemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText editUser,editPass;
    TextView textRegister;
    String userName,PassWord;

    int counter = 3;
    public void loginInfoChecked(View v )
    {

        userName = editUser.getText().toString();
        PassWord = editPass.getText().toString();


        if(userName.equals("admin") && PassWord.equals("admin"))
        {
            Intent myIntent = new Intent(this, Second.class);
            startActivity(myIntent);

        }
        else
        {
            Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            counter = counter-1;
            Toast.makeText(this, "Attemp Left : "+counter, Toast.LENGTH_SHORT).show();
            if(counter < 1) {
                btn.setEnabled(false);
                Toast.makeText(this, "Your account has been locked", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void method(View v)
    {
        Intent register = new Intent(MainActivity.this, Register.class);
        startActivity(register);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        editUser = findViewById(R.id.editUser);
        editPass = findViewById(R.id.editPassword);

        textRegister = findViewById(R.id.textRegister);

       /* textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, Register.class);
                startActivity(register);


            }
        });
        */




    }

    public void loginDetailsChecked(View v )
    {
        userName = editUser.getText().toString();
        PassWord = editPass.getText().toString();

        String enterUsername =

    }
}
