package medical.visit.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {	
	Button patientList;
	Button newPatient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*Intent intent = getIntent();
		final String k_pid;
		if(intent.getExtras() != null)
			k_pid= intent.getExtras().getString("key_pid");*/
		
		
		patientList = (Button) findViewById(R.id.btn_list);
		newPatient = (Button) findViewById(R.id.btn_new);		
		
		patientList.setOnClickListener(new OnClickListener(){  
        public void onClick(View v)
            {
        	//patientList.setBackgroundColor(Color.MAGENTA);
        	Intent i = new Intent(MainActivity.this, PatientList.class);
        	
            startActivity(i);        	        		
            }
         });
		
		newPatient.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {
	        	//newPatient.setBackgroundColor(Color.BLUE);
	        	Intent i = new Intent(MainActivity.this, CreatePatient.class);
	        	startActivity(i);         		
	            }
	         });		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
