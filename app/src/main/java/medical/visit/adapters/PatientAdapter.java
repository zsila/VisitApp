package medical.visit.adapters;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class PatientAdapter {

 public static final String MYDATABASE_NAME = "MY_DATABASE";
 public static final String MYDATABASE_TABLE = "MY_TABLE";
 public static final int MYDATABASE_VERSION = 1;
 public static final String KEY_CONTENT = "Content";
 
 
 public static final String ROW_ID = "_id";
 public static final String NAME = "name";
 public static final String BIRTH_DATE = "birth_date";
 public static final String BIRTH_PLACE = "birth_place";
 public static final String GENDER = "gender";
 public static final String MAR_STAT = "mar_stat";
 public static final String FAT_NAME = "fat_name";
 public static final String MOT_NAME = "mot_name";
 public static final String ADDRESS = "address";
 public static final String PHONE = "phone";
 public static final String BLOOD = "blood";
 public static final String RELATIVE_INFO = "relative_info";
 public static final String SPECIAL_COND = "special_cond"; 

 //create table MY_DATABASE (ID integer primary key, Content text not null);
 private static final String SCRIPT_CREATE_DATABASE =  "create table " + MYDATABASE_TABLE + " ("  + KEY_CONTENT + " text not null);";
 
 private SQLiteHelper sqLiteHelper;
 private SQLiteDatabase sqLiteDatabase;

 private Context context;
 
 public PatientAdapter(Context c){
  context = c;
 }
 
 public PatientAdapter openToRead() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
  sqLiteDatabase = sqLiteHelper.getReadableDatabase();
  return this; 
 }
 
 public PatientAdapter openToWrite() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
  sqLiteDatabase = sqLiteHelper.getWritableDatabase();
  return this; 
 }
 
 public void close(){
  sqLiteHelper.close();
 }
 
 public long insert(String content){
  
  ContentValues contentValues = new ContentValues();
  contentValues.put(KEY_CONTENT, content);
  return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
 }
 
 public int deleteAll(){
  return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
 }
 
 public ArrayList<String> queueAll(ArrayList<String> list){
  String[] columns = new String[]{KEY_CONTENT};
//  ArrayList<String> temp = null;
  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, null, null, null, null, null);
  String result = " ";
  
  int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);
  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
   result = cursor.getString(index_CONTENT) + "\n";
   list.add(result);
  }
 
  return list;
 }
 
 public class SQLiteHelper extends SQLiteOpenHelper {

  public SQLiteHelper(Context context, String name,
    CursorFactory factory, int version) {
   super(context, name, factory, version);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
   // TODO Auto-generated method stub
   //db.execSQL(SCRIPT_CREATE_DATABASE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   // TODO Auto-generated method stub

  }

 }
 
}