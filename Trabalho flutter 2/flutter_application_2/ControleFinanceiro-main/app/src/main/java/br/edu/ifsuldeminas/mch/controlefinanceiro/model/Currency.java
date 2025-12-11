package br.edu.ifsuldeminas.mch.controlefinanceiro.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Currency implements Serializable {
    private String code;
    private String codein;
    private String name;
    private String bid;

    public String getCode() {
        return code;
    }

    public String getCodein() {
        return codein;
    }

    public String getName() {
        return name;
    }

    public String getBid() {
        return bid;
    }

    @NonNull
    @Override
    public String toString() {
        double bidValue;
        try {
            bidValue = Double.parseDouble(bid);
        } catch (NumberFormatException e) {
            bidValue = 0.0;
        }

        // Separar o nome antes e depois da barra
        String[] parts = name.split("/");
        String firstCoin = parts[0].trim();
        String otherCoin = parts.length > 1 ? parts[1].trim() : "";

        return String.format("1 %s (%s) | %.2f %s (%s)",code, firstCoin, bidValue, codein, otherCoin);
    }
}
