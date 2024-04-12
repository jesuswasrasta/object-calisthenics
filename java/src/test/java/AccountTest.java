import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

  @Test
  public void seDepositi2000ePrelevi500IlSaldoe1500() {
    var expectedBalance = new Balance(1500);

    var depositAmount = new Amount(2000);
    Account account = new Account();
    account.deposit(depositAmount);
    var withdrawAmount = new Amount(500);
    account.withdraw(withdrawAmount);

    var actualBalance = account.printBalance();

    assertEquals(expectedBalance, actualBalance);
  }

  @Test
  @DisplayName("Se depositi 1000 e prelevi 1500, il sistema solleva una eccezione")
  public void amountPrelevatoMaggioreDiSaldo() {
    Account account = new Account();

    var depositedAmount = new Amount(1000);
    account.deposit(depositedAmount);

    assertThrows(IllegalArgumentException.class, () -> {
      var withdrawAmount = new Amount(1500);
      account.withdraw(withdrawAmount);
    });
  }

  @Test
  @DisplayName("Stampa del saldo dopo aver depositato 1000")
  public void seDeposito1000StampaOperazione() {
    String saldoAtteso = """
date       || credit   || debit    || balance
12/04/2024 || 1000.00  ||          || 1000.00
""";

    var amount = new Amount(1000);
    Account account = new Account();
    account.deposit(amount);

    var saldoStampato = account.printStatement();

    assertEquals(saldoAtteso, saldoStampato);
  }

  @Test
  @DisplayName("Stampa del saldo dopo aver depositato 1000 e poi ancora 1000")
  public void depositoMultiplo() {
    String saldoAtteso = """
            date       || credit   || debit    || balance
            12/04/2024 || 1000.00  ||          || 1000.00
            12/04/2024 || 1000.00  ||          || 2000.00
            """;

    var amount = new Amount(1000);
    Account account = new Account();
    account.deposit(amount);
    account.deposit(amount);

    var saldoStampato = account.printStatement();

    StringAssertions.assertLinesEqual(saldoAtteso, saldoStampato);

  }
}
