public class Browser {
    // 单例模式
    private Browser() {

    }
    private static Browser browser = new Browser();

    public static Browser getInstance() {

        return browser;
    }

    public void showMainView() {
        MainView mainView = new MainView();
        mainView.show();
    }

    public void showAddView() {
        AddView addView = new AddView();
        addView.show();
    }

    public void showCarListView(Car[] cars) {
        CarListView carListView = new CarListView();
        carListView.show(cars);
    }
}