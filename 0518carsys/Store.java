public class Store {
    private Store() {

    }
    private static Store s = new Store();
    public static Store getInstance() {
        return s;
    }

    private Car[] cars = new Car[10];
    private int count = 0;

    //初始化清单信息，不想污染单例模式，使用普通代码段
    //在创建对象时运行且只运行一次
    {
        cars[count] = new Car(1001, "mazda", "grey", 25000);
        count++;
        cars[count] = new Car(1002, "jeep", "black", 45000);
        count++;
        cars[count] = new Car(1003, "volvo", "white", 65000);
        count++;
        cars[count] = new Car(1004, "benz", "blue", 75000);
        count++;
    }


    public void add(Car car) {

        cars[count] = car;
        count ++;
        System.out.println("---------->" + count);
    }

    public Car[] getCars() {
        Car[] result = new Car[count];
        for (int i = 0; i < count; i ++) {
            result[i] = cars[i];
        }
        return result;
    }
}