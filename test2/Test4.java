public class Test4 {
    public static void main(String[] args) {
        Emp e = new Emp();
        System.out.println(e.Name);
    }
}

class Person{
    String Name;
    String sex;
    int age;
}

class Emp extends Person {
    int eNum;
    int sal;
    String dept;
}

class Teacher extends Person {
    String course;
    String major;
}