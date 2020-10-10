package com.batiknesia.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Batik implements Parcelable {

    private String nama;
    private String ciri;
    private String deskripsi;
    private Integer foto;



    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCiri() {
        return ciri;
    }

    public void setCiri(String ciri) {
        this.ciri = ciri;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.ciri);
        dest.writeString(this.deskripsi);
        dest.writeValue(this.foto);
    }

    public Batik() {
    }

    protected Batik(Parcel in) {
        this.nama = in.readString();
        this.ciri = in.readString();
        this.deskripsi = in.readString();
        this.foto = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Batik> CREATOR = new Parcelable.Creator<Batik>() {
        @Override
        public Batik createFromParcel(Parcel source) {
            return new Batik(source);
        }

        @Override
        public Batik[] newArray(int size) {
            return new Batik[size];
        }
    };
}
