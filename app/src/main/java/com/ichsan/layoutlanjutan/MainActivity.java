package com.ichsan.layoutlanjutan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentAdapter.OnAdapterClickListener {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_students);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Zain", "321"));
        students.add(new Student("Deby", "321"));
        students.add(new Student("SAN", "321"));

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        StudentAdapter adapter=new StudentAdapter(students, this,this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(Student student) {
        Log.i(MainActivity.class.getName(),student.getName());
    }
}
