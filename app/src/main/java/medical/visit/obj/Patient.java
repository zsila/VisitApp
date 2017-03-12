package medical.visit.obj;

public class Patient {
	
	public int id=0;
	public String name="";
	public String birth_place="";
	public String birth_date="";
	public String gender="";
	public String mar_stat="";
	public String fat_name="";
	public String mot_name="";
	public String address="";
	public String phone="";
	public String blood="";
	public String rel_info="";
	public String spec_case="";
	
	public Patient() {
		// TODO Auto-generated constructor stub
		id=0;
		name=" ";
		birth_place=" ";
		birth_date=" ";
		gender=" ";
		mar_stat=" ";
		fat_name=" ";
		mot_name=" ";
		address=" ";
		phone="";
		blood="";
		rel_info="";
		spec_case="";
		
	}
	
	public Patient(String n, String bp, String bd, String g, String ms, String fn, String mn, String a, String p, String b, String ri, String sc) {
		// TODO Auto-generated constructor stub
		name=n;
		birth_place=bp;
		birth_date=bd;
		gender=g;
		mar_stat=ms;
		fat_name=fn;
		mot_name=mn;
		address=a;
		phone=p;
		blood=b;
		rel_info=ri;
		spec_case=sc;
		
	}
	
	public Patient(String id, String n, String bp, String bd, String g, String ms, String fn, String mn, String a, String p, String b, String ri, String sc) {
		// TODO Auto-generated constructor stub
		this.id = Integer.parseInt(id); 
		name=n;
		birth_place=bp;
		birth_date=bd;
		gender=g;
		mar_stat=ms;
		fat_name=fn;
		mot_name=mn;
		address=a;
		phone=p;
		blood=b;
		rel_info=ri;
		spec_case=sc;
		
	}
	
	

}
