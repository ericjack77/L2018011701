package com.example.student.l2018011701.data;


import android.content.Context;

import com.example.student.l2018011701.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentCloudDAOImpl implements StudentDAO {
    Context context;
    public ArrayList<Student> studentlist;
    FirebaseDatabase database;
    DatabaseReference myRef;
    public StudentCloudDAOImpl(final Context context)
    {
        this.context=context;
        studentlist = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("testforcloud");

        // Read from the database
        //EventListener 隨時監聽線上更新
        myRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Gson gson = new Gson();
                studentlist = gson.fromJson(value,new TypeToken<ArrayList<Student>>(){}.getType());
                ((MainActivity) context).refresh();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        if (studentlist == null)
        {
            studentlist = new ArrayList<>();

        }


    }

    public void save()
    {
        Gson gson = new Gson();
        String data = gson.toJson(studentlist);

        myRef.setValue(data);
    }



    public boolean add(Student s)
    {
        if (studentlist == null)
        {
            studentlist = new ArrayList<>();
        }
        studentlist.add(s);
        save();
        return true;
    }

    public ArrayList<Student> getList()
    {
        return studentlist;
    }


    public Student getStudent(int id)
    {
        for(Student s:studentlist)
        {
            if(s.id==id)
            {
                return s;
            }
        }
        return null;
    }

    public boolean update(Student s)
    {
        for (Student t : studentlist)
        {
            if (t.id == s.id)
            {
                t.name = s.name;
                t.score = s.score;
                save();
                return true;
            }
        }
        return false;
    }

    public boolean update2(Student ss)
    {
        for(Student s:studentlist)
        {
            int i=0;
            if(s.id==ss.id)
            {
                studentlist.set(i,ss);
                return true;
            }
            i++;
        }
        return false;

    }

    public boolean delete(int id)
    {
        int i=0;
        for(Student s:studentlist)
        {

            if(s.id==id)
            {
                studentlist.remove(i);
                save();
                return true;
            }
            i++;
        }
        return false;
    }








}
