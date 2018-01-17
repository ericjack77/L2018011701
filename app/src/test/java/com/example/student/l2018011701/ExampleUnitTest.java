package com.example.student.l2018011701;

import com.example.student.l2018011701.data.Student;
import com.example.student.l2018011701.data.StudentscoreDAO;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test    //會跑所有有test標籤的 function  專門測試java
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test_add() throws Exception
    {
        StudentscoreDAO dao =new StudentscoreDAO();
        dao.add(new Student(1,"Jizz",88));
        dao.add(new Student(2,"Howk",55));
        dao.add(new Student(3,"Wizard",77));
        dao.delete(5);
        dao.update(new Student(2,"Crazy",66));
        assertEquals(3,dao.getList().size());
        assertEquals(66,dao.getStudent(2).score);
    }

    @Test
    public void test_add2() throws Exception
    {
        StudentscoreDAO dao =new StudentscoreDAO();
        dao.add(new Student(1,"Jizz",88));
        dao.add(new Student(2,"Howk",55));
        dao.add(new Student(3,"Wizard",77));
        assertEquals(77,dao.getList().get(2).score);
    }

    @Test
    public void test_add3() throws Exception
    {
        StudentscoreDAO dao =new StudentscoreDAO();
        dao.add(new Student(1,"Jizz",88));
        dao.add(new Student(2,"Howk",55));
        dao.add(new Student(3,"Wizard",77));
        assertEquals(77,dao.getList().get(2).score);
    }

    @Test
    public void test_getStudent() throws Exception
    {
        StudentscoreDAO dao =new StudentscoreDAO();
        dao.add(new Student(1,"Jizz",88));
        dao.add(new Student(2,"Howk",55));
        dao.add(new Student(3,"Wizard",77));
        assertEquals(55,dao.getStudent(2).score);
        assertEquals(null,dao.getStudent(4));
    }

    @Test
    public void  test_update() throws Exception
    {
        StudentscoreDAO dao =new StudentscoreDAO();
        dao.add(new Student(1,"Jizz",88));
        dao.add(new Student(2,"Howk",55));
        dao.add(new Student(3,"Wizard",77));
        dao.update(new Student(2,"Fuck",99));
        assertEquals(99,dao.getStudent(2).score);
    }

    @Test
    public void  test_delete() throws Exception
    {
        StudentscoreDAO dao =new StudentscoreDAO();
        dao.add(new Student(1,"Jizz",88));
        dao.add(new Student(2,"Howk",55));
        dao.add(new Student(3,"Wizard",77));
        assertEquals(2,dao.getList().size());
    }

}