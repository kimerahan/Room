package com.a23labs.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.io.Serializable;


@Entity
public class Song_Container {
   /* public void setIdT(int idT) {
        this.idT = idT;
    }*/

    /* public class Song_Container implements Serializable {*/
   /* @PrimaryKey(autoGenerate = true)*/
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int idT;
    // private String id = null;
    private String description;

    private String link ;
    private String title ;
    private String speaker;
    private String date ;
    private String albumArtLink ;

    public Song_Container() {

    }
   public Song_Container(String URL, String songTitle, String songArtist, String songDescription,
                         String albumArt, int sermon_id) {//String releaseDate,
       link = URL;
       title = songTitle;
       speaker = songArtist;
       //date = releaseDate;
       albumArtLink = albumArt;
       description = songDescription;
       idT = sermon_id;
   }

    public void setId(int id) {
        this.id = id;
    }
    public void setIdT(int idT) {
        this.idT = idT;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAlbumArtLink(String albumArtLink) {
        this.albumArtLink = albumArtLink;
    }
    public String getDescription() {
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }

   /* public int getId() {
        return id;
    }*/
    public int getIdT() {
        return idT;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTitle() {
        return title;
    }
    public String getSpeaker() {
        return speaker;
    }
    public String getLink() {
        return link;
    }

    public int getId() {
        return id;
    }
    public String getDate() {
        return date;
    }

    public String getAlbumArtLink() {
        return albumArtLink;
    }


    /*private String albumArtLink = null;*/



   /* public Song_Container(String loadingTitle) {

        title = loadingTitle;

    }
*/
   /* public String getLink() {
        return link;
    }

    public int getsermon_id() {
        return id;
    }
    public void setSermonID(int id) {
        this.id = id;
    }
   *//* public String getsermon_id() {
        return id;
    }*//*

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return speaker;
    }
    public void setArtist(String speaker) {
        this.speaker = speaker;
    }

    public String getAlbumArt() {
        // TODO Auto-generated method stub
        return albumArtLink;
    }

*/
}
