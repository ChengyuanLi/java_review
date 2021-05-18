import java.util.*;
public class MainView extends TitleView{
    public MainView() {}
    public void show() {
        Scanner input = new Scanner(System.in);
        showTitle();
        System.out.println("1. ADD INFO");
        System.out.println("2. CAR LIST");
        System.out.println("3. EDIT INFO");
        System.out.println("4. DELETE INFO");
        System.out.println("PLEASE ENTER YOUR OPERATION: ");
        int num = input.nextInt();

        switch (num) {
            case 1:
                Browser b = Browser.getInstance();
                b.showAddView();
                ;break;
            case 2:
                Service service = Service.getInstance();
                service.getCarList();
                ;break;
            case 3:;break;
            case 4:;break;
        }

    }
}