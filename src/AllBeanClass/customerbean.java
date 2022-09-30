package AllBeanClass;

public class customerbean {
	private String name;
	private int cusid ;
	private int accNo;
	private int ammount; 
	
	public customerbean() {
		// TODO Auto-generated constructor stub
	}

	public customerbean(String name, int cusid, int accNo, int ammount) {
		super();
		this.name = name;
		this.cusid = cusid;
		this.accNo = accNo;
		this.ammount = ammount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	@Override
	public String toString() {
		return "customerbean [name=" + name + ", cusid=" + cusid + ", accNo=" + accNo + ", ammount=" + ammount + "]";
	}

}
