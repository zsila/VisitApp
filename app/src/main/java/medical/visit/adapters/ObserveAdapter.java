package medical.visit.adapters;

import medical.visit.obj.*;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class ObserveAdapter {

 public static final String MYDATABASE_NAME = "PATIENTS";
 public static final String MYDATABASE_TABLE = "OBSERVATION";
 public static final int MYDATABASE_VERSION = 1;
 public static final String KEY_CONTENT = "Content";
 public static final String KEY_ID = "id";
 public static final String KEY_PID= "pid";

 
 private static final String SCRIPT_CREATE_DATABASE =  "create table " + MYDATABASE_TABLE + " (" + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +KEY_PID +"," + KEY_CONTENT +  ");";
 

 private SQLiteHelper sqLiteHelper;
 private SQLiteDatabase sqLiteDatabase;

 private Context context;  
 
 public ObserveAdapter(Context c){
  context = c;
 }
 
 public ObserveAdapter openToRead() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
  sqLiteDatabase = sqLiteHelper.getReadableDatabase();
  return this; 
 }
 
 public ObserveAdapter openToWrite() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
  sqLiteDatabase = sqLiteHelper.getWritableDatabase();
  return this; 
 }
 
 public void close(){
  sqLiteHelper.close();
 }
 
 public long insert(ObsItem obsItem){
  
  ContentValues contentValues = new ContentValues();
  contentValues.put(KEY_PID, obsItem.pid);
  contentValues.put(KEY_CONTENT, obsItem.obs);
  
  return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
 }
 
 
 
 public String getRow(){
	 String questionval;
	 Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM " + MYDATABASE_TABLE , null);
	 
	 questionval = c.getString(c.getColumnIndex(KEY_CONTENT));
	 
	 return questionval;
	 }
 
 
 
 public int deleteAll(){
  return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
 }
 
 public ArrayList<String> queueAll(ArrayList<String> list){
  String[] columns = new String[]{KEY_CONTENT};
//  ArrayList<String> temp = null;
  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, null, null, null, null, null, null);  
  
  int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);  
  
  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
   String result = "";
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
