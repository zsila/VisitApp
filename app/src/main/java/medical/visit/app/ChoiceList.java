package medical.visit.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChoiceList extends Activity{
	Button patient_id;
	Button pat_observation;
	Button history;
	Button poli_control;
	Button daily_filling;
	Button inspection;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_patient);
		
		Intent intent = getIntent();
				
		final String k_row = intent.getExtras().getString("key_row");
		final String k_id = intent.getExtras().getString("key_id");
		final String k_name = intent.getExtras().getString("key_name");
		final String k_birthPlace = intent.getExtras().getString("key_birth_p");
		final String k_birthDate = intent.getExtras().getString("key_birth_d");		
		final String k_gender = intent.getExtras().getString("key_gender");
		final String k_mar_stat = intent.getExtras().getString("key_mar_stat");
		final String k_fat_name = intent.getExtras().getString("key_fat_name");
		final String k_mot_name = intent.getExtras().getString("key_mot_name");
		final String k_address = intent.getExtras().getString("key_address");
		final String k_phone = intent.getExtras().getString("key_phone");
		final String k_blood_type = intent.getExtras().getString("key_blood_type");
		final String k_rel_info = intent.getExtras().getString("key_rel_info");
		final String k_spec_cond = intent.getExtras().getString("key_spec_cond");
		
		final String k_obs = intent.getExtras().getString("key_obs");
		
		final String[] k_hist = intent.getExtras().getStringArray("key_hist");
		
		
		patient_id = (Button) findViewById(R.id.button1);
		
		patient_id.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
	        	Intent i = new Intent(ChoiceList.this, PatientIdDetail.class);
	        	i.putExtra("key_row", k_row);
	        	i.putExtra("key_id", k_id);
	        	i.putExtra("key_name", k_name);
	    		i.putExtra("key_birth_p", k_birthPlace);
	    		i.putExtra("key_birth_d", k_birthDate);
	    		i.putExtra("key_gender",  k_gender);
	    		i.putExtra("key_mar_stat", k_mar_stat);
	    		i.putExtra("key_fat_name", k_fat_name);
	    		i.putExtra("key_mot_name", k_mot_name);
	    		i.putExtra("key_address", k_address);
	    		i.putExtra("key_phone", k_phone);
	    		i.putExtra("key_blood_type", k_blood_type);
	    		i.putExtra("key_rel_info", k_rel_info);
	    		i.putExtra("key_spec_cond", k_spec_cond);
	            startActivity(i);        	        		
	            }
	         });	
		  	
		
        pat_observation = (Button) findViewById(R.id.button2);
		
        pat_observation.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
	        	Intent i = new Intent(ChoiceList.this, ObservationDetail.class);
	        	i.putExtra("key_obs", k_obs);
	        	i.putExtra("key_name", k_name);
	            startActivity(i);        	        		
	            }
	         });
		
		
		history = (Button) findViewById(R.id.button3);
		
		history.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)    
	            {
	        	Intent i = new Intent(ChoiceList.this, HistoryDetail.class);
	        	i.putExtra("key_hist", k_hist);//getIntent().getExtras().getStringArray("key_hist"));
	            startActivity(i);        	        		
	            }
	         });		
		
		inspection = (Button) findViewById(R.id.button4);
		
		inspection.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
//	        	Intent i = new Intent(ChoiceList.this, InspectionFilling.class);
//	            startActivity(i);        	        		
	            }
	         });	
		
		daily_filling = (Button) findViewById(R.id.button5);
		
		daily_filling.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
//	        	Intent i = new Intent(ChoiceList.this, DailyFilling.class);
//	            startActivity(i);        	        		
	            }
	         });
			
		
		poli_control = (Button) findViewById(R.id.button6);
		
		poli_control.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
//	        	Intent i = new Intent(ChoiceList.this, PoliclinicControl.class);
//	            startActivity(i);        	        		
	            }
	         });
	}

}
