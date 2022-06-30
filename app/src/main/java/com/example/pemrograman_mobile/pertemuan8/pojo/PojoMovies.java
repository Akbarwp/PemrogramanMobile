package com.example.pemrograman_mobile.pertemuan8.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class PojoMovies implements Parcelable {
    // Parcelable: meengirimkan data dalam jumlah besar dengan satu kali kirim
    // Parcelable: meengirimkan data berupa Object dari activity 1 ke activity lain

    // deklarasi variabel dari data movie
    private String title, releaseDate, desc, review;
    private int poster;

    // Constractor (shortcut: alt + ins)
    public PojoMovies() {
    }
    // Constractor yang dimodifikasi dengan Parcel
    public PojoMovies(Parcel parcel) {
        this.title = parcel.readString();
        this.releaseDate = parcel.readString();
        this.desc = parcel.readString();
        this.review = parcel.readString();
        this.poster = parcel.readInt();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public static final Creator<PojoMovies> CREATOR = new Creator<PojoMovies>() {
        @Override
        public PojoMovies createFromParcel(Parcel in) {
            return new PojoMovies(in);
        }

        @Override
        public PojoMovies[] newArray(int size) {
            return new PojoMovies[size];
        }
    };

    @Override
    public int describeContents() {
        return hashCode();
    }

    // Add data yang akan dikirim
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(releaseDate);
        parcel.writeString(desc);
        parcel.writeString(review);
        parcel.writeInt(poster);
    }
}
