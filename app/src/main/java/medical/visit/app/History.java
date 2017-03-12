package medical.visit.app;

import medical.visit.adapters.HistoryAdapter;
import medical.visit.adapters.ObserveAdapter;
import medical.visit.obj.HistObj;
import medical.visit.obj.ObsItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class History extends Activity{
	
	EditText name;
	EditText date;
	EditText protocol;
	EditText reason;
	EditText starting;
	EditText intanIllness;
	EditText otherIllness;
	EditText operations;
	EditText motherIllness;
	EditText fatherIllness;
	EditText siblingIllness;
	Button save;
	
	HistoryAdapter histAdapter;
		
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		
		name = (EditText) findViewById(R.id.editText1);
		date = (EditText) findViewById(R.id.editText2);
		protocol = (EditText) findViewById(R.id.editText3);
		reason = (EditText) findViewById(R.id.editText4);
		starting = (EditText) findViewById(R.id.editText6);
		intanIllness = (EditText) findViewById(R.id.editText8);
		otherIllness = (EditText) findViewById(R.id.editText9);
		operations = (EditText) findViewById(R.id.editText5);
		motherIllness = (EditText) findViewById(R.id.editText7);
		fatherIllness = (EditText) findViewById(R.id.editText13);
		siblingIllness = (EditText) findViewById(R.id.editText10);
		
		save = (Button) findViewById(R.id.button1);
		
		histAdapter = new HistoryAdapter(this);	
		
		save.setOnClickListener(new OnClickListener(){  
	        public void onClick(View v)
	            {		        	
	        	HistObj histItem = new HistObj(Integer.valueOf(getIntent().getExtras().getString("key_pid")), name.getText().toString(), date.getText().toString(),
	        			protocol.getText().toString(), reason.getText().toString(), starting.getText().toString(), intanIllness.getText().toString(), otherIllness.getText().toString(),
	        			operations.getText().toString(), motherIllness.getText().toString(), fatherIllness.getText().toString(), siblingIllness.getText().toString());	        	   
	        	
	        	histAdapter.openToWrite();
	    	    long isInserted = histAdapter.insert(histItem);	    	    
	    	    histAdapter.close();	
	    	    finish();
	            }
	         });			
	}
	
}
