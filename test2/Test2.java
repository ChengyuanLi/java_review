public class Test2 {
    public static void main(String[] args) {

    }
}

//display
class Broswer {

}

//operation
class Service {
    public void save() {
        Car car = new Car();
        Store s = Store.getInstance();
        s.addCar(car);
    }
}

//storage 仓库只应该有一个 *单例模式*
class Store {

    private Store() {}
    private static Store s = new Store();

    public static Store getInstance() {
        return s;
    }

    private Car[] cars = new Car[10];
    private int count = 0;

    public void addCar(Car car) {
        cars[count] = car;
        count ++;
    }



}

//instance
class Car {

}