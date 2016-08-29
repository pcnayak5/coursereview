package com.example.prashanthc.coursereview;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyBDHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "subjects.db"; //name of file
    public static final String TABLE_SUBJECTS = "subjects"; //name of table
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCE = "produce";

    public MyBDHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_SUBJECTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_PRODUCE + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBJECTS);
        onCreate(db);
    }

    public void addSubject(Subjects subject) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCE, subject.get_subject());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_SUBJECTS, null, values);
        db.close();
    }



    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM  " + TABLE_SUBJECTS + " WHERE  1";


        //means select                          //select every row
        //everything

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //c.close();
        c.moveToFirst();

        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("produce")) != null) {
                dbString += c.getString(c.getColumnIndex("produce"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        c.close();
        db.close();
        return dbString;
    }
}
