package com.example.kassim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList ID ,student_name;

    CustomAdapter(Context context ,
                  ArrayList id ,
                  ArrayList Student_Name){
        this.context = context;
        this.ID = id;
        this.student_name = Student_Name;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_group , parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.student_name.setText(String.valueOf(student_name.get(position)));
        holder.id.setText(String.valueOf(ID.get(position)));

    }

    @Override
    public int getItemCount() {
        return student_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id , student_name ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            student_name = itemView.findViewById(R.id.item_name);
            id = itemView.findViewById(R.id.item_id);

        }
    }


}
