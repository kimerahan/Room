package com.a23labs.room;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.a23labs.room.SampleDatabase;
import com.a23labs.room.University;
import com.a23labs.room.database.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by pluto on 7/22/17.
 */

public class MainActivity4 extends AppCompatActivity {
    SampleDatabase sampleDatabase;
    private TextView t1;
    private TextView t2;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_m);
        t1 = (TextView) findViewById(R.id.textView2);
        t2 = (TextView) findViewById(R.id.textView);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        sampleDatabase = Room.databaseBuilder(getApplicationContext(),
                SampleDatabase.class, "sample-db").build();

        new DatabaseAsync().execute();
       // fetchData();

    }

    private void fetchData() {


        StringBuilder sb = new StringBuilder();
        StringBuilder n = new StringBuilder();
        String name = "";
        String title = "";
        int sl =  0;
;
        List<University> youngUsers = sampleDatabase.daoAccess().fetchAllData();
        for (University youngUser : youngUsers) {
            name =  youngUser.getName();
            title =  youngUser.getTitle();

        }
//        t1.setText(name);
      //  t2.setText(title);
        final List<University> products = youngUsers;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(products.isEmpty())
                recyclerView.setAdapter(new ProductAdapter(products));
            }
        });
    }

    //To update only name of university, change it and pass the object along with the primary key value.

       /* university.setSlNo(1);
        university.setName("ABCUniversity");
        sampleDatabase.daoAccess().updateRecord(university);*/

    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            //Let's add some dummy data to the database.
            University university = new University();
            university.setName("Name");
            university.setTitle("Title");


            List<University> list = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                University product = new University();
                product.setName("Name " + i);
                product.setTitle("Title" + i);
                list.add(product);
            }
             sampleDatabase.daoAccess().insertMultipleRecord(list);

           // sampleDatabase.daoAccess().insertOnlySingleRecord(university);


            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.


        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //To after addition operation here.

        }

    //To delete this record set the primary key and this will delete the record matching that primary key value.
/*
        University university1 = new University();
        university.setSlNo(1);
        sampleDatabase.daoAccess().deleteRecord(university1);*/

    }

}

