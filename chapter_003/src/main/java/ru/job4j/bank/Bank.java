package ru.job4j.bank;

import java.util.*;

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
        Optional<User> optUser = userAccounts.keySet().stream().filter(u -> u.getPassport().equals(passport)).findAny();
        if (optUser.isPresent()) {
            res = optUser.get();
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
        Optional<Account> optAcc = getUserAccounts(passport).stream().filter(a -> a.getRequisites().equals(requisites)).findAny();
        if (optAcc.isPresent()) {
            res = optAcc.get();
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
