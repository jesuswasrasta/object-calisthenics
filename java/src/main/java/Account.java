public class Account {

    private Balance balance;

    public Account() {
        this.balance = new Balance(0);
    }

    public void deposit(Amount amount) {
        balance.add(amount);
    }

    public Balance printBalance() {
        return balance;
    }
}
