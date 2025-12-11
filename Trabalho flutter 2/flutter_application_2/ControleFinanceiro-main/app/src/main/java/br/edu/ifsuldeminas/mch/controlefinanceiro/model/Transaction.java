package br.edu.ifsuldeminas.mch.controlefinanceiro.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Transaction implements Serializable {

    private String id;
    private Double amount;
    private String description;
    private String type;
    private boolean isTaxExempt;


    public Transaction() {
    }

    public Transaction(String id, Double amount, String description, String type, Boolean isTaxExempt) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.isTaxExempt = isTaxExempt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isTaxExempt() {
        return isTaxExempt;
    }

    public void setTaxExempt(boolean taxExempt) {
        isTaxExempt = taxExempt;
    }

    @NonNull
    @Override
    public String toString() {
        return
                "R$" + amount +
                        " - " + description + "\n" +
                        (isTaxExempt ? "Isenta" : "Não Isenta") + " - " + type;
    }

}
