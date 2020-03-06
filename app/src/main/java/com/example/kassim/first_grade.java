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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;


public class first_grade extends AppCompatActivity  {

    private int activity_num;
    private FloatingActionButton add_student;
    private DatabaseHelper db  ;
    private TextView txt_count_student;
    private ArrayList<String> ID, student_name , student_year;
    private RecyclerView recyclerView;
    private Spinner filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_grade);
        add_student = findViewById(R.id.btn_add);
        txt_count_student = findViewById(R.id.txt_count_student);
        recyclerView = findViewById(R.id.recyclerView);

        btn_back();
        btn_add();
        set_grade_name();


        activity_num = getIntent().getIntExtra("activity_num", 1);



        db = new DatabaseHelper(first_grade.this);
        ID = new ArrayList<>();
        student_name = new ArrayList<>();
        student_year = new ArrayList<>();


        onScrolling();
        setFilter();
    }

    private void set_grade_name() {
        TextView grade_name =findViewById(R.id.grade_name);
        if (activity_num ==1){grade_name.setText("First Grade");}
        else if (activity_num ==2){grade_name.setText("Second Grade"); }
        else if (activity_num ==3){grade_name.setText("Third Grade");}
        else if (activity_num ==4){grade_name.setText("Private");}
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        db.close();
    }

    void onScrolling(){
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && add_student.getVisibility() == View.VISIBLE) {
                    add_student.hide();
                } else if (dy < 0 && add_student.getVisibility() != View.VISIBLE) {
                    add_student.show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(first_grade.this, grades.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }

    private void setFilter() {
        filter = findViewById(R.id.spin_area);
        String[] country = { "All","Badaway" , "Biddin" , "Salamon" , "Sobra bidin" , "Mansoura"};
        String[] year = {"All","1" , "2" , "3"};
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);

        if (activity_num == 4){
           aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, year);
       }
        aa.setDropDownViewResource(android.R.layout.simple_list_item_1);
        filter.setAdapter(aa);

        filter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ID.clear(); student_name.clear(); student_year.clear();

                CustomAdapter customAdapter = new CustomAdapter(first_grade.this,ID,student_name,student_year);
                recyclerView.setAdapter(customAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(first_grade.this));
                storeDataInArray(activity_num,filter.getSelectedItem().toString());
                if (recyclerView.getAdapter() != null) {
                    int count = recyclerView.getAdapter().getItemCount();
                    txt_count_student.setText(String.valueOf(count));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void storeDataInArray(int activity_num , String filter_string){
        ImageView empty_image_view = findViewById(R.id.empty_imageview);
        TextView no_data = findViewById(R.id.no_data);

        Cursor cursor = db.readalldata(activity_num , filter_string);
        if(cursor.getCount()==0){
            empty_image_view.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
            if (db.count(activity_num) == 0)
            {
                filter.setVisibility(View.GONE);
                txt_count_student.setVisibility(View.GONE);
            }
            else {
                filter.setVisibility(View.VISIBLE);
                txt_count_student.setVisibility(View.VISIBLE);
            }

        }else {
            while (cursor.moveToNext()){
                ID.add(cursor.getString(0));
                student_name.add(cursor.getString(1));

                if (activity_num == 4) { student_year.add(cursor.getString(18)); }
                else { student_year.add(""); }
            }
            empty_image_view.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
            filter.setVisibility(View.VISIBLE);
            txt_count_student.setVisibility(View.VISIBLE);
        }
    }

    private void btn_add(){
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    private  void btn_back() {
        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(first_grade.this, grades.class));
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                finish();
            }
        });
    }
}