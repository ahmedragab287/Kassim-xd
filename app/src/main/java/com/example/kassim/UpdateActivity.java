package com.example.kassim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {


    Button btn_update, btn_delete;
    String id, student_name;
    DatabaseHelper db = new DatabaseHelper(UpdateActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);


        btn_back_update();


        getAndSetIntentData();
    }


    void getAndSetIntentData(){



        EditText et_student_name =findViewById(R.id.et_student_name_update);
        EditText et_phone_name =findViewById(R.id.et_student_phone_update);

        if(getIntent().hasExtra("student_name") &&
                getIntent().hasExtra("id")){

            SharedPreferences preferences = getSharedPreferences("activity_num",MODE_PRIVATE);
            String activity_num = preferences.getString("activity_num_num","");



            id = getIntent().getStringExtra("id");
            student_name = getIntent().getStringExtra("student_name");

            et_student_name.setText(student_name);




            String student_phone =  db.edit_text_info(Integer.parseInt(activity_num), Integer.parseInt(id) );

            et_phone_name.setText(student_phone);

            get_checkboxes();


        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void get_checkboxes(){
        SharedPreferences preferences = getSharedPreferences("activity_num",MODE_PRIVATE);
        String activity_num = preferences.getString("activity_num_num","");

        CheckBox cb_aug =findViewById(R.id.cb_aug_update);
        CheckBox cb_sep =findViewById(R.id.cb_sep_update);
        CheckBox cb_oct =findViewById(R.id.cb_oct_update);
        CheckBox cb_nov =findViewById(R.id.cb_nov_update);
        CheckBox cb_dec =findViewById(R.id.cb_dec_update);
        CheckBox cb_jan =findViewById(R.id.cb_jan_update);
        CheckBox cb_feb =findViewById(R.id.cb_feb_update);
        CheckBox cb_mar =findViewById(R.id.cb_mar_update);
        CheckBox cb_apr =findViewById(R.id.cb_apr_update);
        CheckBox cb_may =findViewById(R.id.cb_may_update);
        CheckBox cb_note1 =findViewById(R.id.cb_note1_update);
        CheckBox cb_note2 =findViewById(R.id.cb_note2_update);
        CheckBox cb_rev1 =findViewById(R.id.cb_rev1_update);
        CheckBox cb_rev2 =findViewById(R.id.cb_rev2_update);

        int check_tosend;
        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "aug");
        if (check_tosend == 1){ cb_aug.setChecked(true);} else {cb_aug.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "sep");
        if (check_tosend == 1){ cb_sep.setChecked(true);} else {cb_sep.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "oct");
        if (check_tosend == 1){ cb_oct.setChecked(true);} else {cb_oct.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "nov");
        if (check_tosend == 1){ cb_nov.setChecked(true);} else {cb_nov.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "dec");
        if (check_tosend == 1){ cb_dec.setChecked(true);} else {cb_dec.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "note1");
        if (check_tosend == 1){ cb_note1.setChecked(true);} else {cb_note1.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "rev1");
        if (check_tosend == 1){ cb_rev1.setChecked(true);} else {cb_rev1.setChecked(false); }




        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "jan");
        if (check_tosend == 1){ cb_jan.setChecked(true);} else {cb_jan.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "fep");
        if (check_tosend == 1){ cb_feb.setChecked(true);} else {cb_feb.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "mar");
        if (check_tosend == 1){ cb_mar.setChecked(true);} else {cb_mar.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "apr");
        if (check_tosend == 1){ cb_apr.setChecked(true);} else {cb_apr.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "may");
        if (check_tosend == 1){ cb_may.setChecked(true);} else {cb_may.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "note2");
        if (check_tosend == 1){ cb_note2.setChecked(true);} else {cb_note2.setChecked(false); }

        check_tosend =  db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "rev2");
        if (check_tosend == 1){ cb_rev2.setChecked(true);} else {cb_rev2.setChecked(false); }

    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + student_name + " ?");
        builder.setMessage("Are you sure you want to delete " + student_name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper myDB = new DatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    void btn_back_update(){
        Button btn_back_update =findViewById(R.id.btn_back_update);
        btn_back_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("activity_num",MODE_PRIVATE);
                String activity_num = preferences.getString("activity_num_num","");

                if (Integer.parseInt(activity_num) ==1)
                {
                    Intent i = new Intent(UpdateActivity.this,first_grade.class);
                    i.putExtra("activity_num", 1);
                    startActivity(i);
                }
                else if (Integer.parseInt(activity_num) ==2){
                    Intent i = new Intent(UpdateActivity.this,first_grade.class);
                    i.putExtra("activity_num", 2);
                    startActivity(i);
                }
                else if (Integer.parseInt(activity_num) ==3){
                    Intent i = new Intent(UpdateActivity.this,first_grade.class);
                    i.putExtra("activity_num", 3);
                    startActivity(i);
                }
                else if (Integer.parseInt(activity_num) ==4){
                    Intent i = new Intent(UpdateActivity.this,first_grade.class);
                    i.putExtra("activity_num", 4);
                    startActivity(i);
                }
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        SharedPreferences preferences = getSharedPreferences("activity_num",MODE_PRIVATE);
        String activity_num = preferences.getString("activity_num_num","");

        if (Integer.parseInt(activity_num) ==1)
        {
            Intent i = new Intent(UpdateActivity.this,first_grade.class);
            i.putExtra("activity_num", 1);
            startActivity(i);
        }
        else if (Integer.parseInt(activity_num) ==2){
            Intent i = new Intent(UpdateActivity.this,first_grade.class);
            i.putExtra("activity_num", 2);
            startActivity(i);
        }
        else if (Integer.parseInt(activity_num) ==3){
            Intent i = new Intent(UpdateActivity.this,first_grade.class);
            i.putExtra("activity_num", 3);
            startActivity(i);
        }
        else if (Integer.parseInt(activity_num) ==4){
            Intent i = new Intent(UpdateActivity.this,first_grade.class);
            i.putExtra("activity_num", 4);
            startActivity(i);
        }
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}
