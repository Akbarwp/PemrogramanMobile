package com.example.pemrograman_mobile.pertemuan10.praktikum;

import java.text.DecimalFormat;

public class RumusKubusBola {

    private double panjang;

    public RumusKubusBola() {

    }

    public RumusKubusBola(double panjang) {
        this.panjang = panjang;
    }

    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public double rumusKubus() {
        double panjang = getPanjang();
        double hasil = panjang * panjang * panjang;
        return hasil;
    }

    public double rumusBola() {
        double panjang = getPanjang();
        double hasil = (4 * 3.14 * panjang / 3);
        return hasil;
    }
}
