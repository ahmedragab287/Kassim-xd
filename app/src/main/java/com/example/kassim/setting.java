package com.example.kassim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shashank.sony.fancytoastlib.FancyToast;

public class setting extends AppCompatActivity {

    SharedPreferences preferences;
    EditText price_one , price_two , price_there;
    int from_where;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        preferences = getSharedPreferences("price",MODE_PRIVATE);
        from_where = getIntent().getIntExtra("from_where", 0);
        price_one =findViewById(R.id.price_one);
        price_one.requestFocus();

        set_price();
        btn_back();
        btn_save_price();
        btn_save_user();

        btn_delete_grade_one();
        btn_delete_grade_two();
        btn_delete_grade_there();
        btn_delete_grade_private();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        back();
    }

    private void btn_delete_grade_one() {
        Button btn_delete_grade_one = findViewById(R.id.delete_grade_one);
        btn_delete_grade_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog(1);
            }
        });
    }

    private void btn_delete_grade_two() {
        Button btn_delete_grade_two = findViewById(R.id.delete_grade_two);
        btn_delete_grade_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog(2);
            }
        });
    }

    private void btn_delete_grade_there() {
        Button btn_delete_grade_there = findViewById(R.id.delete_grade_there);
        btn_delete_grade_there.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog(3);
            }
        });
    }

    private void btn_delete_grade_private() {
        Button btn_delete_grade_private = findViewById(R.id.delete_grade_private);
        btn_delete_grade_private.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog(4);
            }
        });
    }

    private void confirmDialog(final int grade_num){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Students?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper db = new DatabaseHelper(setting.this);
                db.deleteAllData(grade_num);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    private void set_price() {
        price_one =findViewById(R.id.price_one);
        price_one.setText(preferences.getString("price_grade_one","0"));

        price_two =findViewById(R.id.price_two);
        price_two.setText(preferences.getString("price_grade_two","0"));

        price_there =findViewById(R.id.price_there);
        price_there.setText(preferences.getString("price_grade_there","0"));
    }

    private void btn_save_price() {
        Button btn_save_price =findViewById(R.id.save_price);
        btn_save_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("price_grade_one",price_one.getText().toString());
                editor.putString("price_grade_two",price_two.getText().toString());
                editor.putString("price_grade_there",price_there.getText().toString());
                editor.apply();
                FancyToast.makeText(setting.this, "Successfully Saved!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                back();

            }
        });
    }

    private void btn_back() {
        Button btn_back = findViewById(R.id.btn_back_setting);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             back();
            }
        });
    }

    private void btn_save_user(){
        Button btn_save_user = findViewById(R.id.save_user);
        btn_save_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences = getSharedPreferences("user_password",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                EditText cu_pass_editxt = findViewById(R.id.cu_pass_editxt);
                EditText new_pass_editxt = findViewById(R.id.new_pass_editxt);
                EditText conf_pass_editxt = findViewById(R.id.conf_pass_editxt);

                if (cu_pass_editxt.getText().toString().equals
                        (preferences.getString("password",""))){

                    if (new_pass_editxt.getText().toString().equals(conf_pass_editxt.getText().toString())){

                        editor.putString("password",new_pass_editxt.getText().toString());
                        editor.apply();
                        FancyToast.makeText(setting.this, "Password Changed Successfully!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();

                    }
                    else
                        {
                            FancyToast.makeText(setting.this,"Password does not Match"
                                    ,FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();

                        }
                }
                else {
                    FancyToast.makeText(setting.this,"Wrong Password"
                            ,FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();

                }


            }
        });
    }

    private void  back(){
        if (from_where == 1){
            startActivity(new Intent(setting.this,grades.class));
        }
        else if (from_where == 2){
            startActivity(new Intent(setting.this,user.class));
        }
        finish();
    }
}
