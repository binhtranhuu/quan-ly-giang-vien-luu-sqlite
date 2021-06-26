package com.example.tranhuubinh17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tranhuubinh17dcat023.adapter.adapterThongKe;
import com.example.tranhuubinh17dcat023.database.database;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_GiangVien;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_ThongKe;

import java.util.ArrayList;

public class ManThongKe extends AppCompatActivity {

    ListView lvThongKe;

    ArrayList<B17DCAT023_GiangVien> giangVienArrayList;
    ArrayList<B17DCAT023_ThongKe> thongKeArrayList;

    adapterThongKe adapterThongKe;

    database databaseQLGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_thong_ke);

        databaseQLGV = new database(this);

        lvThongKe = findViewById(R.id.lvThongKe);

        thongKeArrayList = new ArrayList<>();

        giangVienArrayList = databaseQLGV.getAllGiangVien();
        for (int i = giangVienArrayList.size() - 1; i >= 0; i--) {
            int id = giangVienArrayList.get(i).getId();
            String name = giangVienArrayList.get(i).getName();
            int sum = databaseQLGV.getTotalChuyenMonByGiangVienId(giangVienArrayList.get(i).getId());
            thongKeArrayList.add(new B17DCAT023_ThongKe(id, name, Integer.toString(sum)));
        }

        adapterThongKe = new adapterThongKe(getApplicationContext(), thongKeArrayList);
        lvThongKe.setAdapter(adapterThongKe);
    }
}