package com.a23labs.room;

import android.arch.persistence.room.Room;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Song_Container> sermonList = new ArrayList<Song_Container>();
    // List<Book> messageItems = new ArrayList<Book>();
    RecyclerView recyclerView;
    String API_ENDPOINT = "v1/sermons?folderId=2&page=";//+ page
    View sermonView;
    SampleDatabase sampleDatabase;
    View contex;
    List<University> list = new ArrayList<>();
    private SermonsAdapter_Container mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sermons_listview_container);

        recyclerView = (RecyclerView) findViewById(R.id.gridView_container);
        sampleDatabase = Room.databaseBuilder(getApplicationContext(),
                SampleDatabase.class, "sample-db").build();

        pullData();
        new DatabaseAsyncAddData().execute();
        //new DatabaseAsyn.execute();


        mAdapter = new SermonsAdapter_Container(sermonList, this);
        recyclerView.setAdapter(mAdapter);


        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(gridLayoutManager);


        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0, 0, 0, 0);
                //TODO convert pixels to dp
            }
        });

        recyclerView.setItemAnimator(new DefaultItemAnimator());


        final GestureDetector mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    int position = recyclerView.getChildAdapterPosition(child);


                    return true;


                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


        return;
    }

    private void pullData() {
        AQuery aq = new AQuery(this);
        AQUtility.setDebug(true);
        aq
                .ajax(getString(R.string.API_BASE_URL), JSONObject.class, new AjaxCallback<JSONObject>() {
                    @Override
                    public void callback(String url, JSONObject object, AjaxStatus status) {
                        super.callback(url, object, status);
                        Log.d("TAG", "Ajax status code is " + status.getCode());
                        Log.d("TAG", "Ajax method object" + object);
                        if (status.getCode() == 200) {


                            try {
                                getData(object);

                                Log.d("getData", "object incuded 200 success");
                                Toast.makeText(MainActivity.this, "200 success", Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            // swipeLayout.setClickable(true);
                        } else {

                            Log.d("getData", "Network Not Available");
                            Toast.makeText(MainActivity.this, "Network Not Available", Toast.LENGTH_LONG).show();
                            fetchRoomData();
                        }
                    }

                });
    }

    private void fetchRoomData() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                fetchData();


                // // mAdapter.notifyDataSetChanged();

                return null;
            }


        }.execute();

    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)


    private void getData(JSONObject jsonObject) throws JSONException {
        List<University> list = new ArrayList<>();
        //final List<Song_Container> sermonLists = new ArrayList<Song_Container>();
        JSONArray jsonArray = jsonObject.getJSONArray("sermons");
       /* new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                // sampleDatabase.daoAccess().insertMultipleRecord(list);
                Song_Container songs = new Song_Container();
                sampleDatabase.daoAccess().deleteAll(sermonLists);
                // // mAdapter.notifyDataSetChanged();

                return null;
            }


        }.execute();
*/

        for (int i = 0; i < jsonArray.length(); i++) {
            University product = new University();

            String mediaURL = jsonArray.getJSONObject(i).getString("medialink");
            Log.d("getData", mediaURL);
            String title = jsonArray.getJSONObject(i).getString("title");
            Log.d("getData", title);
            String description = jsonArray.getJSONObject(i).getString("description");
            String speaker = "Apostle Grace Lubega";
            String albumart = jsonArray.getJSONObject(i).getString("albumart");
            Log.d("getData", albumart);
            String id = jsonArray.getJSONObject(i).getString("id");

            int id_top = jsonArray.getJSONObject(i).getInt("id");
            // String date = jsonArray.getJSONObject(i).getString("date");
            //product.setName(title);
            // product.setTitle(title);
            // list.add(product);

            sermonList.add(new Song_Container(mediaURL, title, speaker, description, albumart, id_top));
            //sermonList.add(new Song_Container(mediaURL, title, speaker, description, albumart, id));
            //, date
            Log.d("getData", "added to Song ");

        }
//        sampleDatabase.daoAccess().insertMultipleRecord(list);

        mAdapter.notifyDataSetChanged();


    }

    private void pullRoomData() {
        AQuery aq = new AQuery(this);
        AQUtility.setDebug(true);
        aq
                .ajax(getString(R.string.API_BASE_URL), JSONObject.class, new AjaxCallback<JSONObject>() {
                    @Override
                    public void callback(String url, JSONObject object, AjaxStatus status) {
                        super.callback(url, object, status);
                        Log.d("TAG", "Ajax status code is " + status.getCode());
                        Log.d("TAG", "Ajax method object" + object);
                        if (status.getCode() == 200) {


                            try {
                                getRoomData(object);

                                Log.d("getData", "object incuded");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            // swipeLayout.setClickable(true);
                        } else {

                            //Toast.makeText(MainActivity.this, "Network Not Available", Toast.LENGTH_LONG).show();
                        }
                    }

                });
    }

    private void getRoomData(JSONObject jsonObject) throws JSONException {
        JSONArray jsonArray = jsonObject.getJSONArray("sermons");


        for (
                int i = 0; i < jsonArray.length(); i++)

        {
            //University product = new University();

            String mediaURL = jsonArray.getJSONObject(i).getString("medialink");
            //Log.d("getData", mediaURL);
            String title = jsonArray.getJSONObject(i).getString("title");
            Log.d("getData", title);
            String description = jsonArray.getJSONObject(i).getString("description");
            String speaker = "Apostle Grace Lubega";
            String albumart = jsonArray.getJSONObject(i).getString("albumart");
            // Log.d("getData", albumart);
            String id = jsonArray.getJSONObject(i).getString("id");
            int id_top = jsonArray.getJSONObject(i).getInt("id");
            // String date = jsonArray.getJSONObject(i).getString("date");
            //product.setName(title);
            //TODO uncomment
            // product.setTitle(title);
            // list.add(product);
            Song_Container roomaddata = new Song_Container(mediaURL, title, speaker, description, albumart, id_top);
            roomaddata.setIdT(id_top);
            roomaddata.setTitle(title);
            roomaddata.setSpeaker(speaker);
            roomaddata.setSpeaker(speaker);
            sermonList.add(roomaddata);//, date
            Log.d("getData", "added to Song ");

        }
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                // sampleDatabase.daoAccess().insertMultipleRecord(list);
                sampleDatabase.daoAccess().insertMultipleData(sermonList);
                // // mAdapter.notifyDataSetChanged();

                return null;
            }


        }.execute();


    }

    private void fetchData() {
       /* List<University> youngUsers = sampleDatabase.daoAccess().fetchAllData();
        final List<University> products = youngUsers;*/

        List<Song_Container> youngUsers = sampleDatabase.daoAccess().fetchAllDataSong();
        final List<Song_Container> products = youngUsers;
        Log.d("fetchData", String.valueOf(products.size()));
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //  recyclerView.setAdapter(new ProductAdapter(products));
                recyclerView.setAdapter(new SermonsAdapter_Container(products, MainActivity.this));
            }
        });

    }

    private class DatabaseAsyncAddData extends AsyncTask<Void, Void, Void> {
       /* new AsyncTask<Void, Void,Void >() {*/

        @Override
        protected Void doInBackground(Void... params) {

            pullRoomData();

           /*//
            // TODO if nointernet
            if (sermonList.isEmpty()) {
                fetchData();
            } else
               // pullRoomData();
            pullData();*/

            return null;
        }
        /*}.execute();*/

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



   /* private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            fetchData();
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
*//*
        University university1 = new University();
        university.setSlNo(1);
        sampleDatabase.daoAccess().deleteRecord(university1);*//*

    }
*/

}
