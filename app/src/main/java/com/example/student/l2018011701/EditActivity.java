package com.example.student.l2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.student.l2018011701.data.Student;

public class EditActivity extends AppCompatActivity {
    int id;
    EditText etName,etScore;
    Student s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        id =getIntent().getIntExtra("id",0);
        etName=findViewById(R.id.editText);
        etScore=findViewById(R.id.editText6);
        s=MainActivity.dao.getStudent(id);


    }

    public void clickSubmit(View v)
    {
        String newName = etName.getText().toString();
        int newScore = Integer.parseInt(etScore.getText().toString());
        MainActivity.dao.update(new Student(id,newName,newScore));
        finish();
    }

    public void clickCancle(View v)
    {
        finish();
    }
}
