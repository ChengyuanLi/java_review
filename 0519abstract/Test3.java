public class Test3 {
    public static void main(String[] args) {
        A a = new B(); //上转型
        a.t1();
        a.t2();
        a.t3();
    }
}

interface A extends A1, A3{
    final int I = 10;
    void t1();
}

interface A1{
    void t2();
}

interface A3 {
    void t2();
    void t3();
}

class B implements A {
    public void t1() {
        System.out.println("t1()");
    }

    public void t2() {
        System.out.println("t2()");
    }

    public void t3() {
        System.out.println("t3()");
    }
}