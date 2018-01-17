package com.example.student.l2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.l2018011701.data.Student;

public class DetailActivity extends AppCompatActivity {
    TextView tv,tv2,tv3;
    Student s;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        id=getIntent().getIntExtra("id",0);
        tv=findViewById(R.id.textView1);
        tv2=findViewById(R.id.textView2);
        tv3=findViewById(R.id.textView3);
        s=MainActivity.dao.getStudent(id);
        tv.setText("ID:"+String.valueOf(s.id));
        tv2.setText("名字:"+s.name);
        tv3.setText("分數:"+String.valueOf(s.score));

    }

    public void clickDelete(View v)
    {
        MainActivity.dao.delete(id);
        Intent it = new Intent(DetailActivity.this,MainActivity.class);
        startActivity(it);
    }

    public  void clickEdit(View v)
    {
        Intent it = new Intent(DetailActivity.this,EditActivity.class);
        it.putExtra("id2",id);
        startActivity(it);
    }

    public  void clickBack(View v)
    {
        Intent it = new Intent(DetailActivity.this,MainActivity.class);
        startActivity(it);
    }
}
