public class test2 {
    public static void main(String[] args) {
        B b = new B1();
        System.out.println(b.j);
    }
}

class B {
    int j = 20;
}

class B1 extends B{
    //属性的重写
    int j = 30;
}