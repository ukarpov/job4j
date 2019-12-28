package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {
    @Test
    public void whenTransferSelf() {
        Bank b = new Bank();
        String u1Passport = "123456";
        b.addUser(new User("Vasia", u1Passport));
        String a1Reqs = "A123";
        Account a1 = new Account(a1Reqs);
        a1.addAmount(1000);
        b.addAccountToUser(u1Passport, a1);
        String a2Reqs = "A789";
        Account a2 = new Account(a2Reqs);
        b.addAccountToUser(u1Passport, a2);
        assertTrue(b.transferMoney(u1Passport, a1Reqs, u1Passport, a2Reqs, 400));
        assertTrue(a1.getValue() == 600 && a2.getValue() == 400);
    }

    @Test
    public void whenTransferOtherUser() {
        Bank b = new Bank();
        String u1Passport = "123456";
        b.addUser(new User("Vasia", u1Passport));
        String u2Passport = "789456";
        b.addUser(new User("Petya", u2Passport));
        String a1Reqs = "A123";
        Account a1 = new Account(a1Reqs);
        a1.addAmount(1000);
        b.addAccountToUser(u1Passport, a1);
        String a2Reqs = "A789";
        Account a2 = new Account(a2Reqs);
        b.addAccountToUser(u2Passport, a2);
        assertTrue(b.transferMoney(u1Passport, a1Reqs, u2Passport, a2Reqs, 300));
        assertTrue(a1.getValue() == 700 && a2.getValue() == 300);
    }

    @Test
    public void whenTransferNoUser() {
        Bank b = new Bank();
        String u1Passport = "123456";
        b.addUser(new User("Vasia", u1Passport));
        String a1Reqs = "A123";
        Account a1 = new Account(a1Reqs);
        a1.addAmount(1000);
        b.addAccountToUser(u1Passport, a1);
        String a2Reqs = "A789";
        Account a2 = new Account(a2Reqs);
        b.addAccountToUser(u1Passport, a2);
        assertFalse(b.transferMoney(u1Passport, a1Reqs, "NoUser", a2Reqs, 300));
        assertThat(a1.getValue(), is(1000.0));
    }

    @Test
    public void whenTransferNoAccount() {
        Bank b = new Bank();
        String u1Passport = "123456";
        b.addUser(new User("Vasia", u1Passport));
        String u2Passport = "789456";
        b.addUser(new User("Petya", u2Passport));
        String a1Reqs = "A123";
        Account a1 = new Account(a1Reqs);
        a1.addAmount(1000);
        b.addAccountToUser(u1Passport, a1);
        assertFalse(b.transferMoney(u1Passport, a1Reqs, u2Passport, "NoAccount", 300));
        assertThat(a1.getValue(), is(1000.0));
    }

    @Test
    public void whenTransferLackAmount() {
        Bank b = new Bank();
        String u1Passport = "123456";
        b.addUser(new User("Vasia", u1Passport));
        String u2Passport = "789456";
        b.addUser(new User("Petya", u2Passport));
        String a1Reqs = "A123";
        Account a1 = new Account(a1Reqs);
        a1.addAmount(1000);
        b.addAccountToUser(u1Passport, a1);
        String a2Reqs = "A789";
        Account a2 = new Account(a2Reqs);
        b.addAccountToUser(u2Passport, a2);
        assertFalse(b.transferMoney(u1Passport, a1Reqs, u2Passport, a2Reqs, 5000));
        assertTrue(a1.getValue() == 1000 && a2.getValue() == 0);
    }
}
