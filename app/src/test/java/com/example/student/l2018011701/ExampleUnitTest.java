package com.example.student.l2018011701;

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
        assertEquals(2, 2 + 2);
    }
    @Test
    public void test()
    {
        assertEquals(8,4+4);
    }

    @Test
    public void test2()
    {
        assertEquals(8,4+2);
    }



}