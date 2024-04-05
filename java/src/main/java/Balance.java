
/**
 * Represents a balance in a bank account.
 *
 * È un Value Object: è immutabile e non ha metodi
 */

public class Balance {
    private Amount amount;

    public Balance(int amount) {
        this.amount = new Amount(amount);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Balance balance = (Balance) other;
        return amount.equals(balance.amount);
    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }

    public void add(Amount amountToAdd) {
        amount = amount.add(amountToAdd);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "amount=" + amount +
                '}';
    }
}