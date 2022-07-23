package Entities;

import Abstractions.Entity;

import java.util.ArrayList;
import java.util.UUID;

public class Customer extends Entity {
    private ArrayList<Account> accounts = new ArrayList<>();
    private User user;

    private Customer(User user) {
        this.user = user;
        this.user.setCustomer(this);
    }

    public void addAccount(Account account)
    {
        accounts.add(account);
    }

    public void removeAccount(Account account)
    {
        accounts.remove(account);
    }

    public static Customer create(User user)
    {
        return new Customer(user);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
