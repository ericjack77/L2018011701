package com.example.student.l2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.student.l2018011701.data.Student;
import com.example.student.l2018011701.data.StudentscoreDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final public static StudentscoreDAO dao =new StudentscoreDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView lv =findViewById(R.id.listview);
        ArrayList<String> studentname = new ArrayList<>();
        for(Student s:dao.getList())
        {
            studentname.add(s.name);
        }

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,
                studentname
                );
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) //創造解壓縮menu
    {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) //選ITEM
    {
        if(item.getItemId()== R.id.menu_add)
        {
            Intent it = new Intent(MainActivity.this, AddActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
