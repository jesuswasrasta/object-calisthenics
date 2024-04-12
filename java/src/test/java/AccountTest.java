import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The Rules
 * - One level of indentation per method
 * - Don’t use the ELSE keyword
 * - Wrap all primitives and Strings (only in constructors)
 * - First class collections
 * - One dot per line
 * - Don’t abbreviate
 * - Keep all entities small (50 lines)
 * - No classes with more than two instance variables
 * - No getters/setters/properties
 *
 *
 * Given a client makes a deposit of 1000 on 10-01-2012
 * And a deposit of 2000 on 13-01-2012
 * And a withdrawal of 500 on 14-01-2012
 * When she prints her bank statement
 * Then she would see
 * date       || credit   || debit    || balance
 * 14/01/2012 ||          || 500.00   || 2500.00
 * 13/01/2012 || 2000.00  ||          || 3000.00
 * 10/01/2012 || 1000.00  ||          || 1000.00
 */

public class AccountTest {

  @Test
  public void seDeposito1000IlSaldoE1000() {
    var expectedBalance = new Balance(1000);

    var amount = new Amount(1000);
    Account account = new Account();
    account.deposit(amount);

    var actualBalance = account.printBalance();

    assertEquals(expectedBalance, actualBalance);
  }

  @Test
  public void setDueDepositiDa1000IlSaldoE2000() {
    var expectedBalance = new Balance(2000);

    var amount = new Amount(1000);
    Account account = new Account();
    account.deposit(amount);
    account.deposit(amount);

    var actualBalance = account.printBalance();

    assertEquals(expectedBalance, actualBalance);
  }

  @Test
  public void seDepositi2000ePrelevi1000IlSaldoe1000() {
    var expectedBalance = new Balance(1000);

    var amount = new Amount(1000);
    Account account = new Account();
    account.deposit(amount);
    account.deposit(amount);
    account.withdraw(amount);

    var actualBalance = account.printBalance();

    assertEquals(expectedBalance, actualBalance);
  }
}
