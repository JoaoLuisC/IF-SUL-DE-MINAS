package br.edu.ifsuldeminas.mch.controlefinanceiro.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.mch.controlefinanceiro.model.Bill;

public class BillDAO extends DAO {

    public BillDAO(Context context) {
        super(context);
    }

    public boolean save(Bill bill) {
        SQLiteDatabase dataBase = openToWrite();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", bill.getName());
        contentValues.put("description", bill.getDescription());
        contentValues.put("value", bill.getValue());
        contentValues.put("date", bill.getDate());

        dataBase.insert("bills", null, contentValues);

        dataBase.close();

        return true;
    }

    public List<Bill> loadBills() {
        SQLiteDatabase dataBase = openToRead();
        List<Bill> bills = new ArrayList<Bill>();
        String sql = "SELECT * FROM bills;";
        Cursor cursor = dataBase.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(
                    cursor.getColumnIndexOrThrow("name"));
            String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
            Double value = cursor.getDouble(cursor.getColumnIndexOrThrow("value"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            Bill bill = new Bill(id, name, description, value, date);
            bills.add(bill);
        }
        cursor.close();
        dataBase.close();
        return bills;
    }

    public void delete(Bill bill) {
        SQLiteDatabase dataBase = openToWrite();

        String[] params = {bill.getId().toString()};
        dataBase.delete("bills", "id = ?", params);

        dataBase.close();
    }

    public void update(Bill bill) {
        SQLiteDatabase dataBase = openToWrite();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", bill.getName());
        contentValues.put("description", bill.getDescription());
        contentValues.put("value", bill.getValue());
        contentValues.put("date", bill.getDate());

        String[] params = {bill.getId().toString()};
        dataBase.update("bills", contentValues, "id = ?", params);

        dataBase.close();
    }
}
