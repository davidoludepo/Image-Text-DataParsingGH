package com.icdatofcusgmail.image_text_dataparsinggh;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DAVID OGUNDEPO on 05/09/2017.
 */

public class WorldPopulation implements Parcelable{

    private String rank;
    private String country;
    private String population;
    private int flag;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public static Creator<WorldPopulation> getCREATOR() {
        return CREATOR;
    }


    boolean selected = true;


    public WorldPopulation(String country, String population, String rank, int flag) {
        super();
        this.rank = rank;
        this.country = country;
        this.population = population;
        this.flag = flag;
    }

    protected WorldPopulation(Parcel in) {
        rank = in.readString();
        country = in.readString();
        population = in.readString();
        flag = in.readInt();
    }

    public static final Creator<WorldPopulation> CREATOR = new Creator<WorldPopulation>() {
        @Override
        public WorldPopulation createFromParcel(Parcel in) {
            return new WorldPopulation(in);
        }

        @Override
        public WorldPopulation[] newArray(int size) {
            return new WorldPopulation[size];
        }
    };

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rank);
        dest.writeString(country);
        dest.writeString(population);
        dest.writeInt(flag);
    }
}
