public class Service {

    private Service() {}
    private static Service s;
    public static Service getInstance() {
        if (s == null) {
            s = new Service();
        } return s;
    }


    public void save(int cno, String cname, String color, int price) {
        Car car = new Car(cno, cname, color, price);

        Store s = Store.getInstance();
        s.add(car);

        Browser b = Browser.getInstance();
        b.showMainView();
    }

    public void getCarList() {
        Store store = Store.getInstance();
        Car[] cars = store.getCars();
        Browser b = Browser.getInstance();
        b.showCarListView(cars);
    }
}