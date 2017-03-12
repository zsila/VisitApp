package medical.visit.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CreatePatient extends Activity {
	Button patient_id;
	Button pat_observation;
	Button history;
	Button poli_control;
	Button daily_filling;  
	Button inspection; 
	Button done;
	   

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);     
		setContentView(R.layout.create_patient);    
		
		
		patient_id = (Button) findViewById(R.id.button1);		
		patient_id.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
	        	//patientList.setBackgroundColor(Color.MAGENTA);
	        	Intent i = new Intent(CreatePatient.this, PatientId.class);
	            startActivity(i);        	        		
	            }
	         });	
		
		
		
        pat_observation = (Button) findViewById(R.id.button2);		
        pat_observation.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
	        	//patientList.setBackgroundColor(Color.MAGENTA);
	        	Intent i = new Intent(CreatePatient.this, Observation.class);
	        	i.putExtra("key_pid", getIntent().getExtras().getString("key_pid"));
	            startActivity(i);        	        		
	            }
	         });
		
		
		history = (Button) findViewById(R.id.button3);		
		history.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
	        	//patientList.setBackgroundColor(Color.MAGENTA);
	        	Intent i = new Intent(CreatePatient.this, History.class);
	        	i.putExtra("key_pid", getIntent().getExtras().getString("key_pid"));
	            startActivity(i);        	        		
	            }
	         });		
		
		inspection = (Button) findViewById(R.id.button4);
		
		inspection.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
	        	//patientList.setBackgroundColor(Color.MAGENTA);
	        	Intent i = new Intent(CreatePatient.this, InspectionFilling.class);
	            startActivity(i);        	        		
	            }
	         });	
		
		daily_filling = (Button) findViewById(R.id.button5);
		
		daily_filling.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
	        	//patientList.setBackgroundColor(Color.MAGENTA);
	        	Intent i = new Intent(CreatePatient.this, DailyFilling.class);
	            startActivity(i);        	        		
	            }
	         });
			
		
		poli_control = (Button) findViewById(R.id.button6);
		
		poli_control.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
	        	//patientList.setBackgroundColor(Color.MAGENTA);
	        	Intent i = new Intent(CreatePatient.this, PoliclinicControl.class);
	            startActivity(i);        	        		
	            }
	         });
		
		done = (Button) findViewById(R.id.button8);		
		done.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
	        	//patientList.setBackgroundColor(Color.MAGENTA);
	        	Intent i = new Intent(CreatePatient.this, MainActivity.class);
	            startActivity(i);        	        		
	            }  
	         });
		
		
	}
}
