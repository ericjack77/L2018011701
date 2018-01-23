package com.example.student.l2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.student.l2018011701.data.DBtype;
import com.example.student.l2018011701.data.Student;
import com.example.student.l2018011701.data.StudentDAO;
import com.example.student.l2018011701.data.StudentDAOFactory;
import com.example.student.l2018011701.data.StudentFileDAO;
import com.example.student.l2018011701.data.StudentscoreDAO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static StudentDAO dao;
    DBtype type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        type=DBtype.CLOUD;
        dao = StudentDAOFactory.getDAOInstance(this,type);

    }


    @Override
    protected void onStart() {
        super.onStart();

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
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it =new Intent(MainActivity.this,DetailActivity.class);
                it.putExtra("id",dao.getList().get(position).id);
                startActivity(it);
            }
        });






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
