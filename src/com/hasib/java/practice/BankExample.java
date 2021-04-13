package com.hasib.java.practice;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

public class BankExample {
    public static void main(String[] args) {
        Bank_Account bank_account = new Bank_Account();
        Bank_Account bank_account1 = new Bank_Account("XYZ", 2018_331_120L, 10_000);
        Bank_Account bank_account2 = new Bank_Account(bank_account1);

        System.out.println(bank_account);
        System.out.println(bank_account1);
        System.out.println(bank_account2);
    }
}

class Bank_Account {
    private String Name;
    private Long AC_No;
    private Integer Amount;

    public Bank_Account() {
        this.Name = "";
        this.AC_No = 0L;
        this.Amount = 0;
    }

    public Bank_Account(String name, Long AC_No, Integer amount) {
        Name = name;
        this.AC_No = AC_No;
        Amount = amount;
    }

    public Bank_Account(Bank_Account bank_account) {
        this.Name = bank_account.getName();
        this.AC_No = bank_account.getAC_No();
        this.Amount = bank_account.getAmount();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getAC_No() {
        return AC_No;
    }

    public void setAC_No(Long AC_No) {
        this.AC_No = AC_No;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Bank_Account{" +
                "Name='" + Name + '\'' +
                ", AC_No=" + AC_No +
                ", Amount=" + Amount +
                '}';
    }
}
