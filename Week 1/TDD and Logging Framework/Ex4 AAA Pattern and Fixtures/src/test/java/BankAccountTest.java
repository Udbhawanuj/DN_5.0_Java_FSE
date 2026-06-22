import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(1000);
    }

    @Test
    public void testDepositUsingAAA() {
        // Arrange
        double amount = 500;

        // Act
        account.deposit(amount);

        // Assert
        assertEquals(1500, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawUsingAAA() {
        // Arrange
        double amount = 300;

        // Act
        account.withdraw(amount);

        // Assert
        assertEquals(700, account.getBalance(), 0.01);
    }

    @After
    public void tearDown() {
        account = null;
    }
}
