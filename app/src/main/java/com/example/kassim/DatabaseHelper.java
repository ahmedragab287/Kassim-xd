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
    private static final String col_private_price = "private_price";
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
                col_rev2  + " INTEGER ,"+
                col_private_price + " INTEGER " +
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


     public int count(int activity_num) {
        int student_count = 0; String sql = "";

        if (activity_num == 1) { sql = "SELECT COUNT(*) FROM " + Table_Grade1;}
        else if (activity_num == 2){ sql = "SELECT COUNT(*) FROM " + Table_Grade2; }
        else if (activity_num == 3){ sql = "SELECT COUNT(*) FROM " + Table_Grade3; }
        else if (activity_num == 4){ sql = "SELECT COUNT(*) FROM " + Table_GradeP; }

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            student_count = cursor.getInt(0);
        }

        cursor.close();
        return student_count;
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


    void updateData(int activity_num ,String row_id, String student_name , String student_phone  ,
                    int mt_aug , int mt_sep , int mt_oct , int mt_nov , int mt_dec,
                    int mt_jan , int mt_feb , int mt_mar , int mt_apr , int mt_may,
                    int note1  , int note2  , int rev1   , int rev2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_NAME, student_name);
        cv.put(col_PHONE, student_phone);
        //cv.put(col_PHONE, student_phone);
        cv.put(col_aug, mt_aug);
        cv.put(col_sep, mt_sep);
        cv.put(col_oct, mt_oct);
        cv.put(col_nov, mt_nov);
        cv.put(col_dec, mt_dec);
        cv.put(col_jan, mt_jan);
        cv.put(col_feb, mt_feb);
        cv.put(col_mar, mt_mar);
        cv.put(col_apr, mt_apr);
        cv.put(col_may, mt_may);
        cv.put(col_note1, note1);
        cv.put(col_note2, note2);
        cv.put(col_rev1, rev1);
        cv.put(col_rev2, rev2);

        long result = 0;

        if (activity_num == 1){
            result = db.update(Table_Grade1, cv, ID+"=?", new String[]{row_id});
        }
        else if(activity_num == 2){
            result = db.update(Table_Grade2, cv, ID+"=?", new String[]{row_id});
        }
        else if(activity_num == 3){
            result = db.update(Table_Grade3, cv, ID+"=?", new String[]{row_id});
        }
        else if(activity_num == 4){
            result = db.update(Table_GradeP, cv, ID+"=?", new String[]{row_id});
        }



        if(result == -1){ Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show(); }
        else { Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show(); }

    }

    void deleteOneRow(String row_id , int activity_num){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = -1;
        if (activity_num == 1){
            result = db.delete(Table_Grade1, ID +"=?",new String[]{row_id});
        }
        else if  (activity_num == 2) {
            result = db.delete(Table_Grade2, ID +"=?",new String[]{row_id});
        }
        else if (activity_num == 3){
            result = db.delete(Table_Grade3, ID +"=?",new String[]{row_id});
        }
        else if (activity_num  == 4){
            result = db.delete(Table_GradeP, ID +"=?",new String[]{row_id});
        }


        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(int activity_num ){
        SQLiteDatabase db = this.getWritableDatabase();
        if (activity_num ==1)     {db.execSQL("Drop TABLE IF EXISTS "+Table_Grade1);}
        else if (activity_num ==2){db.execSQL("Drop TABLE IF EXISTS "+Table_Grade2);}
        else if (activity_num ==3){db.execSQL("Drop TABLE IF EXISTS "+Table_Grade3);}
        else if (activity_num ==4){db.execSQL("Drop TABLE IF EXISTS "+Table_GradeP);}

        onCreate(db);
    }

    int checkbox(int activity_num , int id , String month){

        String query = "" ;
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();

        if (activity_num == 1) {
            if (month.equals("aug")){
                query = "SELECT "+ col_aug +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_aug));
                }
                csr.close();
            }
            if (month.equals("sep")){
                query = "SELECT "+ col_sep +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_sep));
                }
                csr.close();
            }
            if (month.equals("oct")){
                query = "SELECT "+ col_oct +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_oct));
                }
                csr.close();
            }
            if (month.equals("nov")){
                query = "SELECT "+ col_nov +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_nov));
                }
                csr.close();
            }
            if (month.equals("dec")){
                query = "SELECT "+ col_dec +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_dec));
                }
                csr.close();
            }
            if (month.equals("note1")){
                query = "SELECT "+ col_note1 +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_note1));
                }
                csr.close();
            }
            if (month.equals("rev1")){
                query = "SELECT "+ col_rev1 +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_rev1));
                }
                csr.close();
            }
            if (month.equals("jan")){
                query = "SELECT "+ col_jan +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_jan));
                }
                csr.close();
            }
            if (month.equals("feb")){
                query = "SELECT "+ col_feb +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_feb));
                }
                csr.close();
            }
            if (month.equals("mar")){
                query = "SELECT "+ col_mar +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_mar));
                }
                csr.close();
            }
            if (month.equals("apr")){
                query = "SELECT "+ col_apr +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_apr));
                }
                csr.close();
            }
            if (month.equals("may")){
                query = "SELECT "+ col_may +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_may));
                }
                csr.close();
            }
            if (month.equals("note2")){
                query = "SELECT "+ col_note2 +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_note2));
                }
                csr.close();
            }
            if (month.equals("rev2")){
                query = "SELECT "+ col_rev2 +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_rev2));
                }
                csr.close();
            }

        }
        else if (activity_num == 2){
            if (month.equals("aug")){
                query = "SELECT "+ col_aug +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_aug));
                }
                csr.close();
            }
            if (month.equals("sep")){
                query = "SELECT "+ col_sep +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_sep));
                }
                csr.close();
            }
            if (month.equals("oct")){
                query = "SELECT "+ col_oct +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_oct));
                }
                csr.close();
            }
            if (month.equals("nov")){
                query = "SELECT "+ col_nov +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_nov));
                }
                csr.close();
            }
            if (month.equals("dec")){
                query = "SELECT "+ col_dec +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_dec));
                }
                csr.close();
            }
            if (month.equals("note1")){
                query = "SELECT "+ col_note1 +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_note1));
                }
                csr.close();
            }
            if (month.equals("rev1")){
                query = "SELECT "+ col_rev1 +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_rev1));
                }
                csr.close();
            }
            if (month.equals("jan")){
                query = "SELECT "+ col_jan +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_jan));
                }
                csr.close();
            }
            if (month.equals("feb")){
                query = "SELECT "+ col_feb +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_feb));
                }
                csr.close();
            }
            if (month.equals("mar")){
                query = "SELECT "+ col_mar +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_mar));
                }
                csr.close();
            }
            if (month.equals("apr")){
                query = "SELECT "+ col_apr +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_apr));
                }
                csr.close();
            }
            if (month.equals("may")){
                query = "SELECT "+ col_may +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_may));
                }
                csr.close();
            }
            if (month.equals("note2")){
                query = "SELECT "+ col_note2 +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_note2));
                }
                csr.close();
            }
            if (month.equals("rev2")){
                query = "SELECT "+ col_rev2 +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_rev2));
                }
                csr.close();
            }
        }
        else if (activity_num == 3){
            if (month.equals("aug")){
                query = "SELECT "+ col_aug +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_aug));
                }
                csr.close();
            }
            if (month.equals("sep")){
                query = "SELECT "+ col_sep +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_sep));
                }
                csr.close();
            }
            if (month.equals("oct")){
                query = "SELECT "+ col_oct +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_oct));
                }
                csr.close();
            }
            if (month.equals("nov")){
                query = "SELECT "+ col_nov +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_nov));
                }
                csr.close();
            }
            if (month.equals("dec")){
                query = "SELECT "+ col_dec +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_dec));
                }
                csr.close();
            }
            if (month.equals("note1")){
                query = "SELECT "+ col_note1 +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_note1));
                }
                csr.close();
            }
            if (month.equals("rev1")){
                query = "SELECT "+ col_rev1 +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_rev1));
                }
                csr.close();
            }
            if (month.equals("jan")){
                query = "SELECT "+ col_jan +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_jan));
                }
                csr.close();
            }
            if (month.equals("feb")){
                query = "SELECT "+ col_feb +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_feb));
                }
                csr.close();
            }
            if (month.equals("mar")){
                query = "SELECT "+ col_mar +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_mar));
                }
                csr.close();
            }
            if (month.equals("apr")){
                query = "SELECT "+ col_apr +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_apr));
                }
                csr.close();
            }
            if (month.equals("may")){
                query = "SELECT "+ col_may +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_may));
                }
                csr.close();
            }
            if (month.equals("note2")){
                query = "SELECT "+ col_note2 +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_note2));
                }
                csr.close();
            }
            if (month.equals("rev2")){
                query = "SELECT "+ col_rev2 +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_rev2));
                }
                csr.close();
            }
        }
        else if (activity_num == 4){
            if (month.equals("aug")){
                query = "SELECT "+ col_aug +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_aug));
                }
                csr.close();
            }
            if (month.equals("sep")){
                query = "SELECT "+ col_sep +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_sep));
                }
                csr.close();
            }
            if (month.equals("oct")){
                query = "SELECT "+ col_oct +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_oct));
                }
                csr.close();
            }
            if (month.equals("nov")){
                query = "SELECT "+ col_nov +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_nov));
                }
                csr.close();
            }
            if (month.equals("dec")){
                query = "SELECT "+ col_dec +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_dec));
                }
                csr.close();
            }
            if (month.equals("note1")){
                query = "SELECT "+ col_note1 +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_note1));
                }
                csr.close();
            }
            if (month.equals("rev1")){
                query = "SELECT "+ col_rev1 +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_rev1));
                }
                csr.close();
            }
            if (month.equals("jan")){
                query = "SELECT "+ col_jan +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_jan));
                }
                csr.close();
            }
            if (month.equals("feb")){
                query = "SELECT "+ col_feb +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_feb));
                }
                csr.close();
            }
            if (month.equals("mar")){
                query = "SELECT "+ col_mar +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_mar));
                }
                csr.close();
            }
            if (month.equals("apr")){
                query = "SELECT "+ col_apr +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_apr));
                }
                csr.close();
            }
            if (month.equals("may")){
                query = "SELECT "+ col_may +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_may));
                }
                csr.close();
            }
            if (month.equals("note2")){
                query = "SELECT "+ col_note2 +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_note2));
                }
                csr.close();
            }
            if (month.equals("rev2")){
                query = "SELECT "+ col_rev2 +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";

                Cursor csr = db.rawQuery(query,null);
                if (csr.moveToFirst()) {
                    result = csr.getInt(csr.getColumnIndex(col_rev2));
                }
                csr.close();
            }
        }

        return result;
    }

    String get_student_phone(int activity_num , int id ){

        String phone = "";
        SQLiteDatabase db = this.getReadableDatabase();

        if (activity_num == 1){
            String query = "SELECT "+ col_PHONE +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";
            Cursor csr = db.rawQuery(query,null);
            if (csr.moveToFirst()) {
                phone = csr.getString(csr.getColumnIndex(col_PHONE));
            }
            csr.close();
        }
        else if(activity_num == 2){
            String query = "SELECT "+ col_PHONE +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";
            Cursor csr = db.rawQuery(query,null);
            if (csr.moveToFirst()) {
                phone = csr.getString(csr.getColumnIndex(col_PHONE));
            }
            csr.close();
        }
        else if (activity_num == 3){
            String query = "SELECT "+ col_PHONE +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";
            Cursor csr = db.rawQuery(query,null);
            if (csr.moveToFirst()) {
                phone = csr.getString(csr.getColumnIndex(col_PHONE));
            }
            csr.close();
        }
        else if (activity_num ==4){
            String query = "SELECT "+ col_PHONE +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";
            Cursor csr = db.rawQuery(query,null);
            if (csr.moveToFirst()) {
                phone = csr.getString(csr.getColumnIndex(col_PHONE));
            }
            csr.close();
        }

        return  phone;
    }

    String get_student_country(int activity_num , int id ){

        String country = "";
        SQLiteDatabase db = this.getReadableDatabase();

        if (activity_num == 1){
            String query = "SELECT "+ col_COUNRTY +" FROM " + Table_Grade1 +" WHERE "+ID + "='"+id+"'";
            Cursor csr = db.rawQuery(query,null);
            if (csr.moveToFirst()) {
                country = csr.getString(csr.getColumnIndex(col_COUNRTY));
            }
            csr.close();
        }
        else if(activity_num == 2){
            String query = "SELECT "+ col_COUNRTY +" FROM " + Table_Grade2 +" WHERE "+ID + "='"+id+"'";
            Cursor csr = db.rawQuery(query,null);
            if (csr.moveToFirst()) {
                country = csr.getString(csr.getColumnIndex(col_COUNRTY));
            }
            csr.close();
        }
        else if (activity_num == 3){
            String query = "SELECT "+ col_COUNRTY +" FROM " + Table_Grade3 +" WHERE "+ID + "='"+id+"'";
            Cursor csr = db.rawQuery(query,null);
            if (csr.moveToFirst()) {
                country = csr.getString(csr.getColumnIndex(col_COUNRTY));
            }
            csr.close();
        }
        else if (activity_num ==4){
            String query = "SELECT "+ col_COUNRTY +" FROM " + Table_GradeP +" WHERE "+ID + "='"+id+"'";
            Cursor csr = db.rawQuery(query,null);
            if (csr.moveToFirst()) {
                country = csr.getString(csr.getColumnIndex(col_COUNRTY));
            }
            csr.close();
        }

        return  country;
    }


}