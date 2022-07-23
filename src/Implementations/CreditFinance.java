package Implementations;

import Interfaces.IFinance;

public class CreditFinance implements IFinance {
    private int balance;

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int addBalance(int sum) {
        throw new IllegalArgumentException();
    }

    @Override
    public int subtractBalance(int sum) {
        balance -= sum * 0.05;
        return balance;
    }
}
