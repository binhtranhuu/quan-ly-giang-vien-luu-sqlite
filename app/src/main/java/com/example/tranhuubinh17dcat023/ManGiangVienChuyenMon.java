package com.example.tranhuubinh17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.tranhuubinh17dcat023.adapter.adapterChuyenMon;
import com.example.tranhuubinh17dcat023.database.database;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_ChuyenMon;

import java.util.ArrayList;

public class ManGiangVienChuyenMon extends AppCompatActivity {

    ListView lvListChuyenMon;
    Button btnAddChuyenMonGiangVien;

    ArrayList<B17DCAT023_ChuyenMon> chuyenMonArrayList;

    adapterChuyenMon adapterChuyenMon;

    database databaseQLGV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_giang_vien_chuyen_mon);

        databaseQLGV = new database(this);

        // Ánh xạ
        lvListChuyenMon = findViewById(R.id.lvListChuyenMon);
        btnAddChuyenMonGiangVien = findViewById(R.id.btnAddChuyenMonGiangVien);

        btnAddChuyenMonGiangVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManGiangVienChuyenMon.this, ManQuanLy.class);
                startActivity(intent);
            }
        });

        lvListChuyenMon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ManGiangVienChuyenMon.this, ManListGiangVienOfChuyenMon.class);
                int idChuyenMon = chuyenMonArrayList.get(position).getId();
                String tenChuyenMon = chuyenMonArrayList.get(position).getName();
                intent.putExtra("idChuyenMon", idChuyenMon);
                intent.putExtra("tenChuyenMon", tenChuyenMon);
                startActivity(intent);
            }
        });

        chuyenMonArrayList = databaseQLGV.getAllChuyenMon();
        adapterChuyenMon = new adapterChuyenMon(getApplicationContext(), chuyenMonArrayList);
        lvListChuyenMon.setAdapter(adapterChuyenMon);
    }
}