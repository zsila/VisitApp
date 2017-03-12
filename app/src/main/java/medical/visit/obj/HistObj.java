package medical.visit.obj;

public class HistObj {
	public int id=0;
	public int pid=0;
	public String name="";
	public String date="";
	public String protocol="";
	public String reason="";
	public String start="";
	public String intan="";
	public String other="";
	public String operations="";
	public String motherIll="";
	public String fatherIll="";
	public String siblingIll="";
	
	
	public HistObj() {
		// TODO Auto-generated constructor stub
		id=0;
		pid=0;
		name="";
		date="";
		protocol="";
		reason="";
		start="";
		intan="";
		other="";
		operations="";
		motherIll="";
		fatherIll="";
		siblingIll="";
	}
	
	public HistObj(int pid_, String name_, String date_, String protocol_, String reason_, String start_, 
			String intan_, String other_, String operations_, String motherIll_, String fatherIll_, String siblingIll_) {
		// TODO Auto-generated constructor stub
		id=0;
		pid=pid_;
		name=name_;
		date=date_;
		protocol=protocol_;
		reason=reason_;
		start=start_;
		intan=intan_;
		other=other_;
		operations=operations_;
		motherIll=motherIll_;
		fatherIll=fatherIll_;
		siblingIll=siblingIll_;
	}

}
