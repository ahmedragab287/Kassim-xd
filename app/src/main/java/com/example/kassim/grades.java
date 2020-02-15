package com.example.kassim;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shashank.sony.fancytoastlib.FancyToast;

public class grades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        btn_logout();

        btn_first_grade();
        btn_second_grade();
        btn_third_grade();
        btn_private();

        btn_user();
        btn_setting();
        btn_plus();
    }

    private void btn_logout() {
        Button logout;
        logout = findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember","false");
                editor.apply();
                finish();
                FancyToast.makeText(grades.this,"Bye Dr.Kassim "
                        ,FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,false).show();
                startActivity(new Intent(grades.this,MainActivity.class));
            }
        });
    }

    private void btn_first_grade() {
        Button first_grade;
        first_grade = findViewById(R.id.btn_first);
        first_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(grades.this,first_grade.class);
                i.putExtra("activity_num", 1);
                startActivity(i);
            }
        });
    }

    private void btn_second_grade() {
        Button second_grade;
        second_grade = findViewById(R.id.btn_second);
        second_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(grades.this,first_grade.class);
                i.putExtra("activity_num", 2);
                startActivity(i);
            }
        });
    }

    private void btn_third_grade() {
        Button third_grade;
        third_grade = findViewById(R.id.btn_third);
        third_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(grades.this,first_grade.class);
                i.putExtra("activity_num", 3);
                startActivity(i);
            }
        });
    }

    private void btn_private() {
        Button private_grade;
        private_grade = findViewById(R.id.btn_private);
        private_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(grades.this,first_grade.class);
                i.putExtra("activity_num", 4);
                startActivity(i);
            }
        });
    }

    private void btn_user() {
        Button user;
        user = findViewById(R.id.btn_user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(grades.this,working.class));
            }
        });
    }

    private void btn_setting(){
        Button setting;
        setting = findViewById(R.id.btn_setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(grades.this,working.class));
            }
        });
    }

    private void btn_plus() {
        Button plus;
        plus = findViewById(R.id.btn_plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(grades.this,working.class));
            }
        });
    }

}
