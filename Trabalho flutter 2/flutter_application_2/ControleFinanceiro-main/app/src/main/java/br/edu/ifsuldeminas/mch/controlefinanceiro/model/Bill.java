package br.edu.ifsuldeminas.mch.controlefinanceiro.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Bill implements Serializable {

    private Integer id;
    private String name, description, date;
    private Double value;

    public Bill() {

    }

    public Bill(Integer id, String name, String description, Double value, String date) {
        this.id = id;
        setName(name);
        setDescription(description);
        setValue(value);
        setDate(date);
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @NonNull
    @Override
    public String toString() {
        return "R$" + this.getValue() + " - " + this.getName() + " - " + this.getDate();
    }
}
