package br.edu.ifsuldeminas.mch.controlefinanceiro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsuldeminas.mch.controlefinanceiro.model.Bill;

public class DetailBillsActivity extends AppCompatActivity {

    private TextView detailTxtName, detailTxtValue, detailTxtDateBill, detailTxtDescription;
    private ImageButton btnShare, btnBackToList;
    private Bill bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_bill_page);

        // Referências das TextViews
        detailTxtName = findViewById(R.id.detailTxtName);
        detailTxtValue = findViewById(R.id.detailTxtValue);
        detailTxtDateBill = findViewById(R.id.detailTxtDateBill);
        detailTxtDescription = findViewById(R.id.detailTxtDescription);

        // Recebe a Bill passada pela ListActivity
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("contaDetalhada")) {
            bill = (Bill) intent.getSerializableExtra("contaDetalhada");
            populateDetails();
        }

        btnBackToList = findViewById(R.id.btnBackToList);
        btnBackToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailBillsActivity.this, ListBillsActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // Implementação do botão de compartilhar
        btnShare = findViewById(R.id.detailBtnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareBillDetails();
            }
        });
    }

    // Método para popular os TextViews com os detalhes da conta
    private void populateDetails() {
        if (bill != null) {
            detailTxtName.setText(bill.getName());
            detailTxtValue.setText(bill.getValue().toString());
            detailTxtDateBill.setText(bill.getDate());
            detailTxtDescription.setText(bill.getDescription());
        }
    }


    // Método para compartilhar os detalhes da conta
    private void shareBillDetails() {
        if (bill != null) {
            String message = String.format(
                    "-------- Financial Management -------\n" +
                            "Conta: %s\n" +
                            "Valor: R$ %.2f\n" +
                            "Data: %s\n" +
                            "Descrição: %s\n",
                    bill.getName(), bill.getValue(), bill.getDate(), bill.getDescription()
            );


            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, message);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        }
    }
}
