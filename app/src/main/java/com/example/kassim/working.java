package com.example.kassim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class working extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(working.this,grades.class));
        finish();

    }
}
