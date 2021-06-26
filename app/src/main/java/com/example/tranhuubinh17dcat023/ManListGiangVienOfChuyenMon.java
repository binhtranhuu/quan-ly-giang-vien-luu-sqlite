package com.example.tranhuubinh17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tranhuubinh17dcat023.adapter.adapterGiangVien;
import com.example.tranhuubinh17dcat023.database.database;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_GiangVien;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_GiangVienChuyenMon;

import java.util.ArrayList;

public class ManListGiangVienOfChuyenMon extends AppCompatActivity {

    TextView tvChuyenMon;
    ListView lvGiangVienOfChuyenMon;

    ArrayList<B17DCAT023_GiangVienChuyenMon> giangVienChuyenMons;
    ArrayList<B17DCAT023_GiangVien> giangVienArrayList = new ArrayList<>();

    database databaseQLGV;

    adapterGiangVien adapterGiangVien;

    int idChuyenMon;
    String tenChuyenMon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_list_giang_vien_of_chuyen_mon);

        databaseQLGV = new database(this);

        Intent intent = getIntent();
        idChuyenMon = intent.getIntExtra("idChuyenMon", 1);
        tenChuyenMon = intent.getStringExtra("tenChuyenMon");

        AnhXa();

        tvChuyenMon.setText(tenChuyenMon);
        listGiangVienOfChuyenMon();
    }

    private void listGiangVienOfChuyenMon() {
        giangVienChuyenMons = databaseQLGV.getAllGiangVienChuyenMon();

        for (int i = giangVienChuyenMons.size() - 1; i >= 0; i--) {
            if (giangVienChuyenMons.get(i).getChuyenmon_id() == idChuyenMon) {
                B17DCAT023_GiangVien temp = databaseQLGV.getGiangVienById(giangVienChuyenMons.get(i).getGiangvien_id());
                giangVienArrayList.add(temp);
            }
        }

        adapterGiangVien = new adapterGiangVien(getApplicationContext(), giangVienArrayList);
        lvGiangVienOfChuyenMon.setAdapter(adapterGiangVien);
    }

    private void AnhXa() {
        tvChuyenMon = findViewById(R.id.tvChuyenMon);
        lvGiangVienOfChuyenMon = findViewById(R.id.lvGiangVienOfChuyenMon);
    }
}