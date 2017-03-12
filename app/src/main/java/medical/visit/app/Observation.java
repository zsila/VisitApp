package medical.visit.app;

import medical.visit.obj.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import medical.visit.adapters.ObserveAdapter;

public class Observation extends Activity{
	public String content_;
	EditText content_E;
	
	Button save;
	
	ObserveAdapter myObsAdapter;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient_obs);		 
			 		
		content_E = (EditText) findViewById(R.id.editText1);
		content_E.setText(" ");
		
		save = (Button) findViewById(R.id.button1);		
				    
		myObsAdapter = new ObserveAdapter(this);
		
		save.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {		        	
	        	ObsItem obsItem = new ObsItem(Integer.valueOf(getIntent().getExtras().getString("key_pid")), content_E.getText().toString());	        	   
	        	myObsAdapter.openToWrite();
	    	    long isInserted = myObsAdapter.insert(obsItem);	    	    
	    	    myObsAdapter.close();	
	    	    finish();
	            }
	         });		
	}

}
