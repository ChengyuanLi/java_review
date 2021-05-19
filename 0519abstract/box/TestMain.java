public class TestMain {
    public static void main(String[] args) {
        Box box = new ArrayBox();
        for (int i = 1; i <= 30; i++) {
            box.add("lcy" + i);
        }
        System.out.println(box.size());
        System.out.println("++++++++++++++++++++++++++++++");
        String s = (String)box.remove(0);
        System.out.println(s);
        System.out.println("++++++++++++++++++++++++++++++");


        for (int i = 0; i < box.size(); i++) {
            System.out.println(box.get(i));
        }
        System.out.println("++++++++++++++++++++++++++++++");

        Object[] ss = box.toArray();
        for (int i = 0; i < ss.length; i++) {
            String str = (String)ss[i];
            System.out.println(str);
        }
    }
}