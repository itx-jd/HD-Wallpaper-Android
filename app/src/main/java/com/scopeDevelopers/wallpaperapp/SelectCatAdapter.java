package com.scopeDevelopers.wallpaperapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.scopeDevelopers.wallpaperapp.ui.home.WallpaperModel;

import java.util.List;

public class SelectCatAdapter extends RecyclerView.Adapter <SelectCatAdapter.SelectCatHolder> {

    private Context context;
    private List<WallpaperModel> wallpaperModelList;

    public SelectCatAdapter(Context context, List<WallpaperModel> wallpaperModelList) {
        this.context = context;
        this.wallpaperModelList = wallpaperModelList;
    }

    @NonNull
    @Override
    public SelectCatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cat_select_item,parent,false);
        return new SelectCatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectCatHolder holder, int position) {
        Glide.with(context).load(wallpaperModelList.get(position).getMediumUrl()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // paste the code of full screen
            }
        });
    }

    @Override
    public int getItemCount() {
        return wallpaperModelList.size();
    }
class SelectCatHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    public SelectCatHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.CatimageViewItem);
        }
    }
}
