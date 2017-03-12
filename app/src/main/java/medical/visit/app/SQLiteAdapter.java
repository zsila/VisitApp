package medical.visit.app;
import medical.visit.obj.*;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class SQLiteAdapter {

 public static final String MYDATABASE_NAME = "PATIENTS";
 public static final String MYDATABASE_TABLE = "PATIENTID";
 public static final String MYDATABASE_TABLE_OBS = "OBSERVATION";
 public static final String MYDATABASE_TABLE_HIST = "HISTORY";
 public static final int MYDATABASE_VERSION = 1;
 public static final String KEY_ID = "id";
 public static final String KEY_NAME = "Name";
 public static final String KEY_BP = "BirthP";
 public static final String KEY_BD = "BirthD";
 public static final String KEY_GENDER = "Gender";
 public static final String KEY_MARSTAT = "Mar_Stat";
 public static final String KEY_FN = "FatherName";
 public static final String KEY_MN = "MotherName";
 public static final String KEY_ADDRESS = "Address";
 public static final String KEY_PHONE = "PhoneNo";
 public static final String KEY_BLOOD = "BloodType";  
 public static final String KEY_REL_INFO = "RelativeInfo";
 public static final String KEY_SPECIALCASE = "SpecialCase";

 public static final String KEY_PID = "Pid";
 public static final String KEY_CONTENT = "Content";
 

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
 
 private static final String SCRIPT_CREATE_DATABASE =  "create table " + MYDATABASE_TABLE + 
		 " (" + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + "," + KEY_BP  
		 + "," +KEY_BD + "," +  KEY_GENDER + "," + KEY_MARSTAT + "," +KEY_FN + "," + KEY_MN + "," 
		 + KEY_ADDRESS + "," +  KEY_PHONE + "," +KEY_BLOOD + "," +KEY_REL_INFO  + "," +KEY_SPECIALCASE + ");";
 
 private static final String SCRIPT_CREATE_OBS =  "create table " + MYDATABASE_TABLE_OBS + 
		 " (" + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +KEY_PID +" integer," + KEY_CONTENT +  ");";

 private static final String SCRIPT_CREATE_HIST =  "create table " + MYDATABASE_TABLE_HIST + 
		 " (" + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +KEY_PID +" integer,"+ KEY_NAME + "," + KEY_DATE  
		 + "," +KEY_PROTOCOL + "," +  KEY_REASON + "," + KEY_START + "," +KEY_INTAN + "," + KEY_OTHER + "," 
		 + KEY_OPERATIONS + "," +  KEY_MOTHERILL + "," +KEY_FATHERILL + "," +KEY_SIBLINGILL + ");";
 
 
 private SQLiteHelper sqLiteHelper;
 private SQLiteDatabase sqLiteDatabase;

 private Context context;
 
 public SQLiteAdapter(Context c){
  context = c;
 }
 
 public SQLiteAdapter openToRead() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
  sqLiteDatabase = sqLiteHelper.getReadableDatabase();
  return this; 
 }
 
 public SQLiteAdapter openToWrite() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
  sqLiteDatabase = sqLiteHelper.getWritableDatabase();
  return this; 
 }
 
 public void close(){
  sqLiteHelper.close();
 }
 
 public long insert(Patient content){
  
  ContentValues contentValues = new ContentValues();

//  contentValues.put(KEY_ID, content.id);
  contentValues.put(KEY_NAME, content.name);
  contentValues.put(KEY_BP, content.birth_place);
  contentValues.put(KEY_BD, content.birth_date);
  contentValues.put(KEY_GENDER, content.gender);
  contentValues.put(KEY_MARSTAT, content.mar_stat);
  contentValues.put(KEY_FN, content.fat_name);
  contentValues.put(KEY_MN, content.mot_name);
  contentValues.put(KEY_ADDRESS, content.address);  
  contentValues.put(KEY_PHONE, content.phone);
  contentValues.put(KEY_BLOOD, content.blood);
  contentValues.put(KEY_REL_INFO, content.rel_info);
  contentValues.put(KEY_SPECIALCASE, content.spec_case);
  
  return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
 }
 
 public long update(Patient content){
	  
	  ContentValues contentValues = new ContentValues();

	//  contentValues.put(KEY_ID, content.id);
	  contentValues.put(KEY_NAME, content.name);
	  contentValues.put(KEY_BP, content.birth_place);
	  contentValues.put(KEY_BD, content.birth_date);
	  contentValues.put(KEY_GENDER, content.gender);
	  contentValues.put(KEY_MARSTAT, content.mar_stat);
	  contentValues.put(KEY_FN, content.fat_name);
	  contentValues.put(KEY_MN, content.mot_name);
	  contentValues.put(KEY_ADDRESS, content.address);  
	  contentValues.put(KEY_PHONE, content.phone);
	  contentValues.put(KEY_BLOOD, content.blood);
	  contentValues.put(KEY_REL_INFO, content.rel_info);
	  contentValues.put(KEY_SPECIALCASE, content.spec_case);
	  
	  return sqLiteDatabase.update(MYDATABASE_TABLE, contentValues, KEY_ID+"=?", new String[]{String.valueOf(content.id)});
	 }
 
 public int deleteAll(){
  return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
 }
 
 public int dropTable() {
	 sqLiteDatabase.rawQuery("drop table " + MYDATABASE_TABLE, null);
	 return 0;
 }
 
 /*public int createTable() {
	 sqLiteDatabase.rawQuery(SCRIPT_CREATE_DATABASE, null);
	 return 0;
 }*/
 
 /*public int selectPatient() {
	 sqLiteDatabase.rawQuery("SELECT " + KEY_ID + " FROM " + MYDATABASE_TABLE + " WHERE ", selectionArgs)
 }*/
 
 public ArrayList<Patient> queueAll(ArrayList<Patient> list){
//  String[] columns = new String[]{KEY_NAME, KEY_BP, KEY_BD, KEY_GENDER, KEY_MARSTAT, KEY_FN, KEY_MN, KEY_ADDRESS, KEY_PHONE, KEY_BLOOD, KEY_REL_INFO, KEY_SPECIALCASE};
//  ArrayList<String> temp = null;
  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, null, null, null, null, null, null);
  
  int index_ID = cursor.getColumnIndex(KEY_ID);
  int index_NAME = cursor.getColumnIndex(KEY_NAME);
  int index_BP = cursor.getColumnIndex(KEY_BP);
  int index_BD = cursor.getColumnIndex(KEY_BD);
  int index_GENDER = cursor.getColumnIndex(KEY_GENDER);
  int index_MARSTAT = cursor.getColumnIndex(KEY_MARSTAT);
  int index_FN = cursor.getColumnIndex(KEY_FN);
  int index_MN = cursor.getColumnIndex(KEY_MN);
  int index_ADDRESS = cursor.getColumnIndex(KEY_ADDRESS);
  int index_PHONE = cursor.getColumnIndex(KEY_PHONE);
  int index_BLOOD = cursor.getColumnIndex(KEY_BLOOD);
  int index_RELINFO = cursor.getColumnIndex(KEY_REL_INFO);
  int index_SPECASE = cursor.getColumnIndex(KEY_SPECIALCASE);
    
    
  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
	  Patient result = new Patient();
   
   result.id = cursor.getInt(index_ID);
   result.name = cursor.getString(index_NAME);
   result.birth_place = cursor.getString(index_BP);
   result.birth_date = cursor.getString(index_BD);
   result.gender = cursor.getString(index_GENDER);
   result.mar_stat = cursor.getString(index_MARSTAT);
   result.fat_name = cursor.getString(index_FN);
   result.mot_name = cursor.getString(index_MN);
   result.address = cursor.getString(index_ADDRESS);
   result.phone = cursor.getString(index_PHONE);
   result.blood = cursor.getString(index_BLOOD);
   result.rel_info = cursor.getString(index_RELINFO);
   result.spec_case = cursor.getString(index_SPECASE);
   
   list.add(result);
  }
 
  return list;
 }
 
 /*
  * Sends a query to get observations for patients
  */
 public String queryObservation(int pid){
	 
	  String spid = String.valueOf(pid);
	  String q = "select * from " + MYDATABASE_TABLE_OBS + " where " + KEY_PID + "=" + spid;
	  Cursor cursor = sqLiteDatabase.rawQuery(q, null);
//	  Cursor myCursor = sqLiteDatabase.query(MYDATABASE_TABLE_OBS,new String[]{KEY_CONTENT},KEY_PID+"=?",
//			  new String[]{spid},null,null,null,null);
//	  Cursor yourCursor = sqLiteDatabase.query(MYDATABASE_TABLE_OBS, null, null, null, null, null, null);
	  
//	  int index_ID = cursor.getColumnIndex(KEY_ID);
//	  int index_PID = cursor.getColumnIndex(KEY_PID);
	  int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);
	  
	    String obs = "";
	  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		  
		   obs = cursor.getString(index_CONTENT);
	  }
	 return obs;
	 }
 
 public HistObj queryHistory(int pid){
	 
	  String spid = String.valueOf(pid);
	  String q = "select * from " + MYDATABASE_TABLE_HIST + " where " + KEY_PID + "=" + spid;
	  Cursor cursor = sqLiteDatabase.rawQuery(q, null);
//	  Cursor yourCursor = sqLiteDatabase.query(MYDATABASE_TABLE_HIST, null, null, null, null, null, null);
//	  
	  int index_ID = cursor.getColumnIndex(KEY_ID);
//	  int index_PID = cursor.getColumnIndex(KEY_PID);
	  
	  int index_NAME = cursor.getColumnIndex(KEY_NAME);
	  int index_DATE = cursor.getColumnIndex(KEY_DATE);
	  int index_PROTOCOL = cursor.getColumnIndex(KEY_PROTOCOL);
	  int index_REASON = cursor.getColumnIndex(KEY_REASON);
	  int index_START = cursor.getColumnIndex(KEY_START);
	  int index_INTAN = cursor.getColumnIndex(KEY_INTAN);
	  int index_OTHER = cursor.getColumnIndex(KEY_OTHER);
	  int index_OPERATIONS = cursor.getColumnIndex(KEY_OPERATIONS);
	  int index_MOTHERILL = cursor.getColumnIndex(KEY_MOTHERILL);
	  int index_FATHERILL = cursor.getColumnIndex(KEY_FATHERILL);
	  int index_SIBLINGILL = cursor.getColumnIndex(KEY_SIBLINGILL);
	  
	  HistObj result = new HistObj();
	  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		  result.id = cursor.getInt(index_ID);
		  result.name = cursor.getString(index_NAME);
		   result.date = cursor.getString(index_DATE);
		   result.protocol = cursor.getString(index_PROTOCOL);
		   result.reason = cursor.getString(index_REASON);
		   result.start = cursor.getString(index_START);
		   result.intan = cursor.getString(index_INTAN);
		   result.other = cursor.getString(index_OTHER);
		   result.operations = cursor.getString(index_OPERATIONS);
		   result.motherIll = cursor.getString(index_MOTHERILL);
		   result.fatherIll = cursor.getString(index_FATHERILL);
		   result.siblingIll = cursor.getString(index_SIBLINGILL);	   		   
	  }
	 return result;
	 }
 
 
 public ArrayList<ObsItem> queryObservations(ArrayList<ObsItem> observationList){

	  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE_OBS, null, null, null, null, null, null);	  
	  int index_ID = cursor.getColumnIndex(KEY_ID);
	  int index_PID = cursor.getColumnIndex(KEY_PID);
	  int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);
	  
	    
	  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		  
		  ObsItem observation = new ObsItem();
		   
		  observation.id = cursor.getInt(index_ID);
		  observation.pid = cursor.getInt(index_PID);
		  observation.obs = cursor.getString(index_CONTENT);
		     
		  observationList.add(observation);
	  }
	 
	  return observationList;
	 }
 
 public class SQLiteHelper extends SQLiteOpenHelper {

  public SQLiteHelper(Context context, String name,
    CursorFactory factory, int version) {
   super(context, name, factory, version);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
   // TODO Auto-generated method stub
   db.execSQL(SCRIPT_CREATE_DATABASE);
   db.execSQL(SCRIPT_CREATE_OBS);
   db.execSQL(SCRIPT_CREATE_HIST);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   // TODO Auto-generated method stub
	  //db.execSQL("drop table "+MYDATABASE_TABLE);
	  //db.execSQL(SCRIPT_CREATE_DATABASE);
	  Log.e("ERROR", "we are in onCreate\n");
  }

 }
 
}