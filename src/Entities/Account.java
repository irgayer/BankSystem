package Entities;

import Interfaces.IFinance;

import java.util.ArrayList;

public class Account {
    private ArrayList<Card> cards = new ArrayList<>();
    private Customer customer;
    private IFinance finance;

    public void addCard(Card card)
    {
        cards.add(card);
    }

    public void removeCard(Card card)
    {
        cards.remove(card);
    }

    private Account(Customer customer, IFinance finance)
    {
        customer.addAccount(this);
        this.finance = finance;
        this.customer = customer;
    }

    public static Account create(Customer customer, IFinance finance)
    {
        return new Account(customer, finance);
    }

    public Customer getCustomer() {
        return customer;
    }
}
