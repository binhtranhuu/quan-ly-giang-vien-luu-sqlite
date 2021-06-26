package com.example.tranhuubinh17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.tranhuubinh17dcat023.adapter.adapterChuyenMon;
import com.example.tranhuubinh17dcat023.database.database;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_ChuyenMon;

import java.util.ArrayList;

public class ManChuyenMon extends AppCompatActivity {

    ListView lvChuyenMon;
    Button btnAddChuyenMon;

    ArrayList<B17DCAT023_ChuyenMon> chuyenMonArrayList;

    adapterChuyenMon adapterChuyenMon;

    database databaseQLGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_chuyen_mon);

        databaseQLGV = new database(this);

        lvChuyenMon = findViewById(R.id.lvChuyenMon);
        btnAddChuyenMon = findViewById(R.id.btnAddChuyenMon);

        btnAddChuyenMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManChuyenMon.this, ManAddChuyenMon.class);
                startActivity(intent);
            }
        });

        chuyenMonArrayList = databaseQLGV.getAllChuyenMon();
        adapterChuyenMon = new adapterChuyenMon(getApplicationContext(), chuyenMonArrayList);
        lvChuyenMon.setAdapter(adapterChuyenMon);
    }
}