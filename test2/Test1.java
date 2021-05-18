public class Test1 {
    public static void main(String[] args) {
        Browser b = Browser.getInstance();
        Browser b1 = Browser.getInstance();
        Browser b2 = Browser.getInstance();
        Browser b3 = Browser.getInstance();

        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}

class Browser {
    private Browser() {} // 构造器

    private static Browser b;  // 确保总是返回同一个对象

    public static Browser getInstance() {
        if (b == null) {
            b = new Browser();
        } return b;
    }