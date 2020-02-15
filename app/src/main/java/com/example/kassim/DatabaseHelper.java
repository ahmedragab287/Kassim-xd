package com.example.kassim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.shashank.sony.fancytoastlib.FancyToast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DB_NAME ="Student_list.db";
    private static final String Table_Grade1 ="Grade1_Table";
    private static final String Table_Grade2 ="Grade2_Table";
    private static final String Table_Grade3 ="Grade3_Table";
    private static final String Table_GradeP ="GradeP_Table";

    private static final String ID ="ID";
    private static final String col_NAME ="NAME";
    private static final String col_PHONE ="PHONE";
    private static final String col_COUNRTY = "COUNTRY";
    private static final String col_aug = "month_aug";
    private static final String col_sep = "month_sep";
    private static final String col_oct = "month_oct";
    private static final String col_nov = "month_nov";
    private static final String col_dec = "month_dec";
    private static final String col_jan = "month_jan";
    private static final String col_feb = "month_feb";
    private static final String col_mar = "month_mar";
    private static final String col_apr = "month_apr";
    private static final String col_may = "month_may";
    private static final String col_note1 = "month_note1";
    private static final String col_note2 = "month_note2";
    private static final String col_rev1 = "month_rev1";
    private static final String col_rev2 = "month_rev2";


    DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_Grade1 =" CREATE TABLE IF NOT EXISTS " + Table_Grade1 +"("+
                ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                col_NAME  +" TEXT ,"+
                col_PHONE +" TEXT ," +
                col_COUNRTY +" TEXT ,"+
                col_aug   + " INTEGER ,"+
                col_sep   + " INTEGER ,"+
                col_oct   + " INTEGER ,"+
                col_nov   + " INTEGER ,"+
                col_dec   + " INTEGER ,"+
                col_jan   + " INTEGER ,"+
                col_feb   + " INTEGER ,"+
                col_mar   + " INTEGER ,"+
                col_apr   + " INTEGER ,"+
                col_may   + " INTEGER ,"+
                col_note1 + " INTEGER ,"+
                col_note2 + " INTEGER ,"+
                col_rev1  + " INTEGER ,"+
                col_rev2  + " INTEGER "+
                ")";

        String CREATE_TABLE_Grade2 =" CREATE TABLE IF NOT EXISTS " + Table_Grade2 +"("+
                ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                col_NAME  +" TEXT ,"+
                col_PHONE +" TEXT ," +
                col_COUNRTY +" TEXT ,"+
                col_aug   + " INTEGER ,"+
                col_sep   + " INTEGER ,"+
                col_oct   + " INTEGER ,"+
                col_nov   + " INTEGER ,"+
                col_dec   + " INTEGER ,"+
                col_jan   + " INTEGER ,"+
                col_feb   + " INTEGER ,"+
                col_mar   + " INTEGER ,"+
                col_apr   + " INTEGER ,"+
                col_may   + " INTEGER ,"+
                col_note1 + " INTEGER ,"+
                col_note2 + " INTEGER ,"+
                col_rev1  + " INTEGER ,"+
                col_rev2  + " INTEGER "+
                ")";

        String CREATE_TABLE_Grade3 =" CREATE TABLE IF NOT EXISTS " + Table_Grade3 +"("+
                ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                col_NAME  +" TEXT ,"+
                col_PHONE +" TEXT ," +
                col_COUNRTY +" TEXT ,"+
                col_aug   + " INTEGER ,"+
                col_sep   + " INTEGER ,"+
                col_oct   + " INTEGER ,"+
                col_nov   + " INTEGER ,"+
                col_dec   + " INTEGER ,"+
                col_jan   + " INTEGER ,"+
                col_feb   + " INTEGER ,"+
                col_mar   + " INTEGER ,"+
                col_apr   + " INTEGER ,"+
                col_may   + " INTEGER ,"+
                col_note1 + " INTEGER ,"+
                col_note2 + " INTEGER ,"+
                col_rev1  + " INTEGER ,"+
                col_rev2  + " INTEGER "+
                ")";
        String CREATE_TABLE_GradeP =" CREATE TABLE IF NOT EXISTS " + Table_GradeP +"("+
                ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                col_NAME  +" TEXT ,"+
                col_PHONE +" TEXT ," +
                col_COUNRTY +" TEXT ,"+
                col_aug   + " INTEGER ,"+
                col_sep   + " INTEGER ,"+
                col_oct   + " INTEGER ,"+
                col_nov   + " INTEGER ,"+
                col_dec   + " INTEGER ,"+
                col_jan   + " INTEGER ,"+
                col_feb   + " INTEGER ,"+
                col_mar   + " INTEGER ,"+
                col_apr   + " INTEGER ,"+
                col_may   + " INTEGER ,"+
                col_note1 + " INTEGER ,"+
                col_note2 + " INTEGER ,"+
                col_rev1  + " INTEGER ,"+
                col_rev2  + " INTEGER "+
                ")";
        db.execSQL(CREATE_TABLE_Grade1);
        db.execSQL(CREATE_TABLE_Grade2);
        db.execSQL(CREATE_TABLE_Grade3);
        db.execSQL(CREATE_TABLE_GradeP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Grade1);
        db.execSQL("DROP TABLE IF EXISTS "+Table_Grade2);
        db.execSQL("DROP TABLE IF EXISTS "+Table_Grade3);
        db.execSQL("DROP TABLE IF EXISTS "+Table_GradeP);
        onCreate(db);
    }

    void add_student(int activity_num , String student_name , String student_phone , String student_country ,
                     int mt_aug , int mt_sep , int mt_oct , int mt_nov , int mt_dec,
                     int mt_jan , int mt_feb , int mt_mar , int mt_apr , int mt_may,
                     int note1  , int note2  , int rev1   , int rev2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(col_NAME, student_name);
        cv.put(col_PHONE, student_phone);
        cv.put(col_COUNRTY,student_country);
        cv.put(col_aug,mt_aug);             cv.put(col_sep,mt_sep);
        cv.put(col_oct,mt_oct);             cv.put(col_nov,mt_nov);
        cv.put(col_dec,mt_dec);             cv.put(col_jan,mt_jan);
        cv.put(col_feb,mt_feb);             cv.put(col_mar,mt_mar);
        cv.put(col_apr,mt_apr);             cv.put(col_may,mt_may);
        cv.put(col_note1,note1);              cv.put(col_note2,note2);
        cv.put(col_rev1,rev1);               cv.put(col_rev2,rev2);

        long result =0;
        if (activity_num == 1){ result = db.insert(Table_Grade1, null, cv);}
        if (activity_num == 2){ result = db.insert(Table_Grade2, null, cv);}
        if (activity_num == 3){ result = db.insert(Table_Grade3, null, cv);}
        if (activity_num == 4){ result = db.insert(Table_GradeP, null, cv);}


            if (result == -1) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            } else {
                FancyToast.makeText(context, "Added Successfully!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
            }

    }

    Cursor readalldata(int activity_num , String area){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        if (area == "All"){
            if (db !=null ){
                if (activity_num ==1)     {cursor = db.rawQuery("SELECT * FROM "+Table_Grade1,null);}
                else if (activity_num ==2){cursor = db.rawQuery("SELECT * FROM "+Table_Grade2,null);}
                else if (activity_num ==3){cursor = db.rawQuery("SELECT * FROM "+Table_Grade3,null);}
                else if (activity_num ==4){cursor = db.rawQuery("SELECT * FROM "+Table_GradeP,null);}
            }
        }
        else {
            if (db !=null ){
                if (activity_num ==1)     {cursor = db.rawQuery("SELECT * FROM "+Table_Grade1+" WHERE "+col_COUNRTY+" = '"+area+"'",null);}
                else if (activity_num ==2){cursor = db.rawQuery("SELECT * FROM "+Table_Grade2+" WHERE "+col_COUNRTY+" = '"+area+"'",null);}
                else if (activity_num ==3){cursor = db.rawQuery("SELECT * FROM "+Table_Grade3+" WHERE "+col_COUNRTY+" = '"+area+"'",null);}
                else if (activity_num ==4){cursor = db.rawQuery("SELECT * FROM "+Table_GradeP+" WHERE "+col_COUNRTY+" = '"+area+"'",null);}
            }
        }

        return cursor;
    }



    /* Need Edit for table 2 >> 3 >> P >>  from here  */
    void updateData(String row_id, String student_name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_NAME, student_name);

        long result = db.update(Table_Grade1, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(Table_Grade1, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }
    /*              to here         */


    void deleteAllData(int activity_num ){
        SQLiteDatabase db = this.getWritableDatabase();
        if (activity_num ==1)     {db.execSQL("Drop TABLE IF EXISTS "+Table_Grade1);}
        else if (activity_num ==2){db.execSQL("Drop TABLE IF EXISTS "+Table_Grade2);}
        else if (activity_num ==3){db.execSQL("Drop TABLE IF EXISTS "+Table_Grade3);}
        else if (activity_num ==4){db.execSQL("Drop TABLE IF EXISTS "+Table_GradeP);}

        onCreate(db);
    }

}