public class Test1 {
    public static void main(String[] args) {
        //new A();
        A1 a1 = new A1();
        a1.t2();
    }
}

abstract class A {

    public A() {}

    public A(int i) {
        this.i = i;
    }

    int i = 10;
    public void t1() {
        System.out.println(i);
    }

    public abstract void t2();
}

class A1 extends A {
    public void t2() {
        System.out.println("123");
    }
}