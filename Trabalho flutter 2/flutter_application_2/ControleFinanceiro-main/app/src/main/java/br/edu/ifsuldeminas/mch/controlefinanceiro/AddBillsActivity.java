package br.edu.ifsuldeminas.mch.controlefinanceiro;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

import br.edu.ifsuldeminas.mch.controlefinanceiro.model.Bill;
import br.edu.ifsuldeminas.mch.controlefinanceiro.model.db.BillDAO;

public class AddBillsActivity extends AppCompatActivity {

    private Bill bill;

    Button btnAdd;

    ImageView btnDatePicker, btnLogo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bill_page);

        Intent chooserIntent = getIntent();
        bill = (Bill) chooserIntent.getSerializableExtra("contaEdicao");

        btnLogo = findViewById(R.id.addBillImageLogo);
        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddBillsActivity.this, MenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });


        Button btnAdicionar = findViewById(R.id.addTransactionBtnAdd);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddBillsActivity.this, "Você já está na tela de Adicionar.", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnListagem = findViewById(R.id.addBillBtnList);
        btnListagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddBillsActivity.this, ListBillsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        EditText nameTextInput = findViewById(R.id.editTextName);
        EditText descTextInput = findViewById(R.id.editTextDesc);
        EditText valueTextInput = findViewById(R.id.editTextValue);

        //deixar EditText da data sem poder clicar/editar
        EditText dateTextInput = findViewById(R.id.editTextDate);
        dateTextInput.setEnabled(false);
        dateTextInput.setFocusable(false);
        dateTextInput.setFocusableInTouchMode(false);
        dateTextInput.setInputType(InputType.TYPE_NULL);

        //DatePicker
        btnDatePicker = findViewById(R.id.btnIconDatePicker);
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bill == null) {
                    openDatePickerDialog(dateTextInput);
                } else {
                    openDatePickerDialog(dateTextInput, bill.getDate());
                }

            }
        });

        if (bill != null) {
            nameTextInput.setText(bill.getName());
            descTextInput.setText(bill.getDescription());
            dateTextInput.setText(bill.getDate());

            double value = bill.getValue();
            valueTextInput.setText(String.format(Locale.getDefault(), "%.2f", value));
        }

        btnAdd = findViewById(R.id.btnAddBill);
        btnAdd.setOnClickListener(view -> {

            String name = nameTextInput.getText().toString();
            String description = descTextInput.getText().toString();
            String date = dateTextInput.getText().toString();
            String value = valueTextInput.getText().toString().replace(",", ".");

            if (name.isEmpty() || description.isEmpty() || date.isEmpty() || value.isEmpty()) {
                Toast toast = Toast.makeText(AddBillsActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                BillDAO dao = new BillDAO(this);
                if (this.bill == null) {
                    bill = new Bill();
                    bill.setName(name);
                    bill.setDescription(description);
                    bill.setDate(date);
                    value = value.replace(",", ".");
                    bill.setValue(Double.parseDouble(value));


                    dao.save(bill);
                    Toast toast = Toast.makeText(this, "Conta salva com sucesso!", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    bill.setName(name);
                    bill.setDescription(description);
                    bill.setDate(date);
                    bill.setValue(Double.parseDouble(value));

                    dao.update(bill);
                    Toast toast = Toast.makeText(this, "Conta atualizada com sucesso!", Toast.LENGTH_LONG);
                    toast.show();
                }
                finish();
            }
        });


    }

    private void openDatePickerDialog(EditText dateTextInput, String date) {
        String[] dataSplit = date.split("/");

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dataFormatada = String.format("%02d/%02d/%d", dayOfMonth, month + 1, year);
                dateTextInput.setText(dataFormatada);
            }
        }, Integer.parseInt(dataSplit[2]), Integer.parseInt(dataSplit[1]), Integer.parseInt(dataSplit[0]));

        dialog.show();
    }

    private void openDatePickerDialog(EditText dateTextInput) {
        Calendar now = Calendar.getInstance();

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dataFormatada = String.format("%02d/%02d/%d", dayOfMonth, month + 1, year);
                dateTextInput.setText(dataFormatada);
            }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));

        dialog.show();
    }


}
