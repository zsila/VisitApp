package medical.visit.app;

import java.util.ArrayList;

import medical.visit.adapters.HistoryAdapter;
import medical.visit.adapters.ObserveAdapter;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class HistoryDetail extends Activity{	

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
	
	ArrayList<String> observes = new ArrayList<String>();
	HistoryAdapter histAdapter;	
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {  
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		
		String[] histArray = getIntent().getExtras().getStringArray("key_hist");
		
		name = (EditText) findViewById(R.id.editText1);
		name.setText(histArray[0]);
		date = (EditText) findViewById(R.id.editText2);
		date.setText(histArray[1]);
		protocol = (EditText) findViewById(R.id.editText3);
		protocol.setText(histArray[2]);
		reason = (EditText) findViewById(R.id.editText4);
		reason.setText(histArray[3]);
		starting = (EditText) findViewById(R.id.editText6);
		starting.setText(histArray[4]);
		intanIllness = (EditText) findViewById(R.id.editText8);
		intanIllness.setText(histArray[5]);
		otherIllness = (EditText) findViewById(R.id.editText9);
		otherIllness.setText(histArray[6]);
		operations = (EditText) findViewById(R.id.editText5);
		operations.setText(histArray[7]);
		motherIllness = (EditText) findViewById(R.id.editText7);
		motherIllness.setText(histArray[8]);
		fatherIllness = (EditText) findViewById(R.id.editText13);
		fatherIllness.setText(histArray[9]);
		siblingIllness = (EditText) findViewById(R.id.editText10);
		siblingIllness.setText(histArray[10]);
		
		save = (Button) findViewById(R.id.button1);
			
		
		Intent intent = getIntent();
		//final String k_pro = intent.getExtras().getString("key_pro");
		
		
		/*if(!k_pro.equals(""))
			name.setText(k_pro);
		else
			name.setText("");*/		
	}   
}
