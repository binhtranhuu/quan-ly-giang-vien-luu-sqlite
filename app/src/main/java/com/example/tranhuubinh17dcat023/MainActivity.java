package com.example.tranhuubinh17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTimKiem, btnGiangVien, btnChuyenMon, btnQuanLy, btnThongKe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTimKiem = findViewById(R.id.btnTimKiem);
        btnGiangVien = findViewById(R.id.btnGiangVien);
        btnChuyenMon = findViewById(R.id.btnChuyenMon);
        btnQuanLy = findViewById(R.id.btnQuanLy);
        btnThongKe = findViewById(R.id.btnThongKe);

        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManTimKiem.class);
                startActivity(intent);
            }
        });

        btnGiangVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManGiangVien.class);
                startActivity(intent);
            }
        });

        btnChuyenMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManChuyenMon.class);
                startActivity(intent);
            }
        });

        btnQuanLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManGiangVienChuyenMon.class);
                startActivity(intent);
            }
        });

        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManThongKe.class);
                startActivity(intent);
            }
        });
    }
}