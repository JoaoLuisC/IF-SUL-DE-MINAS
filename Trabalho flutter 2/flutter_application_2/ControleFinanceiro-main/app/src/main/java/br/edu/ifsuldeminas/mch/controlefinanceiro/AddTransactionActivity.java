package br.edu.ifsuldeminas.mch.controlefinanceiro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import br.edu.ifsuldeminas.mch.controlefinanceiro.model.Bill;
import br.edu.ifsuldeminas.mch.controlefinanceiro.model.Transaction;
import br.edu.ifsuldeminas.mch.controlefinanceiro.model.db.BillDAO;
import br.edu.ifsuldeminas.mch.controlefinanceiro.model.db.DAOObserver;
import br.edu.ifsuldeminas.mch.controlefinanceiro.model.db.TransactionDAO;

public class AddTransactionActivity extends AppCompatActivity implements DAOObserver {

    private Transaction transaction;

    private Button btnAdd;

    private ImageView btnLogo;

    private Spinner spinnerIsento;

    private int isTaxExempt = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_transaction_page);

        Intent chooserIntent = getIntent();
        transaction = (Transaction) chooserIntent.getSerializableExtra("transacaoEdicao");

        btnLogo = findViewById(R.id.addBillImageLogo);
        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTransactionActivity.this, MenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        Button btnAdicionar = findViewById(R.id.addTransactionBtnAdd);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddTransactionActivity.this, "Você já está na tela de Adicionar.", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnListagem = findViewById(R.id.addTransactionBtnList);
        btnListagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTransactionActivity.this, ListTransactionsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        EditText amountTextInput = findViewById(R.id.editTextAmount);
        EditText descTextInput = findViewById(R.id.editTextDesc);
        EditText typeTextInput = findViewById(R.id.editTextType);

        spinnerIsento = findViewById(R.id.spinnerIsento);
        String[] options = {"Selecione uma opção", "Isento", "Não Isento"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIsento.setAdapter(adapter);
        spinnerIsento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                    ((TextView) parentView.getChildAt(0)).setTextColor(Color.GRAY);
                }
                isTaxExempt = position; // 1 para "Isento", 2 para "Não Isento"
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Caso nenhuma opção seja selecionada
            }
        });

        if (transaction != null) {
            descTextInput.setText(transaction.getDescription());
            typeTextInput.setText(transaction.getType());

            spinnerIsento.setSelection(transaction.isTaxExempt() ? 1 : 2);

            double amount = transaction.getAmount();
            amountTextInput.setText(String.format(Locale.getDefault(), "%.2f", amount));
        }

        btnAdd = findViewById(R.id.btnAddTransaction);
        btnAdd.setOnClickListener(view -> {

            String amount = amountTextInput.getText().toString().replace(",", ".");
            String description = descTextInput.getText().toString();
            String type = typeTextInput.getText().toString();

            if (amount.isEmpty() || description.isEmpty() || type.isEmpty() || isTaxExempt == 0) {
                Toast toast = Toast.makeText(AddTransactionActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                TransactionDAO dao = new TransactionDAO(this);
                if (this.transaction == null) {
                    transaction = new Transaction();
                    transaction.setDescription(description);
                    transaction.setType(type);
                    transaction.setTaxExempt(isTaxExempt == 1);

                    amount = amount.replace(",", ".");
                    transaction.setAmount(Double.parseDouble(amount));


                    dao.save(transaction);
                } else {
                    transaction.setDescription(description);
                    transaction.setType(type);
                    transaction.setTaxExempt(isTaxExempt == 1);
                    amount = amount.replace(",", ".");
                    transaction.setAmount(Double.parseDouble(amount));

                    dao.update(transaction);
                }
                finish();
            }
        });

    }

    @Override
    public void saveOk() {
        Toast toast = Toast.makeText(this,
                "Transação salva com sucesso!", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void saveError() {
        Toast toast = Toast.makeText(this,
                "Transação não pode ser salva!", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void updateOk() {
        Toast toast = Toast.makeText(this,
                "Transação atualizada com sucesso!", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void updateError() {
        Toast toast = Toast.makeText(this,
                "Transação não pode ser atualizada!", Toast.LENGTH_LONG);
        toast.show();
    }
}
