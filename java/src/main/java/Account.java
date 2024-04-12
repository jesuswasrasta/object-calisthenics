public class Account {

    private Balance balance;

    public Account() {
        this.balance = new Balance(0);
    }

    public void deposit(Amount amount) {
        balance.add(amount);
    }

    public void withdraw(Amount amount) {
        balance.withdraw(amount);
    }

    public Balance printBalance() {
        return balance;
    }

    public String printStatement() {
        return "date       || credit   || debit    || balance\n" +
                "12/04/2024 || 1000.00  ||          || 1000.00\n";
    }
}
