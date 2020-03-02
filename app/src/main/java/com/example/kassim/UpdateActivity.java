package com.example.kassim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UpdateActivity extends AppCompatActivity {

    private String id, student_name;
    private DatabaseHelper db = new DatabaseHelper(UpdateActivity.this);
    private EditText et_student_name , et_student_phone , et_student_private_price_update;
    private CheckBox cb_aug , cb_sep , cb_oct , cb_nov , cb_dec , cb_jan , cb_feb , cb_mar , cb_apr ,
             cb_may , cb_note1 , cb_note2 , cb_rev1 , cb_rev2 ;
    private SharedPreferences preferences;
    private String activity_num ;
    Spinner spinner_student_country_update , spinner_student_private_year_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        et_student_private_price_update = findViewById(R.id.et_student_private_price_update);
        spinner_student_private_year_update = findViewById(R.id.et_student_private_year_update);

        preferences = getSharedPreferences("activity_num",MODE_PRIVATE);
        activity_num = preferences.getString("activity_num_num","");

        /*if (Integer.parseInt(activity_num) == 4){
            et_student_private_price_update.setVisibility(View.VISIBLE);
            spinner_student_private_year_update.setVisibility(View.VISIBLE);
            set_spinner();
        } else {
            et_student_private_price_update.setVisibility(View.GONE);
            spinner_student_private_year_update.setVisibility(View.GONE);
        }*/
        set_spinner();

        et_student_name =findViewById(R.id.et_student_name_update);
        et_student_phone =findViewById(R.id.et_student_phone_update);
        cb_aug =findViewById(R.id.cb_aug_update);
        cb_sep =findViewById(R.id.cb_sep_update);
        cb_oct =findViewById(R.id.cb_oct_update);
        cb_nov =findViewById(R.id.cb_nov_update);
        cb_dec =findViewById(R.id.cb_dec_update);
        cb_jan =findViewById(R.id.cb_jan_update);
        cb_feb =findViewById(R.id.cb_feb_update);
        cb_mar =findViewById(R.id.cb_mar_update);
        cb_apr =findViewById(R.id.cb_apr_update);
        cb_may =findViewById(R.id.cb_may_update);
        cb_note1 =findViewById(R.id.cb_note1_update);
        cb_note2 =findViewById(R.id.cb_note2_update);
        cb_rev1 =findViewById(R.id.cb_rev1_update);
        cb_rev2 =findViewById(R.id.cb_rev2_update);
        spinner_student_country_update = findViewById(R.id.et_student_country_update);
        student_name = getIntent().getStringExtra("student_name");
        id = getIntent().getStringExtra("id");



        btn_back_update();
        getAndSetIntentData();
        btn_update();
        btn_delete();

    }

    private void set_spinner() {
        String[] country = { "Badaway" , "Biddin" , "Salamon" , "Sobra bidin" , "Mansoura"};
        String[] year = {"1" , "2" , "3"};
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner_student_country_update.setAdapter(aa);

        ArrayAdapter a2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, year);
        a2.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner_student_private_year_update.setAdapter(a2);
    }

    void btn_update(){
        FloatingActionButton btn_save_update =findViewById(R.id.btn_save_update);
        btn_save_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = getIntent().getStringExtra("id");
                String private_price_update =et_student_private_price_update.getText().toString().trim();
                String private_year_update =spinner_student_private_year_update.getSelectedItem().toString().trim();

                db.updateData( Integer.parseInt(activity_num), id,
                        et_student_name.getText().toString(),
                        et_student_phone.getText().toString(),
                        spinner_student_country_update.getSelectedItem().toString().trim(),
                        cb_aug.isChecked()?1:0,
                        cb_sep.isChecked()?1:0,
                        cb_oct.isChecked()?1:0,
                        cb_nov.isChecked()?1:0,
                        cb_dec.isChecked()?1:0,
                        cb_jan.isChecked()?1:0,
                        cb_feb.isChecked()?1:0,
                        cb_mar.isChecked()?1:0,
                        cb_apr.isChecked()?1:0,
                        cb_may.isChecked()?1:0,
                        cb_note1.isChecked()?1:0,
                        cb_note2.isChecked()?1:0,
                        cb_rev1.isChecked()?1:0,
                        cb_rev2.isChecked()?1:0,
                        Integer.parseInt(activity_num) == 4?private_price_update.equals("")?"0":private_price_update:"",
                        Integer.parseInt(activity_num) == 4?private_year_update.equals("")?"1":private_price_update:""
                        );

            }
        });

    }

    void btn_delete(){
        Button btn_delete = findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData(){

        Spinner et_student_country = findViewById(R.id.et_student_country_update);

        if(getIntent().hasExtra("student_name") &&
                getIntent().hasExtra("id")){


            et_student_name.setText(student_name);

            et_student_phone.setText(db.get_student_phone(Integer.parseInt(activity_num), Integer.parseInt(id) ));

            //et_student_country.(db.get_student_country(Integer.parseInt(activity_num), Integer.parseInt(id) ));

            get_checkboxes();

        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void get_checkboxes(){

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "aug") == 1)
        { cb_aug.setChecked(true);} else {cb_aug.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "sep") == 1)
        { cb_sep.setChecked(true);} else {cb_sep.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "oct") == 1)
        { cb_oct.setChecked(true);} else {cb_oct.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "nov")== 1)
        { cb_nov.setChecked(true);} else {cb_nov.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "dec") == 1)
        { cb_dec.setChecked(true);} else {cb_dec.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "note1") == 1)
        { cb_note1.setChecked(true);} else {cb_note1.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "rev1") == 1)
        { cb_rev1.setChecked(true);} else {cb_rev1.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "jan") == 1)
        { cb_jan.setChecked(true);} else {cb_jan.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "fep") == 1)
        { cb_feb.setChecked(true);} else {cb_feb.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "mar") == 1)
        { cb_mar.setChecked(true);} else {cb_mar.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "apr") == 1)
        { cb_apr.setChecked(true);} else {cb_apr.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "may") == 1)
        { cb_may.setChecked(true);} else {cb_may.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "note2") == 1)
        { cb_note2.setChecked(true);} else {cb_note2.setChecked(false); }

        if (db.checkbox(Integer.parseInt(activity_num) , Integer.parseInt(id) , "rev2") == 1)
        { cb_rev2.setChecked(true);} else {cb_rev2.setChecked(false); }

    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + student_name + " ?");
        builder.setMessage("Are you sure you want to delete " + student_name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                db.deleteOneRow(id , Integer.parseInt(activity_num));
                back();
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
                back();
            }
        });
    }

    void back(){
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();

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