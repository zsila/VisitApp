package medical.visit.app;
import medical.visit.obj.*;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PatientList extends Activity{
	
	ListView patientList; 
	ArrayList<Patient> patients = new ArrayList<Patient>();	
	ArrayList<ObsItem> observations = new ArrayList<ObsItem>();
	ArrayList<String> patients2 = new ArrayList<String>();
	ArrayList<String> patients_ins = new ArrayList<String>();
	ArrayList<String> tmp = new ArrayList<String>();
	ArrayList<String> tmp2 = new ArrayList<String>();
	
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<String> birth_ps = new ArrayList<String>();
	ArrayList<String> birth_ds = new ArrayList<String>();
	ArrayList<String> genders = new ArrayList<String>();
	ArrayList<String> mar_stas = new ArrayList<String>();
	ArrayList<String> fat_names = new ArrayList<String>();
	ArrayList<String> mot_names = new ArrayList<String>();
	ArrayList<String> addresses = new ArrayList<String>();
	ArrayList<String> phones = new ArrayList<String>();
	ArrayList<String> blood_types = new ArrayList<String>();
	ArrayList<String> rel_infos = new ArrayList<String>();
	ArrayList<String> spec_conds = new ArrayList<String>();
	
	  
	public static SQLiteAdapter mySQLiteAdapter;
	public static SQLiteAdapter mySQLiteAdapter_inspection;
	

	@Override  
	protected void onCreate(Bundle savedInstanceState) {   
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patientlist);
		patientList = (ListView) findViewById(R.id.listView1); 
				  
	           
	    mySQLiteAdapter = new SQLiteAdapter(this);
	    mySQLiteAdapter.openToRead();   
	    mySQLiteAdapter.queueAll(patients);
	    mySQLiteAdapter.queryObservations(observations);
	        
	    for(int i=0; i<patients.size(); i++){
	    	String id = Integer.toString(patients.get(i).id) + " " + patients.get(i).name;
	    	
	    	names.add(id!=null?id:"myid");
	    }
	       
	    mySQLiteAdapter.close();	   	    	    		   
		 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
		patientList.setAdapter(adapter);	
		    
		    
		patientList.setOnItemClickListener(new OnItemClickListener(){
	    	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {		    		
	    		Intent i = new Intent(PatientList.this, ChoiceList.class);
	    		i.putExtra("key_row", Integer.toString(position));
	    		i.putExtra("key_id", Integer.toString(patients.get(position).id));
	    		i.putExtra("key_name", patients.get(position).name);
	    		i.putExtra("key_birth_p", patients.get(position).birth_place);
	    		i.putExtra("key_birth_d", patients.get(position).birth_date);
	    		i.putExtra("key_gender", patients.get(position).gender);
	    		i.putExtra("key_mar_stat", patients.get(position).mar_stat);  
	    		i.putExtra("key_fat_name", patients.get(position).fat_name);
	    		i.putExtra("key_mot_name", patients.get(position).mot_name);  
	    		i.putExtra("key_address", patients.get(position).address);
	    		i.putExtra("key_phone", patients.get(position).phone);  
	     		i.putExtra("key_blood_type", patients.get(position).blood);
	    		i.putExtra("key_rel_info", patients.get(position).rel_info);
	    		i.putExtra("key_spec_cond", patients.get(position).spec_case);	
	    		
	    		//if(!observations.get(position).obs.equals(null))
	    			//i.putExtra("key_obs", observations.get(position).obs);
	    		
	    		mySQLiteAdapter.openToRead();
	    		String obs = mySQLiteAdapter.queryObservation(patients.get(position).id);
	    		HistObj history = mySQLiteAdapter.queryHistory(patients.get(position).id);
	    		mySQLiteAdapter.close();
	    		i.putExtra("key_obs", obs);
	    		i.putExtra("key_hist", new String[]{
	    				history.name,
	    				history.date,
	    				history.protocol,
	    				history.reason,
	    				history.start,
	    				history.intan,
	    				history.other,
	    				history.operations,
	    				history.motherIll,
	    				history.fatherIll,
	    				history.siblingIll});
	    		  
	    		startActivity(i);    		
	    		}
	    	});
		}	   
}