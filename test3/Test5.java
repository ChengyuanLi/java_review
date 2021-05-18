public class Test5 {
    public static void main(String[] args) {
        ArrayBox box = new ArrayBox();
        for (int i = 0; i < 100; i++) {
            box.add("yyds" + i);
        }
        box.addAll(new Object[]{"a", "b", "v"});
        box.insert(100, "d");

        box.remove(101);
        System.out.println(box.size());



        for (int i = 0; i < box.size(); i++) {
            System.out.println(box.get(i));
        }
    }
}

/*
自定义容器
装载 / 取出 对象
取数量
一直装
删除对象
*/
class ArrayBox {
    private Object[] elements;
    private int count = 0;
    public ArrayBox() {
        this(16);
    }
    public ArrayBox(int length) {
        elements = new Object[length];
    }


    public void add(Object object) {
        checkLength(1);
        elements[count] = object;
        count++;
    }

    public int size() {
        return count;
    }

    public void addAll (Object[] objects) {
        checkLength(objects.length);
        for(int i = 0; i < objects.length; i++) {
            elements[count + i] = objects[i];
        }
        count += objects.length;
    }

    public void insert(int index, Object object) {
        checkLength(1);
        if (index < count) {
            for (int i = count - 1; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
        }
        elements[index] = object;
        count ++;
    }

    public Object get(int index) {
        return elements[index];
    }

    public void remove(int index) {
        for (int i = index + 1; i <= count - 1; i ++ ) {
            elements[i-1] = elements[i];
        }
        elements[count - 1] = null;
        count --;
    }

    private void checkLength(int num) {
        int minLength = count + num;
        if (minLength > elements.length){
            // 扩容 防0
            int newLength = elements.length << 1 + 1;
            newLength = newLength > minLength ? newLength : minLength;
            Object[] newElements = new Object[newLength];
            for (int i = 0; i < count; i++){
                newElements[i] = elements[i];
            }
            this.elements = newElements;
        }
    }
}