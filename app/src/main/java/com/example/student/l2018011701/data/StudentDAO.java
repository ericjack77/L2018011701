package com.example.student.l2018011701.data;

import java.util.ArrayList;



public interface StudentDAO
{
    public boolean add(Student s);
    public ArrayList<Student> getList();
    public Student getStudent(int id);
    public boolean update(Student s);
    public boolean delete(int id);
}
