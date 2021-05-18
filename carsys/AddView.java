import java.util.*;
public class AddView extends TitleView{
    public void show() {
        Scanner input = new Scanner(System.in);
        showTitle();
        System.out.println("CAR NUMBER: ");
        int cno = input.nextInt();
        System.out.println("CAR NAME: ");
        String cname = input.next();
        System.out.println("CAR COLOR: ");
        String ccolor = input.next();
        System.out.println("CAR PRICE: ");
        int cprice = input.nextInt();

        Service service = Service.getInstance();
        service.save(cno, cname, ccolor, cprice);
    }

}