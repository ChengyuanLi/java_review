public class Test3 {
	public static void main(String[] args) {
		saveEmp();
	}
	
	public static void saveEmp() {
		Empolyee emp1 = new Empolyee();
		Empolyee emp2 = new Empolyee();
		
		emp1.setEmpNo(1001);
		emp2.setEmpNo(1002);
		
		System.out.println(emp1.getEmpno());
		System.out.println(emp2.getEmpno());
		
		
	}
}

class Empolyee {
	private int empNo;
	private String empName;
	private int sallay;
	private String dept;
	
	public void setEmpNo(int num) {
		empNo = num;
	}
	
	public int getEmpno() {
		return empNo;
	}
}