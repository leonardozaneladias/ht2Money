package ht2ml.com.br.ht2money.models;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Bank extends RealmObject {

    @PrimaryKey
    @Required
    private String id = UUID.randomUUID().toString();
    private String owner;
    private Double balance;
    private String name;
    private String agency;

    public Bank() {
    }

    public Bank(String id, String owner, Double balance, String name, String agency) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.name = name;
        this.agency = agency;
    }

    public Bank(String owner, Double balance, String name, String agency) {
        this.owner = owner;
        this.balance = balance;
        this.name = name;
        this.agency = agency;
    }

    public void save(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        realm.copyToRealm(this);

        realm.commitTransaction();
        realm.close();
    }


    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
