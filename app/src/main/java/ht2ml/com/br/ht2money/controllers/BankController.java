package ht2ml.com.br.ht2money.controllers;

import ht2ml.com.br.ht2money.models.Bank;
import io.realm.Realm;

public class BankController {

    public static void create(String onwer, Double balance, String name, String agency){

        Bank bank = new Bank(onwer, balance, name, agency);
        bank.save();

    }

    public static Bank get(){
        Bank info;

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Bank tmpBank = realm.where(Bank.class).findFirst();
        if(tmpBank != null){
            info = new Bank(tmpBank.getOwner(), tmpBank.getBalance(), tmpBank.getName(), tmpBank.getAgency());
        }else{
            info = null;
        }

        realm.commitTransaction();
        realm.close();

        return  info;
    }

    public static double getBalance(){
        Bank bank = get();
        if(bank != null){
            return  bank.getBalance();
        }else{
            return 0.0;
        }

    }
}
