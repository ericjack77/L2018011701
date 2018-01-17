package com.example.student.l2018011701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.student.l2018011701.data.Student;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void clickAdd(View v)
    {
        EditText etid=findViewById(R.id.editText2);
        EditText etname=findViewById(R.id.editText4);
        EditText etscore=findViewById(R.id.editText3);
        int id=Integer.valueOf(etid.getText().toString());
        String name = etname.getText().toString();
        int score=Integer.valueOf(etscore.getText().toString());
        MainActivity.dao.add(new Student(id,name,score));
    }
}
