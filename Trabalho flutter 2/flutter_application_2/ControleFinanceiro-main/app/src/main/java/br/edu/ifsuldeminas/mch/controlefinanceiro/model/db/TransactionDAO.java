package br.edu.ifsuldeminas.mch.controlefinanceiro.model.db;


import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifsuldeminas.mch.controlefinanceiro.model.Transaction;

public class TransactionDAO {

    private final FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private final DAOObserver observer;

    private static final String COLLECTION = "transactions";
    private static final String AMOUNT = "amount";
    private static final String DESCRIPTION = "description";
    private static final String TYPE = "type";
    private static final String ISTAXEXEMPT = "isTaxExempt";

    public TransactionDAO(DAOObserver observer) {
        this.observer = observer;
    }

    private Map<String, Object> transactionToMap(Transaction transaction) {
        Map<String, Object> map = new HashMap<>();
        map.put(AMOUNT, transaction.getAmount());
        map.put(DESCRIPTION, transaction.getDescription());
        map.put(TYPE, transaction.getType());
        map.put(ISTAXEXEMPT, transaction.isTaxExempt());
        return map;
    }

    public boolean save(Transaction transaction) {

        Map<String, Object> transactionAsMap = transactionToMap(transaction);
        firestore.collection(COLLECTION).add(transactionAsMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                observer.saveOk();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                observer.saveError();
            }
        });

        return true;
    }

    public void loadTransactions() {
        firestore.collection(COLLECTION).orderBy(AMOUNT, Query.Direction.ASCENDING).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<QuerySnapshot> taskSnap) {

                if (taskSnap.isSuccessful()) {
                    List<Transaction> transactions = new ArrayList<>();
                    for (QueryDocumentSnapshot doc : taskSnap.getResult()) {
                        String id = doc.getId();
                        Double amount = doc.get(AMOUNT, Double.class);
                        String description = doc.get(DESCRIPTION, String.class);
                        String type = doc.get(TYPE, String.class);
                        Boolean isTaxExempt = doc.get(ISTAXEXEMPT, Boolean.class);

                        Transaction transaction = new Transaction(id, amount, description, type, isTaxExempt);

                        transactions.add(transaction);
                    }

                    observer.loadOk(transactions);
                } else {
                    // Não há tarefas no banco...
                    Exception exception = taskSnap.getException();
                    if (exception != null) {
                        Log.d("Firestore Error", "Erro ao carregar dados: ", exception);
                    }
                    observer.loadError();
                }
            }
        });

    }

    public void delete(Transaction transaction) {

        firestore.collection(COLLECTION).document(transaction.getId()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                observer.deleteOk();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                observer.deleteError();
            }
        });
    }

    public void update(Transaction transaction) {
        Map<String, Object> transactionAsMap = transactionToMap(transaction);

        firestore.collection(COLLECTION).document(transaction.getId()).update(transactionAsMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                observer.updateOk();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                observer.updateError();
            }
        });

    }
}
