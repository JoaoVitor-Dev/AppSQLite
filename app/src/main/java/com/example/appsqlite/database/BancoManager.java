package com.example.appsqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoManager
{
    private BancoHelper dbHelper;

    public BancoManager(Context context)
    {
        dbHelper = new BancoHelper(context);
    }

    public SQLiteDatabase open()
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        return database;
    }

    public void close()
    {
        dbHelper.close();
    }
}
