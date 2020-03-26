package com.example.neverendingstory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ItemViewHolder> {

    private ArrayList<String> dataList = new ArrayList<>();
    private Context context;

    /*
    public ImageAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.dataList = data;
    }*/

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        protected ImageView image1;
        protected ImageView image2;
        protected ImageView image3;

        View view;
        public ItemViewHolder(View view) {
            super(view);
            this.view = view;
            image1 = view.findViewById(R.id.poster1);
            image2 = view.findViewById(R.id.poster2);
            image3 = view.findViewById(R.id.poster3);
        }

        void onBind(String data) {
            /*
            try {
                Uri uri = Uri.parse(data);
                image.setImageURI(uri);
            }catch (Exception e){
                e.printStackTrace();
            }

             */
            Glide.with(view).load(data).into(image1);
            Glide.with(view).load(data).into(image2);
            Glide.with(view).load(data).into(image3);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item, viewGroup, false);

        return new ItemViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(dataList.get(position));

    }

    public void addItem(String data) {
        dataList.add(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
