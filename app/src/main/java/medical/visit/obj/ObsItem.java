package medical.visit.obj;

public class ObsItem {
	
	public int id;
	public int pid;
	public String obs="";
	
	public ObsItem() {

		id = 0;
		pid = 0;
		obs="";
	}
	
	public ObsItem(int pid, String s) {
		
		this.id = 0;
		this.pid = pid;
		this.obs=s;
	}
	
	
}
