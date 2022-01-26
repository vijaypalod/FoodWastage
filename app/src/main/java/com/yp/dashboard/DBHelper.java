package com.yp.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "FWM.db";

    public DBHelper(Context context) {
        super(context, "FWM.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users (id INTEGER PRIMARY KEY autoincrement, name TEXT, email TEXT unique, password TEXT, mobile TEXT)");
        MyDB.execSQL("create Table donate (d_id INTEGER PRIMARY KEY autoincrement,dName TEXT, dEmail TEXT, dMobile TEXT, dAddress TEXT,dDate TEXT,dFood TEXT,dQuantity TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists donate");
        onCreate(MyDB);
    }

    public Boolean insertData(String name, String email, String password, String mobile){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("mobile",mobile);
        long result = MyDB.insert("users",null,contentValues);
        if(result == -1) return false;
        else {
            return true;
        }
    }

    //------------------------------------------------

    //------------------------------------------------

    public Cursor readAllData(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String qry ="select * from users order by id desc";
        Cursor cursor = MyDB.rawQuery(qry,null);
        return cursor;
    }

    public Boolean insertDonate(String name, String email, String mobile, String address, String date, String food, String quant){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dName",name);
        contentValues.put("dEmail",email);
        contentValues.put("dMobile",mobile);
        contentValues.put("dAddress",address);
        contentValues.put("dDate",date);
        contentValues.put("dFood",food);
        contentValues.put("dQuantity",quant);
        long dResult = MyDB.insert("donate",null,contentValues);
        if(dResult == -1) return false;
        else return true;
    }

    public ArrayList<model1> getAllDonate(){
        ArrayList<model1> model1s = new ArrayList<>();

        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from donate",null);

        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String mobile = cursor.getString(3);
                String address = cursor.getString(4);
                String date = cursor.getString(5);
                String food = cursor.getString(6);
                String quantity = cursor.getString(7);

                model1 m = new model1(id,name,email,mobile,address,date,food,quantity);
                model1s.add(m);
            }while (cursor.moveToNext());
        }
        return model1s;
    }

    public Boolean checkUserEmail(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email=?",new String[] {email});
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkEmailPassword(String email,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where email=? and password=?",new String[] {email,password});
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }

    public int deleteRequest(int id) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        return MyDB.delete("donate","d_id=?",new String[]{String.valueOf(id)});

    }
}
