package com.example.bazadanych;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "zwierzeta")
public class Zwierze {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String gatunek;
    @ColumnInfo(name = "srodowisko_zycia")
    public String srodowiskoZycia;

    public boolean czyRoslinozerne;
    //true roslinnozerne
    //false wszystkozerne, mieszozerne

    public int sredniaWiek;

    public Zwierze(String gatunek, String srodowiskoZycia, boolean czyRoslinozerne, int sredniaWiek) {
        this.gatunek = gatunek;
        this.srodowiskoZycia = srodowiskoZycia;
        this.czyRoslinozerne = czyRoslinozerne;
        this.sredniaWiek = sredniaWiek;
    }

    public Zwierze() {
    }
}
