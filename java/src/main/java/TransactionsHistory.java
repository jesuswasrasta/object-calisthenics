import java.util.ArrayList;
import java.util.List;
public class TransactionsHistory {

    List<Transaction> transactions = new ArrayList();
    public void recordDeposit(Amount amount, Balance balance) {
        transactions.add(new Transaction(amount, balance.currentAmount()));
    }

    public String print (){
        StringBuilder printableBulider = new StringBuilder();
        for (Transaction transaction : transactions){
            printableBulider.append(transaction.print());
            printableBulider.append(System.lineSeparator());
        }
        return printableBulider.toString();
    }


}
