package br.edu.ifsuldeminas.mch.controlefinanceiro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            SharedPreferences preferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        Button btnAddBill = findViewById(R.id.btnAddBills);
        btnAddBill.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, AddBillsActivity.class);
            startActivity(intent);
        });

        Button btnAddTransaction = findViewById(R.id.btnAddTransactions);
        btnAddTransaction.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, AddTransactionActivity.class);
            startActivity(intent);
        });

        Button btnListBills = findViewById(R.id.btnListBills);
        btnListBills.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, ListBillsActivity.class);
            startActivity(intent);
        });

        Button btnListTransactions = findViewById(R.id.btnListTransactions);
        btnListTransactions.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, ListTransactionsActivity.class);
            startActivity(intent);
        });

        Button btnCoins = findViewById(R.id.btnCoinsList);
        btnCoins.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, CoinsActivity.class);
            startActivity(intent);
        });

        if (getIntent().hasExtra("USERNAME")) {
            String username = getIntent().getStringExtra("USERNAME");
            Toast.makeText(this, "Bem-vindo, " + username + "!", Toast.LENGTH_SHORT).show();
        }
    }

}
