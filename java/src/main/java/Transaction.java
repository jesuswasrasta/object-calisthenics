public class Transaction {
    private final Amount transactionAmount;
    private final Amount balanceAmount;

    public Transaction(Amount transacionAmount, Amount balanceAmount) {

        this.transactionAmount = transacionAmount;
        this.balanceAmount = balanceAmount;
    }

    public String print (){
        return "12/04/2024 || " + transactionAmount.toString() + ".00  ||          || " + balanceAmount.toString() + ".00";
    }
}
