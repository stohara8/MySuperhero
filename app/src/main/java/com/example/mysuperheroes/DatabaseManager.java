package com.example.mysuperheroes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context){
        super(context, "SuperheroDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql = "create table SuperheroTable (";
        sql += "id integer primary key autoincrement, ";
        sql += "name text, company text, year text)";
        db.execSQL(sql);
    }

    public void insert(String heroName, String companyName, String yearDate){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into SuperheroTable values(";
        sql += "null, '"+heroName+"', '"+companyName+"', '"+yearDate+"')";
        db.execSQL(sql);
        db.close();
    }

    public void delete(String heroName){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "delete from SuperheroTable where title = '"+heroName+"'";
        db.execSQL(sql);
        db.close();
    }

    public void updateByName(String name, String company){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "update SuperheroTable set company = '"+company+"' ";
        sql += "where name = '"+name+"' ";
       // sql += "or update SuperheroTable set year = '"+year+"' ";
        //sql += "where name = '"+name+"'";
        db.execSQL(sql);
        /*String sql2 = "update SuperheroTable set year = '"+year+"'";
        sql2 += "where name = '"+name+"'";
        db.execSQL(sql2);*/
        db.close();
    }

    public void updateByName2(String name, String year){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "update SuperheroTable set year = '"+year+"'";
        sql += "where name = '"+name+"'";
        db.execSQL(sql);
        db.close();
    }

    public ArrayList<String> getNames(){
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from SuperheroTable";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            String name = cursor.getString(1);
            list.add(name);
        }
        db.close();
        return list;
    }

    public String[] get(String heroName){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from SuperheroTable where name = '"+heroName+"'";
        Cursor cursor = db.rawQuery(sql, null);
        String[] entry = new String[3];
        if (cursor.moveToFirst()){
            String name = cursor.getString(1);
            String company = cursor.getString(2);
            String year = cursor.getString(3);
            entry[0] = name;
            entry[1] = company;
            entry[2] = year;
        }
        db.close();
        return entry;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
