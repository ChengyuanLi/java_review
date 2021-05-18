public class Card {
    private int cno;
    private int pass;
    private String name;
    private int balance;
    private int flag = 0; // 0: normal 1: locked 2: forzen 3: lost
    private int count  = 0; // passward wrong counter

    /*public Card(int cno, int pass,String name, int balance, int flag, int count) {

    }*/

    public Card(int cno, int pass, String name, int balance, int flag, int count) {
        this.cno = cno;
        this.pass = pass;
        this.name = name;
        this.balance = balance;
        this.flag = flag;
        this.count = count;
    }

    public Card() {
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}