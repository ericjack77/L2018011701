package com.example.student.l2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.student.l2018011701.data.StudentscoreDAO;

public class MainActivity extends AppCompatActivity {
    final public static StudentscoreDAO dao =new StudentscoreDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
        if(item.getItemId()== R.id.menu_add)
        {
            Intent it = new Intent(MainActivity.this,AddActivity.class);
            startActivity(it);
        }
    }
}
