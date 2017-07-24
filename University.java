package com.a23labs.room;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by pluto on 7/22/17.
 */

@Entity
public class University {


        @PrimaryKey(autoGenerate = true)
        private int slNo;
        private String name;
        private String title;

       /* @Embedded(prefix = "clg")
        College college;*/

        public int getSlNo() {
            return slNo;
        }

        public void setSlNo(int slNo) {
            this.slNo = slNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
        return title;
    }

        public void setTitle(String title) {
        this.title = title;
    }

       /* public College getCollege() {
            return college;
        }

        public void setCollege(College college) {
            this.college = college;
        }

*/
   /* public static class College {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }*/

}
