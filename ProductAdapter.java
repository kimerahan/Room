package com.a23labs.room;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a23labs.room.database.entity.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gonzalo on 7/14/17
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    /*private final List<Product> list;

    public ProductAdapter(List<Product> list) {
        this.list = list;
    }*/
    private final List<University> list;

    public ProductAdapter(List<University> list) {
        this.list = list;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_phaneroofragment_container_layout_room, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        private TextView imageTitle;
        //private TextView name;

        public ProductViewHolder(View itemView) {
            super(itemView);
            //image = (TextView) itemView.findViewById(R.id.name);
            imageTitle = (TextView) itemView.findViewById(R.id.sermonTitle_container);
            //name = (TextView) itemView.findViewById(R.id.title);
        }

       /* public void bind(Product product) {
            name.setText(product.getName());
            image.setText(product.getName());
            //Picasso.with(itemView.getContext()).load(product.getImageUrl()).into(image);
        }*/
        public void bind(University product) {
            imageTitle.setText(product.getTitle());
           // image.setText(product.getTitle());
            //Picasso.with(itemView.getContext()).load(product.getImageUrl()).into(image);
        }
    }
}
