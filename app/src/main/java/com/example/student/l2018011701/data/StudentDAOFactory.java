package com.example.student.l2018011701.data;

import android.content.Context;

/**
 * Created by Student on 2018/1/18.
 */

public class StudentDAOFactory
{
    public static StudentDAO getDAOInstance(Context context,DBtype type)
    {
        switch (type)
        {
            case Memory:
                return new StudentscoreDAO();
            case File:
                return new StudentFileDAO(context);
            case DB:
                return new StudentDAODBimpl(context);
        }
        return null;
    }

}
