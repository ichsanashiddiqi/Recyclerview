package com.ichsan.layoutlanjutan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.Viewholder>{

    private List<Student> students;
    private Context context;
    private OnAdapterClickListener listener;

    interface OnAdapterClickListener{
        void onClick(Student student);
    }
    public StudentAdapter(List<Student>students, Context context){
        this(students,context, null);
    }
    public StudentAdapter(List<Student> students, Context context, OnAdapterClickListener listener) {
        this.students = students;
        this.context = context;
        this.listener = listener;
    }

    public void setListener(OnAdapterClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.item_student,viewGroup, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        Student student=students.get(i);
        viewholder.nameText.setText(student.getName());
        viewholder.idText.setText(student.getId());
    }

    @Override
    public int getItemCount() {
        return (students != null) ? students.size():0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView idText;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.text_name);
            idText = itemView.findViewById(R.id.text_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(students.get(getAdapterPosition()));
                }
            });
        }
    }
}
