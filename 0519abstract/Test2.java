public class Test2 {
    public static void main(String[] args) {

    }
}

/*
 * 只制定需要开发的功能 （规则）
 * 不限制开发的方式
 * 单继承，多接口
 * 优先考虑使用接口实现
 * */

/*
* 需求一个容器
* 要求：
* 装东西
* 取东西
* 获得大小
* */
interface Box {
    public abstract void add(Object object);
    public abstract Object get();
    public abstract int size();
}
/*
* 描述一个容器 ！实体！
* 该容器使用数组结构存储数据
* */

class ArrayBox implements Box{
    // 完善三个方法
}

/*
 * 描述一个容器 ！实体！
 * 该容器使用树结构存储数据
 * */

class TreeBox implements Box{
    // 完善三个方法
}



