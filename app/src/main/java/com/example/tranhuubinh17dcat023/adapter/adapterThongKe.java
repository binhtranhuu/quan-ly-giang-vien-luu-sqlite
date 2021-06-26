package com.example.tranhuubinh17dcat023.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tranhuubinh17dcat023.R;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_ThongKe;

import java.util.ArrayList;

public class adapterThongKe extends BaseAdapter {

    private Context context;
    private ArrayList<B17DCAT023_ThongKe> thongKeArrayList;

    public adapterThongKe(Context context, ArrayList<B17DCAT023_ThongKe> thongKeArrayList) {
        this.context = context;
        this.thongKeArrayList = thongKeArrayList;
    }

    @Override
    public int getCount() {
        return thongKeArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return thongKeArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.thongke, null);

        TextView tvTenGiangVien = (TextView) convertView.findViewById(R.id.tvTenGiangVien);
        TextView tvSoLuongCM = (TextView) convertView.findViewById(R.id.tvSoLuongCM);

        B17DCAT023_ThongKe thongKe = thongKeArrayList.get(position);

        tvTenGiangVien.setText(thongKe.getName());
        tvSoLuongCM.setText(thongKe.getTotal());

        return convertView;
    }
}
