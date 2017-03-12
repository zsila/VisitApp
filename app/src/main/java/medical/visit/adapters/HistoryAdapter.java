package medical.visit.adapters;
import medical.visit.obj.*;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.EditText;

public class HistoryAdapter {

 public static final String MYDATABASE_NAME = "PATIENTS";
 public static final String MYDATABASE_TABLE = "HISTORY";
 public static final int MYDATABASE_VERSION = 1;
 public static final String KEY_ID = "id";
 public static final String KEY_PID= "pid";
 public static final String KEY_NAME = "Name";
 public static final String KEY_DATE = "Date";
 public static final String KEY_PROTOCOL = "Protocol"; 
 public static final String KEY_REASON = "Reason";
 public static final String KEY_START = "Starting";
 public static final String KEY_INTAN = "IntanIll";
 public static final String KEY_OTHER = "OtherIll";
 public static final String KEY_OPERATIONS = "Operations";
 public static final String KEY_MOTHERILL = "MotherIll";
 public static final String KEY_FATHERILL = "FatherIll";
 public static final String KEY_SIBLINGILL = "SiblingIll";  
 


 
 private static final String SCRIPT_CREATE_DATABASE =  "create table " + MYDATABASE_TABLE
		 + " (" + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_PID + "," + KEY_NAME + "," + KEY_DATE  
		 + "," +KEY_PROTOCOL + "," +  KEY_REASON + "," + KEY_START + "," +KEY_INTAN + "," + KEY_OTHER + "," 
		 + KEY_OPERATIONS + "," +  KEY_MOTHERILL + "," +KEY_FATHERILL + "," +KEY_SIBLINGILL + ");";
 

 private SQLiteHelper sqLiteHelper;
 private SQLiteDatabase sqLiteDatabase;

 private Context context;
 
 public HistoryAdapter(Context c){
  context = c;
 }
 
 public HistoryAdapter openToRead() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
  sqLiteDatabase = sqLiteHelper.getReadableDatabase();
  return this; 
 }
 
 public HistoryAdapter openToWrite() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
  sqLiteDatabase = sqLiteHelper.getWritableDatabase();
  return this; 
 }
 
 public void close(){
  sqLiteHelper.close();
 }
 
 public long insert(HistObj content){
  
  ContentValues contentValues = new ContentValues();

  contentValues.put(KEY_PID, content.pid);
  contentValues.put(KEY_NAME, content.name);
  contentValues.put(KEY_DATE, content.date);
  contentValues.put(KEY_PROTOCOL, content.protocol);
  contentValues.put(KEY_REASON, content.reason);
  contentValues.put(KEY_START, content.start);
  contentValues.put(KEY_INTAN, content.intan);
  contentValues.put(KEY_OTHER, content.other);
  contentValues.put(KEY_OPERATIONS, content.operations);
  contentValues.put(KEY_MOTHERILL, content.motherIll);
  contentValues.put(KEY_FATHERILL, content.fatherIll);
  contentValues.put(KEY_SIBLINGILL, content.siblingIll);
  
  return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
 }
 
 public int deleteAll(){
  return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
 }
 
 public ArrayList<HistObj> queueAll(ArrayList<HistObj> list){
  String[] columns = new String[]{KEY_NAME, KEY_DATE, KEY_PROTOCOL, KEY_REASON, KEY_START, KEY_INTAN, KEY_OTHER, 
		  KEY_OPERATIONS, KEY_MOTHERILL, KEY_FATHERILL, KEY_SIBLINGILL};
//  ArrayList<String> temp = null;
  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, null, null, null, null, null, null);
  
//  int index_ID = cursor.getColumnIndex(KEY_ID);
  int index_NAME = cursor.getColumnIndex(KEY_NAME);
  int index_DATE = cursor.getColumnIndex(KEY_DATE);
  int index_PROTOCOL = cursor.getColumnIndex(KEY_PROTOCOL);
  int index_REASON = cursor.getColumnIndex(KEY_REASON);
  int index_START = cursor.getColumnIndex(KEY_START);
  int index_INTAN = cursor.getColumnIndex(KEY_INTAN);
  int index_OTHER = cursor.getColumnIndex(KEY_OTHER);
  int index_OPERTAIONS = cursor.getColumnIndex(KEY_OPERATIONS);
  int index_MOTHERILL = cursor.getColumnIndex(KEY_MOTHERILL);
  int index_FATHERILL = cursor.getColumnIndex(KEY_FATHERILL);
  int index_SIBLINGILL = cursor.getColumnIndex(KEY_SIBLINGILL);
  
    
  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
	  HistObj result = new HistObj();
   
//   result.id = cursor.getString(index_ID) + "\n";
   result.name = cursor.getString(index_NAME);
   result.date = cursor.getString(index_DATE);
   result.protocol = cursor.getString(index_PROTOCOL);
   result.reason = cursor.getString(index_REASON);
   result.start = cursor.getString(index_START);
   result.intan = cursor.getString(index_INTAN);
   result.other = cursor.getString(index_OTHER);
   result.operations = cursor.getString(index_OPERTAIONS);
   result.motherIll = cursor.getString(index_MOTHERILL);
   result.fatherIll = cursor.getString(index_FATHERILL);
   result.siblingIll = cursor.getString(index_SIBLINGILL);
   
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