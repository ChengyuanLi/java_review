import java.util.*;
public class Test7 {
    public static void main(String[] args) {
        Browser b = new Browser();
        b.showMainView();
    }
}

// view
class Browser {
    public void showMainView() {
        Scanner s = new Scanner(System.in);

        showSystemTitle();
        System.out.println("1. ADD CAR INFO");
        System.out.println("2. CAR INFO LIST");
        System.out.println("3. CAR EDIT");
        System.out.println("4. DELETE CAR");
        System.out.println("5. PELASE ENTER YOUR OPERATION");

        int num = s.nextInt();
        switch (num) {
            case 1:
                this.showAddCarView();
                ;break;
            case 2:
                Service service = new Service();
                service.getCarsList();

                ;break;
            case 3:;break;
            case 4:;break;
            case 5:;break;
        }
    }

    public void showCarListView(Car[] cars) {
        showSystemTitle();
        for (int i = 0; i < cars.length; i++) {
            Car car = cars[i];
            System.out.println(car.getcNumber());
            System.out.println("/t");
            System.out.println(car.getcName());
            System.out.println("/t");
            System.out.println(car.getcColor());
            System.out.println("/t");
            System.out.println(car.getcPrice());
        }
        Scanner s = new Scanner(System.in);
        System.out.println("operation compeleted, press any key to return.");
        s.next();
        showMainView();
    }

    public void showAddCarView() {

        Scanner s = new Scanner(System.in);
        showSystemTitle();
        System.out.println("CAR NUMBER: ");
        int cNum = s.nextInt();

        System.out.println("CAR NAME: ");
        String cName = s.next();

        System.out.println("CAR COLOR: ");
        String cColor = s.next();

        System.out.println("CAR PRICE: ");
        int cPrice = s.nextInt();

        Service service = new Service();
        service.saveCar(cNum, cName, cColor, cPrice);
    }

    public void showSystemTitle() {
        System.out.println("**********************");
        System.out.println("****VW CAR MANAGE*****");
        System.out.println("**********************");
    }
}


// operation
class Service {

    static Car[] cars = new Car[10]; // store all car information
    static int count = 0; // store car number and next position

    public void getCarsList() {
        Car[] carList = new Car[count];
        for (int i = 0; i < count; i++) {
            carList[i] = cars[i];
        }

        Browser browser = new Browser();
        browser.showCarListView(carList);
    }

    public void saveCar(int number, String name, String color, int price) {
        Car car = new Car(number, name, color, price);
        cars[count] = car;
        count++;

        Browser b = new Browser();
        b.showMainView();
    }
}

//instance
class Car {
    private int cNumber;
    private String cName;
    private String cColor;
    private int cPrice;

    // constructor without variable
    public Car() {

    }

    public Car (int number, String name, String color, int price){
        this.cNumber = number;
        this.cName = name;
        this.cColor = color;
        this.cPrice = price;
    }
    public int getcNumber() {
        return cNumber;
    }

    public void setcNumber(int cNumber) {
        this.cNumber = cNumber;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcColor() {
        return cColor;
    }

    public void setcColor(String cColor) {
        this.cColor = cColor;
    }

    public int getcPrice() {
        return cPrice;
    }

    public void setcPrice(int cPrice) {
        this.cPrice = cPrice;
    }
}