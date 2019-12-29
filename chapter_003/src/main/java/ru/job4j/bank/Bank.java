package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<User, List<Account>> userAccounts;

    public Bank() {
        userAccounts = new HashMap<>();
    }

    public void addUser(User user) {
        userAccounts.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        userAccounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        User u = findUser(passport);
        if (u != null && userAccounts.get(u).indexOf(account) == -1) {
            userAccounts.get(u).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User u = findUser(passport);
        if (u != null) {
            userAccounts.get(u).remove(account);
        }
    }

    private User findUser(String passport) {
        User res = null;
        for (User u : userAccounts.keySet()) {
            if (u.getPassport().equals(passport)) {
                res = u;
            }
        }
        return res;
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> res;
        User u = findUser(passport);
        if (u != null) {
            res = userAccounts.get(u);
        } else {
            res = new ArrayList<>();
        }
        return res;
    }

    private Account findUserAccount(String passport, String requisites) {
        Account res = null;
        for (Account a : getUserAccounts(passport)) {
            if (a.getRequisites().equals(requisites)) {
                res = a;
                break;
            }
        }
        return res;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount)  {
        boolean result = false;
        Account src = findUserAccount(srcPassport, srcRequisite);
        Account dest = findUserAccount(destPassport, dstRequisite);
        if (src != null && dest != null) {
            result = src.transfer(dest, amount);
        }
        return result;
    }
}
