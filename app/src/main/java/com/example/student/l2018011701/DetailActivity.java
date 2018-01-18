package com.example.student.l2018011701;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
    boolean fastback=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        id=getIntent().getIntExtra("id",0);
        tv=findViewById(R.id.textView1);
        tv2=findViewById(R.id.textView2);
        tv3=findViewById(R.id.textView3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (fastback)
        {
            finish();
        }
        s=MainActivity.dao.getStudent(id);
        tv.setText("ID:"+String.valueOf(s.id));
        tv2.setText("名字:"+s.name);
        tv3.setText("分數:"+String.valueOf(s.score));
    }

    public void clickDelete(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
        builder.setTitle("刪除資料");
        builder.setMessage("確認刪除?");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.dao.delete(id);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();

    }

    public  void clickEdit(View v)
    {
        Intent it = new Intent(DetailActivity.this,EditActivity.class);
        it.putExtra("id",id);
        fastback=true;
        startActivity(it);
    }

    public  void clickBack(View v)
    {
        finish();
    }
}
