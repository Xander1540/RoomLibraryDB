package com.example.roomlibraryx;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText edtTitle, edtAmount;
Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTitle = findViewById(R.id.edtTitle);
        edtAmount = findViewById(R.id.edtAmount);
        btnAdd = findViewById(R.id.btnAdd);

        DBHelper dbHelper = DBHelper.getDB(this);

        btnAdd.setOnClickListener(v -> {
            String title = edtTitle.getText().toString();
            String amount = edtAmount.getText().toString();

            dbHelper.expenseDao().addTx(
                    new Expense(title, amount)
            );

            ArrayList<Expense> arrExpenses = (ArrayList<Expense>) dbHelper.expenseDao().getAllExpense();

            for(int i=0; i<arrExpenses.size(); i++){
                Log.d("Data","Title: "+arrExpenses.get(i).getTitle() + " Amount: "+arrExpenses.get(i).getAmount());

            }
        });

    }
}