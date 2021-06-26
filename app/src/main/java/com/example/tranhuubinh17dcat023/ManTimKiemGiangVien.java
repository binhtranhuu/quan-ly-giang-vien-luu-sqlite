package com.example.tranhuubinh17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tranhuubinh17dcat023.adapter.adapterGiangVien;
import com.example.tranhuubinh17dcat023.database.database;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_GiangVien;

import java.util.ArrayList;

public class ManTimKiemGiangVien extends AppCompatActivity {

    TextView tvTextSearch;
    ListView lvKQTimKiem;

    ArrayList<B17DCAT023_GiangVien> giangVienArrayList;
    ArrayList<B17DCAT023_GiangVien> giangVienArrayList1 = new ArrayList<>();

    adapterGiangVien adapterGiangVien;

    database databaseQLSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_tim_kiem_giang_vien);

        databaseQLSV = new database(this);

        Intent intent = getIntent();
        String textSearch = intent.getStringExtra("textSearch");

        tvTextSearch = (TextView) findViewById(R.id.tvTextSearch);
        lvKQTimKiem = (ListView) findViewById(R.id.lvKQTimKiem);

        tvTextSearch.setText(textSearch);

        // Hiển thị kết quả search
        giangVienArrayList = databaseQLSV.getGiangVienByName(textSearch);
//        for (int i=0; i<studentArrayList.size(); i++){
//            if (studentArrayList.get(i).getYear().equals("Nam 2")){
//                studentNam2ArrayList.add(studentArrayList.get(i));
//            }
//        }

        adapterGiangVien = new adapterGiangVien(getApplicationContext(), giangVienArrayList);
        lvKQTimKiem.setAdapter(adapterGiangVien);
    }
}