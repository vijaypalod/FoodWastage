package com.yp.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class DonateForm extends AppCompatActivity {

    TextInputLayout name, email, mobile, address,quantity;
    Spinner spnSelector;
    Button submitBtn;
    DBHelper DB;
    private String date = "";
    private String selectedFood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_form);

        name = (TextInputLayout) findViewById(R.id.name);
        email = (TextInputLayout) findViewById(R.id.email);
        mobile = (TextInputLayout) findViewById(R.id.mobile);
        address = (TextInputLayout) findViewById(R.id.address);
        quantity = (TextInputLayout) findViewById(R.id.quantity);
        submitBtn = (Button) findViewById(R.id.donSubmit);
        DB = new DBHelper(this);

        spnSelector = (Spinner) findViewById(R.id.spnSelector);
        String[] spinnerItems = getResources().getStringArray(R.array.spinner_item);

        spnSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedFood = spinnerItems[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dName = name.getEditText().getText().toString();
                String dEmail = email.getEditText().getText().toString();
                String dMobile = mobile.getEditText().getText().toString();
                String dAddress = address.getEditText().getText().toString();
                String dQuantity = quantity.getEditText().getText().toString();

                if (dName.equals("") || dEmail.equals("") || dMobile.equals("") || dAddress.equals("") || date.equals("") || selectedFood.equals("") || quantity.equals("")) {
                    Toast.makeText(DonateForm.this, "Please Enter all the Fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean dInsert = DB.insertDonate(dName, dEmail, dMobile, dAddress, date, selectedFood,dQuantity);
                    if (dInsert == true) {
                        Toast.makeText(DonateForm.this, "Request Placed Successful", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(DonateForm.this, "Request Failed! Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void showDatePicker(View view) {
        TextView tvDate = findViewById(R.id.tvDate);
        DatePickerDialog dialog = new DatePickerDialog(this);
        dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date = String.format("%d/%d/%d", dayOfMonth, month, year);
                tvDate.setText(date);
            }
        });
        dialog.show();
    }
}