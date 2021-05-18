public class Test5 {
	public static void main(String[] args) {
		Phone p = new Phone();
		p.sendMsg();
		
	}
	
	
	class Phone {
		
		public void sendMsg() {
			System.out.println("send msg");
			
		}
		
		public void call() {
			System.out.println("make call");
			
		}
		
		public void autoCall() {
			System.out.println("auto call");
			this.call();
		}
	}
}
