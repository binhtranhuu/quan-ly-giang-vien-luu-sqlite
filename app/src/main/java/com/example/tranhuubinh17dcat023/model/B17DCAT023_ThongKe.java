package com.example.tranhuubinh17dcat023.model;

public class B17DCAT023_ThongKe {
    private int id;
    private String name;
    private String total;

    public B17DCAT023_ThongKe(int id, String name, String total) {
        this.id = id;
        this.name = name;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
