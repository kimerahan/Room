package com.a23labs.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by pluto on 7/22/17.
 */
@Dao
public  interface DaoAccessSong {

    @Insert
    void  insertMultipleData(List<Song_Container> songs);

    @Insert
    void insertMultipleListRecord(List<University> universities);

    @Insert
    void insertOnlySingleRecord(University university);

    /*@Query("SELECT * FROM University")
    List<University> fetchAllData();*/


    @Query("SELECT * FROM Song_Container ")
    List<Song_Container> fetchAllDataSong();
/*
    @Query("SELECT * FROM University WHERE clgid =:college_id")
    University getSingleRecord(int college_id);*/

    @Update
    void updateRecord(University university);

    @Update
    void updateRecordSong(Song_Container song);

    @Delete
    void deleteRecord(University university);

    @Delete
    void deleteRecordSong(Song_Container song);

    @Delete
    void deleteRecordSongList(List<Song_Container> songs);

    @Delete
    void deleteAll(List<Song_Container> notes);
}
