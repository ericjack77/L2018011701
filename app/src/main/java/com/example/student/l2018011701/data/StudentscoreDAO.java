package com.example.student.l2018011701.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/17.
 */

public class StudentscoreDAO implements StudentDAO{
    public ArrayList<Student> studentlist;
    public StudentscoreDAO()
    {
        studentlist = new ArrayList<>();
    }

    public boolean add(Student s)
    {
        studentlist.add(s);
        return true;
    }

    public ArrayList<Student> getList()
    {
        return studentlist;
    }

//    public String getStudent(int id)
//    {
//        return "ID:"+studentlist.get(id).id+",名字"+studentlist.get(id).name+",分數"+studentlist.get(id).score;
//    }
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
