public class test1 {
	public static void main (String[] args) {
		Computer c = new Computer();
		System.out.println(c);
		c.start();
	}
}

class Computer {
	String screen = "Benq";
	
	public void start() {
		System.out.println("system started.");
	}
}