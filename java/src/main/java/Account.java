public class Account {

    private Balance balance;
    private TransactionsHistory transactions = new TransactionsHistory();

    public Account() {
        this.balance = new Balance(0);
    }

    public void deposit(Amount amount) {

        balance.add(amount);
        transactions.recordDeposit(amount, balance);
    }

    public void withdraw(Amount amount) {
        balance.withdraw(amount);
    }

    public Balance printBalance() {
        return balance;
    }

    public String printStatement() {
        return "date       || credit   || debit    || balance" + System.lineSeparator() +
                transactions.print();
    }
}
