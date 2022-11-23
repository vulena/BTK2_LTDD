package com.ltdd.bktso2;

public class Member {
    String tenkhoahoc,tenthuonggoi,dactinh,congdung,lieudung,luuy;
    int hinhAnh;

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public String getTenthuonggoi() {
        return tenthuonggoi;
    }

    public void setTenthuonggoi(String nghedanh) {
        this.tenthuonggoi = tenthuonggoi;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public String getCongdung() {

        return congdung;
    }

    public void setCongdung(String congdung) {
        this.congdung = congdung;
    }
    public String getLieudung() {

        return lieudung;
    }

    public void setLieudung(String lieudung) {
        this.congdung = lieudung;
    }
    public String getLuuy() {

        return luuy;
    }

    public void setLuuy(String luuy) {
        this.luuy = luuy;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Member(String tenkhoahoc, String tenthuonggoi, String dactinh, String mausac, int hinhAnh) {
        this.tenkhoahoc = tenkhoahoc;
        this.tenthuonggoi = tenthuonggoi;
        this.dactinh = dactinh;
        this.congdung = congdung;
        this.lieudung = lieudung;
        this.luuy = luuy;
        this.hinhAnh = hinhAnh;
    }
}
