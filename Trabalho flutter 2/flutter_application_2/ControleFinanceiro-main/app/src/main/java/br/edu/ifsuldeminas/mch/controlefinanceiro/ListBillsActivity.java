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

import br.edu.ifsuldeminas.mch.controlefinanceiro.model.Bill;
import br.edu.ifsuldeminas.mch.controlefinanceiro.model.db.BillDAO;

public class ListBillsActivity extends AppCompatActivity {

    ListView billsList;

    ImageView btnLogo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill_list_page);

        billsList = findViewById(R.id.bill_list);
        registerForContextMenu(billsList);

        btnLogo = findViewById(R.id.listBillImageLogo);
        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBillsActivity.this, MenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        Button btnAdicionar = findViewById(R.id.listBillBtnAdd);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBillsActivity.this, AddBillsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        Button btnListagem = findViewById(R.id.listBillBtnList);
        btnListagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // O botão Listagem já está na ListActivity, não faz sentido criar uma nova Intent para a mesma Activity
                Toast.makeText(ListBillsActivity.this, "Você já está na tela de Listagem.", Toast.LENGTH_SHORT).show();
            }
        });

        billsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bill bill = (Bill) billsList.getItemAtPosition(position);

                Intent intent = new Intent(ListBillsActivity.this, DetailBillsActivity.class);
                intent.putExtra("contaDetalhada", bill);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateBills();
    }

    private void updateBills() {
        BillDAO dao = new BillDAO(this);
        List<Bill> billList = dao.loadBills();

        ArrayAdapter<Bill> arrayAdapter = new ArrayAdapter<>(this, R.layout.item_list_style, R.id.text1, billList);
        billsList.setAdapter(arrayAdapter);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem itemDelete = menu.add("Deletar Conta");
        itemDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                AdapterView.AdapterContextMenuInfo itemClicado = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Bill bill = (Bill) billsList.getItemAtPosition(itemClicado.position);

                BillDAO dao = new BillDAO(ListBillsActivity.this);

                dao.delete(bill);
                updateBills();

                Toast toast = Toast.makeText(ListBillsActivity.this, "Conta deletada com sucesso!", Toast.LENGTH_SHORT);
                toast.show();

                return true;
            }
        });

        MenuItem itemDetail = menu.add("Editar Conta");
        itemDetail.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                AdapterView.AdapterContextMenuInfo itemClicado = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Bill bill = (Bill) billsList.getItemAtPosition(itemClicado.position);

                Intent intent = new Intent(ListBillsActivity.this, AddBillsActivity.class);
                intent.putExtra("contaEdicao", bill);
                startActivity(intent);

                return true;
            }
        });
    }
}
