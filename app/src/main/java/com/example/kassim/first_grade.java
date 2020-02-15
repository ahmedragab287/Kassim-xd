package com.example.kassim;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;


public class first_grade extends AppCompatActivity  {

    int activity_num;
    FloatingActionButton main_float ,add_student, delete_all;
    float translatonY =600f;
    OvershootInterpolator interpolator = new OvershootInterpolator();
    Boolean ismenuopen = false;

    DatabaseHelper db;
    ImageView empty_imageview;
    TextView no_data , grade_name;
    ArrayList<String> ID, student_name;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    Spinner spin_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_grade);

        btn_back();         btn_main_float();
        btn_add();          btn_delete_all();

        recyclerView = findViewById(R.id.recyclerView);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        grade_name =findViewById(R.id.grade_name);

        activity_num = getIntent().getIntExtra("activity_num", 1);
        if (activity_num ==1){grade_name.setText("First Grade");}
        else if (activity_num ==2){grade_name.setText("Second Grade"); }
        else if (activity_num ==3){grade_name.setText("Third Grade");}
        else if (activity_num ==4){grade_name.setText("Private");}

        add_student.animate().translationY(translatonY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        delete_all.animate().translationY(translatonY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();


        db = new DatabaseHelper(first_grade.this);
        ID = new ArrayList<>();
        student_name = new ArrayList<>();

        spin_area_change();
    }

    private void spin_area_change() {
        spin_area = findViewById(R.id.spin_area);
        String[] country = { "All","Badaway" , "Biddin" , "Salamon" , "Sobra bidin" , "Mansoura"};
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spin_area.setAdapter(aa);

        spin_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ID.clear(); student_name.clear();
                customAdapter = new CustomAdapter(first_grade.this,ID,student_name);
                recyclerView.setAdapter(customAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(first_grade.this));
                storeDataInArray(activity_num,spin_area.getSelectedItem().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    void storeDataInArray(int activity_num , String area){

        Cursor cursor = db.readalldata(activity_num , area);
        if(cursor.getCount()==0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);

        }else {
            while (cursor.moveToNext()){
                ID.add(cursor.getString(0));
                student_name.add(cursor.getString(1));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }

    private void openMenu(){
        ismenuopen = !ismenuopen;
        main_float.setImageResource(R.drawable.ic_close);
        main_float.animate().setInterpolator(interpolator).rotationBy(90f).setDuration(300).start();
        add_student.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        delete_all.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
    }

    private void closeMenu(){
        ismenuopen = !ismenuopen;
        main_float.setImageResource(R.drawable.ic_keyboard_arrow_up);
        main_float.animate().setInterpolator(interpolator).rotationBy(-90f).setDuration(300).start();
        add_student.animate().alpha(0f).translationY(translatonY).setInterpolator(interpolator).setDuration(300).start();
        delete_all.animate().alpha(0f).translationY(translatonY).setInterpolator(interpolator).setDuration(300).start();
    }

    public void btn_main_float(){
        main_float = findViewById(R.id.btn_more);
        main_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ismenuopen)
                {
                    closeMenu();
                }else
                {
                    openMenu();
                }
            }
        });
    }

    public void btn_add(){
        add_student = findViewById(R.id.btn_add);
        add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(first_grade.this, add_student.class);
                i.putExtra("activity_num", activity_num);
                startActivity(i);
                finish();
            }
        });
    }

    public void btn_delete_all(){
        delete_all = findViewById(R.id.btn_delete_all);
        delete_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               confirmDialog();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Students?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper myDB = new DatabaseHelper(first_grade.this);
                myDB.deleteAllData(activity_num);
                //Refresh Activity
                ID.clear(); student_name.clear();
                customAdapter = new CustomAdapter(first_grade.this,ID,student_name);
                recyclerView.setAdapter(customAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(first_grade.this));
                storeDataInArray(activity_num,"All");
                closeMenu();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    public void btn_back() {
        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(first_grade.this, grades.class));
                finish();
            }
        });
    }

}
