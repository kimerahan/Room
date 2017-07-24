package com.a23labs.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by pluto on 7/22/17.
 */
/*@Database(entities = {University.class}, version = 1)*/
@Database(entities = {Song_Container.class,University.class}, version = 1)
    public abstract class SampleDatabase extends RoomDatabase {
        public abstract DaoAccess daoAccess();
    }

//TODO