package com.example.bazadanych;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Zwierze.class},version = 1) //na 6 jakies relacje(klasa relacyjna) i wiecej po przecinku
public abstract class ZwierzeDataBase extends RoomDatabase {
    public abstract ZwierzeDAO zwrocZwierzeDao();
}
