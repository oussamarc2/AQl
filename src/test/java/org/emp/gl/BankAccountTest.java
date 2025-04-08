package org.emp.gl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0, 0.05);
    }

    @Test
    void depositShouldIncreaseBalance() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void depositShouldThrowExceptionForNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }

    @Test
    void withdrawShouldThrowExceptionForNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20.0));
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void withdrawShouldThrowExceptionForInsufficientBalance() {
        Exception exception = assertThrows(IllegalStateException.class, () -> account.withdraw(200.0));
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    void transferShouldMoveMoneyBetweenAccounts() {
        BankAccount recipient = new BankAccount(50.0, 0.05);
        account.transfer(30.0, recipient);
        assertEquals(70.0, account.getBalance());
        assertEquals(80.0, recipient.getBalance());
    }

    @Test
    void transferShouldThrowExceptionIfRecipientIsNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> account.transfer(20.0, null));
        assertEquals("Other account must not be null", exception.getMessage());
    }

    @Test
    void addInterestShouldIncreaseBalanceByInterestRate() {
        account.addInterest();
        assertEquals(105.0, account.getBalance());
    }
}
