package com.example.pemrograman_mobile.pertemuan9;

public class nilaiMahasiswa {

    private double tgs,uts,uas;

    public double getTgs() {
        return tgs;
    }

    public void setTgs(double tgs) {
        this.tgs = tgs;
    }

    public double getUts() {
        return uts;
    }

    public void setUts(double uts) {
        this.uts = uts;
    }

    public double getUas() {
        return uas;
    }

    public void setUas(double uas) {
        this.uas = uas;
    }

    public double getNilai(){
        double NA = (0.3 * uts)+(0.3 * uas)+(0.4*tgs);
        return NA;
    }
}
