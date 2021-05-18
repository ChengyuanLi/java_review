public class Test6 {
    public static void main(String[] args) {
        /*int i = 10;
        test(i);
        System.out.println("main:" + i);*/
        Student s = new Student();
        s.setAge(10);
        test(s);
        System.out.println(s.getAge());
    }

    public static void test(int i) {
        i = 100;
        System.out.println("test:" + i);
    }

    public static void test(Student s) {
        s.setAge(100);
        System.out.println(s.getAge());
    }
}

class Student {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}