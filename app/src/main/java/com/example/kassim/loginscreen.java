package com.example.kassim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

public class loginscreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);

        btn_back();
        btn_login();
        cb_oncheck();
    }

    private void cb_oncheck() {
        CheckBox checkBox = findViewById(R.id.cb_remeber);

        SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");

        if (checkbox.equals("true")){
            startActivity(new Intent(loginscreen.this, grades.class));
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (compoundButton.isChecked()){

                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                }else if (!compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                }
            }
        });
    }

    public void btn_back(){
        Button back;
        back =  findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginscreen.this,MainActivity.class));
            }
        });
    }

    public void btn_login(){
        Button login = findViewById(R.id.btn_login);
        final EditText username = findViewById(R.id.etxt_username);
        final EditText password = findViewById(R.id.etxt_password);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                if (username.getText().toString().equals("")&&
                        password.getText().toString().equals(""))
                {
                    FancyToast.makeText(loginscreen.this,"Welcome Dr.Kassim "
                            ,FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,false).show();

                        startActivity(new Intent(loginscreen.this, grades.class));
                        loginscreen.this.finish();

                } else {
                    FancyToast.makeText(loginscreen.this,"Wrong Username or Password"
                            ,FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();
                }

            }
        });
    }

}