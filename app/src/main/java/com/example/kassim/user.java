package com.example.kassim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class user extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        count_all();

        btn_back();

        btn_first_grade();          btn_second_grade();
        btn_third_grade();          btn_private_grade();

    }

    private void count_all() {
        DatabaseHelper db = new DatabaseHelper(user.this);

        TextView gradeOne_count = findViewById(R.id.gradeOne_count);
        TextView gradeTwo_count = findViewById(R.id.gradetwo_count);
        TextView gradeThere_count = findViewById(R.id.gradethere_count);
        TextView gradePrivate_count = findViewById(R.id.gradeprivate_count);


        int count_gradeone = db.count(1);
        int count_gradetwo = db.count(2);
        int count_gradethere = db.count(3);
        int count_gradeprivat = db.count(4);


        gradeOne_count.setText(String.valueOf(count_gradeone));
        gradeTwo_count.setText(String.valueOf(count_gradetwo));
        gradeThere_count.setText(String.valueOf(count_gradethere));
        gradePrivate_count.setText(String.valueOf(count_gradeprivat));

        /////////////////////////////////////
        TextView gradeOne_rate = findViewById(R.id.gradeOne_rate);
        TextView gradeTwo_rate = findViewById(R.id.gradetwo_rate);
        TextView gradeThere_rate = findViewById(R.id.gradethere_rate);
        TextView gradePrivate_rate = findViewById(R.id.gradeprivate_rate);

        int gradeOne_rate_int = 60;
        int gradeTwo_rate_int = 80;
        int gradeThere_rate_int = 100;
        int gradePrivate_rate_int = 200;

        gradeOne_rate.setText(String.valueOf(gradeOne_rate_int));
        gradeTwo_rate.setText(String.valueOf(gradeTwo_rate_int));
        gradeThere_rate.setText(String.valueOf(gradeThere_rate_int));
        gradePrivate_rate.setText(String.valueOf(gradePrivate_rate_int));


        /////////////////////////////////////
        TextView gradeOne_total = findViewById(R.id.gradeOne_total);
        TextView gradeTwo_total = findViewById(R.id.gradetwo_total);
        TextView gradeThere_total = findViewById(R.id.gradethere_total);
        TextView gradePrivate_total = findViewById(R.id.gradeprivate_total);


        gradeOne_total.setText(String.valueOf(gradeOne_rate_int * count_gradeone));
        gradeTwo_total.setText(String.valueOf(gradeTwo_rate_int * count_gradetwo));
        gradeThere_total.setText(String.valueOf(gradeThere_rate_int * count_gradethere));
        gradePrivate_total.setText(String.valueOf(gradePrivate_rate_int * count_gradeprivat));

        /////////////////////////////////////
        TextView total_salary = findViewById(R.id.total_salary);
        total_salary.setText(String.valueOf((gradeOne_rate_int * count_gradeone) +
                                    (gradeTwo_rate_int * count_gradetwo)+
                                    (gradeThere_rate_int * count_gradethere)+
                                    (gradePrivate_rate_int * count_gradeprivat)));


    }

    private void btn_first_grade() {
        Button first_grade;
        first_grade = findViewById(R.id.circul_one);
        first_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(user.this,first_grade.class);
                i.putExtra("activity_num", 1);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }

    private void btn_second_grade() {
        Button second_grade;
        second_grade = findViewById(R.id.circul_two);
        second_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(user.this,first_grade.class);
                i.putExtra("activity_num", 2);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }

    private void btn_third_grade() {
        Button third_grade;
        third_grade = findViewById(R.id.circul_there);
        third_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(user.this,first_grade.class);
                i.putExtra("activity_num", 3);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }

    private void btn_private_grade() {
        Button private_grade;
        private_grade = findViewById(R.id.circul_private);
        private_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(user.this,first_grade.class);
                i.putExtra("activity_num", 4);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(user.this, grades.class));
        //overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }

    private void btn_back() {
        Button back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user.this,grades.class));
                finish();

            }
        });
    }

}
