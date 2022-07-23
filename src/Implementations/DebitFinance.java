package Implementations;

import Interfaces.IFinance;

public class DebitFinance implements IFinance {
    private int balance;

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int addBalance(int sum) {
        balance += sum;
        return balance;
    }

    @Override
    public int subtractBalance(int sum) {
        balance -= sum;
        return balance;
    }
}
