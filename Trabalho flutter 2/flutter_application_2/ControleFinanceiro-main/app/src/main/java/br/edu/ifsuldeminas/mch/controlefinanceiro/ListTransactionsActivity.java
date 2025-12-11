package br.edu.ifsuldeminas.mch.controlefinanceiro;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.edu.ifsuldeminas.mch.controlefinanceiro.model.Transaction;
import br.edu.ifsuldeminas.mch.controlefinanceiro.model.db.DAOObserver;
import br.edu.ifsuldeminas.mch.controlefinanceiro.model.db.TransactionDAO;

public class ListTransactionsActivity extends AppCompatActivity implements DAOObserver {

    ListView transactionsList;

    ImageView btnLogo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction_list_page);

        transactionsList = findViewById(R.id.transactions_list);
        registerForContextMenu(transactionsList);

        btnLogo = findViewById(R.id.listTransactionImageLogo);
        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTransactionsActivity.this, MenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        Button btnAdicionar = findViewById(R.id.listTransactionBtnAdd);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTransactionsActivity.this, AddTransactionActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        Button btnListagem = findViewById(R.id.listTransactionBtnList);
        btnListagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListTransactionsActivity.this, "Você já está na tela de Listagem.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTransactions();
    }

    private void updateTransactions() {
        TransactionDAO dao = new TransactionDAO(this);
        dao.loadTransactions();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuItem itemDelete = menu.add("Deletar transação");
        itemDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo itemClicado =
                        (AdapterView.AdapterContextMenuInfo) menuInfo;
                Transaction transaction = (Transaction)
                        transactionsList.getItemAtPosition(itemClicado.position);

                TransactionDAO dao = new TransactionDAO(ListTransactionsActivity.this);
                dao.delete(transaction);

                updateTransactions();

                return true;
            }
        });

        MenuItem itemEdit = menu.add("Editar transação");
        itemEdit.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                AdapterView.AdapterContextMenuInfo itemClicado =
                        (AdapterView.AdapterContextMenuInfo) menuInfo;
                Transaction transaction = (Transaction)
                        transactionsList.getItemAtPosition(itemClicado.position);

                Intent intent = new Intent(ListTransactionsActivity.this, AddTransactionActivity.class);
                intent.putExtra("transacaoEdicao", transaction);
                startActivity(intent);

                return true;
            }
        });
    }

    @Override
    public void loadOk(List<Transaction> transaction) {
        ArrayAdapter<Transaction> arrayAdapter =
                new ArrayAdapter<>(this, R.layout.item_list_style, R.id.text1, transaction);

        transactionsList.setAdapter(arrayAdapter);
    }

    @Override
    public void loadError() {
        Toast.makeText(this, "Erro ao carregar dados", Toast.LENGTH_LONG).show();
    }

    @Override
    public void deleteOk() {
        Toast t = Toast.makeText(ListTransactionsActivity.this, "Transação excluída com sucesso!", Toast.LENGTH_LONG);
        t.show();
    }

    @Override
    public void deleteError() {
        Toast t = Toast.makeText(ListTransactionsActivity.this, "Transação não pode ser excluída!", Toast.LENGTH_LONG);
        t.show();
    }

}
