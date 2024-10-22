package model.entities;

import model.exception.BusinessException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void withdraw(Double amount){

        if (amount > balance) {
            throw new BusinessException("Not enough balance");
        }

        if (amount > withdrawLimit){
            throw new BusinessException("The amount exceeds withdraw limit.");
        }

        this.balance -= amount;
    }

    @Override
    public String toString(){
        return String.format("Account: %d - Withdraw Limit: R$ %.2f - Balance: R$ %.2f", number, withdrawLimit, balance);
    }

}
