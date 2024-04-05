import java.util.Objects;

public class Amount implements Comparable<Amount> {

    private int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Amount o) {
        return amount - o.amount;
    }
    
    public Amount add(Amount amountToAdd) {
        return new Amount(amount + amountToAdd.amount);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return amount == amount1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}