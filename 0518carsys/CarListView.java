import java.util.*;
public class CarListView extends TitleView{
    public void show(Car[] cars) {
        Scanner input = new Scanner(System.in);
        showTitle();
        if (cars.length == 0) {
            System.out.println("NO RESULT FOUND!");
        } else {
            for (int i = 0; i < cars.length; i ++) {
                Car car = cars[i];
                System.out.println(car.getCno() + "\t" + car.getCname() + "\t" + car.getColor() + "\t" + car.getPrice());
            }
        }

        System.out.println("OPERATION COMPLETED, PRESS ANY KEY TO RETURN: ");
        input.next();
        Browser b = Browser.getInstance();
        b.showMainView();
    }
}