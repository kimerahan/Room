package com.a23labs.room;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.a23labs.room.database.MyDatabase;

/**
 * Created by gonzalo on 7/14/17
 */

public class App extends Application {

    public static App INSTANCE;
    private static final String DATABASE_NAME = "MyDatabase";

    private MyDatabase database;

    public static App get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // create database
        database = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, DATABASE_NAME).build();

        INSTANCE = this;
    }

    public MyDatabase getDB() {
        return database;
    }

}
