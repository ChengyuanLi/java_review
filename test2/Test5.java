public class Test5 {
    public static void main(String[] args) {
        new B2();
}


class B1 {
    private int i;
    public B1() {
        System.out.println(1);
    }

    public B1(int i) {
        this();
        this.i = i;
        System.out.println(2);
    }
}

class B2 extends B1{
    private int j;
    public B2() {
        this(5);
        System.out.println(3);
    }

    public B2(int j) {
        super(6);
        this.j = j;
        System.out.println(4);
    }
}