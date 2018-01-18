package com.example.student.l2018011701.data;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentFileDAO {
    Context context;
    public ArrayList<Student> studentlist;
    public StudentFileDAO(Context context)
    {
        this.context=context;
        studentlist = new ArrayList<>();
    }

    public void save()
    {
        File f =new File(context.getFilesDir(),"studentlist.txt");
        FileWriter fw =null;
        try {
            fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(studentlist);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void load()
    {
        File f =new File(context.getFilesDir(),"studentlist.txt");
        FileReader fr = null;
        try {
            fr= new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Gson gson = new Gson();
            studentlist = gson.fromJson(str,new TypeToken<ArrayList<Student>>(){}.getType());
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean add(Student s)
    {
        studentlist.add(s);
        save();
        return true;
    }

    public ArrayList<Student> getList()
    {
        load();
        return studentlist;
    }


    public Student getStudent(int id)
    {
        load();
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
        load();
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
        load();
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



//    public boolean delete(int id)
//    {
//        for (int i=0;i<mylist.size();i++)
//        {
//            if (mylist.get(i).id == id)
//            {
//                mylist.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }




}
