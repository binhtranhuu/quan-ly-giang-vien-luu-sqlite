package com.example.tranhuubinh17dcat023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tranhuubinh17dcat023.database.database;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_GiangVien;

public class ManAddGiangVien extends AppCompatActivity {

    EditText edTenGV;
    Button btnThemGV;
    String ar1[] = {"Giao Su", "Tien Si", "Thac Si", "Cu Nhan"};
    String ar2[] = {"1 nam", "2 nam", "3 nam", "4 nam", "5 nam"};
    Spinner spTrinhDoGV, spKinhNghiemGV;

    database databaseQLGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_add_giang_vien);

        databaseQLGV = new database(this);

        AnhXa();

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, ar1);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spTrinhDoGV.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, ar2);
        adapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spKinhNghiemGV.setAdapter(adapter2);

        btnThemGV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B17DCAT023_GiangVien giangVien = new B17DCAT023_GiangVien(
                        edTenGV.getText().toString().trim(),
                        spTrinhDoGV.getSelectedItem().toString().trim(),
                        spKinhNghiemGV.getSelectedItem().toString().trim()
                );

                databaseQLGV.addGiangVien(giangVien);
                Toast.makeText(ManAddGiangVien.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ManAddGiangVien.this, ManGiangVien.class);
                finish();
                startActivity(intent);
            }
        });

    }

    private void AnhXa() {
        edTenGV = findViewById(R.id.edTenGV);
        spTrinhDoGV = findViewById(R.id.spTrinhDoGV);
        spKinhNghiemGV = findViewById(R.id.spKinhNghiemGV);
        btnThemGV = findViewById(R.id.btnThemGV);
    }
}