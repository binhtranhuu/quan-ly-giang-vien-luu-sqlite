package com.example.tranhuubinh17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.tranhuubinh17dcat023.adapter.adapterGiangVien;
import com.example.tranhuubinh17dcat023.database.database;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_GiangVien;

import java.util.ArrayList;

public class ManGiangVien extends AppCompatActivity {

    ListView lvGiangVien;
    Button btnAddGiangVien;

    ArrayList<B17DCAT023_GiangVien> giangVienArrayList;

    adapterGiangVien adapterGiangVien;

    database databaseQLGV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_giang_vien);

        databaseQLGV = new database(this);

        lvGiangVien = findViewById(R.id.lvGiangVien);
        btnAddGiangVien = findViewById(R.id.btnAddGiangVien);

        btnAddGiangVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManGiangVien.this, ManAddGiangVien.class);
                startActivity(intent);
            }
        });

        giangVienArrayList = databaseQLGV.getAllGiangVien();

        adapterGiangVien = new adapterGiangVien(getApplicationContext(), giangVienArrayList);
        lvGiangVien.setAdapter(adapterGiangVien);
    }
}