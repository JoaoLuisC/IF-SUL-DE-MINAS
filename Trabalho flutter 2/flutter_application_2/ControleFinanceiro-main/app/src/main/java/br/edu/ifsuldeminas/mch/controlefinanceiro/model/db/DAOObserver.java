package br.edu.ifsuldeminas.mch.controlefinanceiro.model.db;

import java.util.List;

import br.edu.ifsuldeminas.mch.controlefinanceiro.model.Transaction;

public interface DAOObserver {

    default void loadOk(List<Transaction> transactions) {
    }

    default void loadError() {
    }

    default void saveOk() {
    }

    default void saveError() {
    }

    default void updateOk() {
    }

    default void updateError() {
    }

    default void deleteOk() {
    }

    default void deleteError() {
    }


}
