package com.example.faizankhan.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText editUserNameReg,editPaasWordReg,editNameReg,editMobileNumberReg;
    Button buttonReg;

    DBHelper mydb;


    public void getDataFromForm(View v)
    {
        String userName = editUserNameReg.getText().toString();
        String PassWord = editPaasWordReg.getText().toString();
        String Name = editNameReg.getText().toString();
        String NumberMob = editMobileNumberReg.getText().toString();

        mydb.insertDetails(userName, Name, PassWord ,  NumberMob);
        Toast.makeText(this, "Register Successfully ", Toast.LENGTH_SHORT).show();
        Intent backToMain = new Intent(this, MainActivity.class);
        startActivity(backToMain);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editUserNameReg = findViewById(R.id.editUserNameReg);
        editPaasWordReg = findViewById(R.id.editPaasWordReg);
        editNameReg = findViewById(R.id.editNameReg);
        editMobileNumberReg = findViewById(R.id.editMobileNumberReg);
        buttonReg = findViewById(R.id.buttonReg);

        mydb = new DBHelper(this);


    }
}
