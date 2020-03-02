package com.example.kassim;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList ID ,student_name , student_year;

    CustomAdapter(Context context ,
                  ArrayList id ,
                  ArrayList Student_Name ,  ArrayList Student_Year){
        this.context = context;
        this.ID = id;
        this.student_name = Student_Name;
        this.student_year = Student_Year;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_group , parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.id.setText(String.valueOf(ID.get(position)));
        holder.student_name.setText(String.valueOf(student_name.get(position)));
        holder.student_year.setText(String.valueOf(student_year.get(position)));


        holder.mainlinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,UpdateActivity.class);
                i.putExtra("id",String.valueOf(ID.get(position)));
                i.putExtra("student_name",String.valueOf(student_name.get(position)));
                i.putExtra("activity_num", 1);

                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return student_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id , student_name , student_year;
        LinearLayout mainlinear;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.item_id);
            student_name = itemView.findViewById(R.id.item_name);
            student_year = itemView.findViewById(R.id.student_year);
            mainlinear = itemView.findViewById(R.id.mainLayout);

        }
    }

}