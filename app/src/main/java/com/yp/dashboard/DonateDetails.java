package com.yp.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DonateDetails extends AppCompatActivity {
    TextView tvTotal;
    RecyclerView recyclerView;
    ArrayList<model1> model1s;
    adapter1 adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_details);

        recyclerView = (RecyclerView) findViewById(R.id.recView1);
        tvTotal = (TextView) findViewById(R.id.tvTotal);

        DBHelper dbHelper = new DBHelper(this);

        model1s = dbHelper.getAllDonate();
        tvTotal.setText("Total Requests:"+model1s.size());

        adapter1 = new adapter1(model1s,this);
        recyclerView.setAdapter(adapter1);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llm);

    }
}