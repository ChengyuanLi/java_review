public class Browser {

    private Browser() {}
    private static Browser b = new Browser();
    public static Browser getInstance() {
        return b;
    }

    public void showView(View view) {
        view.show();
    }

}