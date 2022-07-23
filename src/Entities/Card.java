package Entities;

import java.util.Date;
import java.util.Random;

public class Card {
    private String cvv;
    private Date expireDate;
    private String number;
    private String pin;
    private Account account;

    private Card(Account account, String pin)
    {
        Random rnd = new Random();
        this.cvv = String.valueOf(rnd.nextInt(900) + 100);
        this.expireDate = (new Date());
        this.number = String.valueOf(rnd.nextInt(10000));
        this.pin = pin;
        account.addCard(this);
        this.account = account;
    }

    public static Card create(Account account, String pin)
    {
        return new Card(account, pin);
    }

    //region get/set

    public String getCvv() {
        return cvv;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public Account getAccount() {
        return account;
    }
    //endregion
}
