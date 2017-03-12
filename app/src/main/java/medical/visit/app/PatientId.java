package medical.visit.app;
import medical.visit.obj.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PatientId extends Activity{
	public String name_, birth_date_, birth_place_, gender_, mar_stat, fat_name, mot_name, address_, phone, blood, relative_information, special_cond;
	EditText name;
	EditText birth_date;
	EditText birth_place;
	EditText gender;
	EditText marital_status;
	EditText father_name;
	EditText mother_name;
	EditText address;
	EditText phone_number;
	EditText blood_type;
	EditText relative_info;
	EditText special_case;
	Button save;
	
	SQLiteAdapter mySQLiteAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patientid_empty);
		
		 		
		name = (EditText) findViewById(R.id.editText1);
		name.setText(" ");
		birth_place = (EditText) findViewById(R.id.editText2);
		birth_place.setText(" ");
		birth_date = (EditText) findViewById(R.id.editText3);
		birth_date.setText(" ");
		gender = (EditText) findViewById(R.id.editText4);
		gender.setText(" ");
		marital_status = (EditText) findViewById(R.id.editText5);
		marital_status.setText(" ");
		father_name = (EditText) findViewById(R.id.editText6);
		father_name.setText(" ");
		mother_name = (EditText) findViewById(R.id.editText7);
		mother_name.setText(" ");
		address = (EditText) findViewById(R.id.editText8);
		address.setText(" ");
		phone_number = (EditText) findViewById(R.id.editText9);
		phone_number.setText(" ");
		blood_type = (EditText) findViewById(R.id.editText12);
		blood_type.setText(" "); 
		relative_info = (EditText) findViewById(R.id.editText11);
		relative_info.setText(" ");
		special_case = (EditText) findViewById(R.id.editText13);
		special_case.setText(" ");
		save = (Button) findViewById(R.id.button1);		  
		    
		mySQLiteAdapter = new SQLiteAdapter(this);  
		
		save.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {		        	
	        	Patient p = new Patient(name.getText().toString(), birth_place.getText().toString(), birth_date.getText().toString(), gender.getText().toString(), marital_status.getText().toString(), father_name.getText().toString(), 
	    	    mother_name.getText().toString(), address.getText().toString(), phone_number.getText().toString(), blood_type.getText().toString(), relative_info.getText().toString(), special_case.getText().toString());
	        	//name_ = name.getText().toString();	        	   
	    	    mySQLiteAdapter.openToWrite();
	    	    //mySQLiteAdapter.deleteAll();
	    	    //mySQLiteAdapter.dropTable();  
	    	    //mySQLiteAdapter.createTable();
	    	    long isInserted = mySQLiteAdapter.insert(p);
	    	    //mySQLiteAdapter.
	    	    mySQLiteAdapter.close();	
	    	    Intent i = new Intent(PatientId.this, CreatePatient.class);
	    	    //i.putExtra("key_pid", p.id);
	    	    i.putExtra("key_pid", String.valueOf(isInserted));
	    	    startActivity(i);
	    	    
	            }
	         });		
	}

}
