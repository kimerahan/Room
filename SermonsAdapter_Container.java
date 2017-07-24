package com.a23labs.room;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.List;

/**
 * Created by pluto on 6/27/17.
 */

public class SermonsAdapter_Container extends RecyclerView.Adapter<SermonsAdapter_Container.ViewHolder> {

    public String TAG = ".utils.LazyAdapter";
    public int gridViewItemId;
    String API_ENDPOINT = "v1/sermons/play/";
    private Context context;
    private List<Song_Container> sermonList;
    private Activity activity;

    public SermonsAdapter_Container(List<Song_Container> sermonList, Context context) {
        this.context = context;
        this.sermonList = sermonList;
    }

    @Override
    public SermonsAdapter_Container.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_phaneroofragment_container_layout, null);
        Log.d("SermonsAdapter", "sermon_row_grid");

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;

    }
   /* public int getCount() {
        return sermonList.size();
    }*/

   /* public void updateSermonList(ArrayList<Song> newSermonList) {
        sermonList = newSermonList;
    }*/

    /*public long getItemId(int position) {
        return position;
    }*/

    @Override
    public void onBindViewHolder(final SermonsAdapter_Container.ViewHolder holder, int position) {


        // sermon_url_ = (itemsData.get(position).getSermonUrl());
        //holder.sermon_preacher.setText(itemsData.get(position).getArtist());
        // Glide.with(context).load(itemsData.get(position).getSermonImage()).fitCenter().placeholder(R.drawable.ph_fallback).into(holder.sermon_image);

        // holder.imageTitleDay.setVisibility(View.GONE);
        //holder.progressBar.setVisibility(View.GONE);
        // } else {
         holder.imageTitle.setText(sermonList.get(position).getTitle());
       /* holder.imageTitle.setText("10 Phaneroo Sermons ");*/

       // holder.imageTitle.setSelected(true); //to start endless marquee

        Log.d("SermonsAdapter", "onBindViewHolder Called");

        //holder.imageTitleDay.setText(sermonList.get(position).getDescription());



    }

    @Override
    public int getItemCount() {
        return sermonList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView imageTitle;
        TextView imageTitleDay;
        ImageView image;
        ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            imageTitle = (TextView) itemView.findViewById(R.id.sermonTitle_container);

           // image = (ImageView) itemView.findViewById(R.id.sermonImage_container);
            // imageTitleDay = (TextView) itemView.findViewById(R.id.sermonDay);
            //progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }

        public void bind(Song_Container product) {
            //imageTitle.setText(product.getTitle());
            // image.setText(product.getTitle());
            //Picasso.with(itemView.getContext()).load(product.getImageUrl()).into(image);
        }
    }
}
