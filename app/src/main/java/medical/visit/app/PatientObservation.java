package medical.visit.app;

import medical.visit.adapters.ObserveAdapter;
import medical.visit.obj.Patient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PatientObservation extends Activity{
	
	EditText observ;
	Button save;
	
	ObserveAdapter ObsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient_obs);
		
		observ = (EditText) findViewById(R.id.editText1);
		observ.setText("");
		
		save = (Button) findViewById(R.id.button1);	
		
//		Intent intent = getIntent();
//		final String k_row = intent.getExtras().getString("key_row");
		
//		observ.setText(k_row);
		
		ObsAdapter = new ObserveAdapter(this);
//		ObsAdapter.openToRead();  
		 
		save.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {		        	
//	        	String p = k_row;	        	   
	    	    ObsAdapter.openToWrite();
	    	    //mySQLiteAdapter.deleteAll();
	    	    //long isInserted = ObsAdapter.insert(observ.getText().toString());	    	    
	    	    ObsAdapter.close();	
	    	    finish();
	            }
	         });		
	}
}
	


