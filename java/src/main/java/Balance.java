
/**
 * Represents a balance in a bank account.
 *
 * È un Value Object: è immutabile e non ha metodi
 */

public class Balance implements Comparable<Balance> {
    private final int amount;

    public Balance(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Balance otherBalance) {
        return this.amount - otherBalance.amount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Balance balance = (Balance) other;
        return amount == balance.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}