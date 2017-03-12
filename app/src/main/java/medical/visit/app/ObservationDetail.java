package medical.visit.app;

import java.util.ArrayList;

import medical.visit.adapters.ObserveAdapter;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ObservationDetail extends Activity{	
	EditText mycontent;	
	Button save;
	Button share;
	
	ArrayList<String> observes = new ArrayList<String>();
	ObserveAdapter obsAdapter;
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {  
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient_obs);
		
		Intent intent = getIntent();
		final String k_obs = intent.getExtras().getString("key_obs");
		final String k_name = intent.getExtras().getString("key_name");
		
		save = (Button) findViewById(R.id.button1);
		share = (Button) findViewById(R.id.button2);
		mycontent = (EditText) findViewById(R.id.editText1);
//		mycontent.setEnabled(false);
		
		if(!k_obs.equals(""))
			mycontent.setText(k_obs);
		else
			mycontent.setText("");		
	   
	
	share.setOnClickListener(new OnClickListener(){  
        public void onClick(View v)
            {        	
        	Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            String[] recipients = new String[]{ ""};
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, k_name+" "+"Report");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, k_name + ":  "+mycontent.getText().toString());
            emailIntent.setType("text/plain");
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();      	        		
            }
         });
	}
	
}
