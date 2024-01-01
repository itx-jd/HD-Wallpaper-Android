package com.scopeDevelopers.wallpaperapp.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.scopeDevelopers.wallpaperapp.MainActivity;
import com.scopeDevelopers.wallpaperapp.R;
import com.scopeDevelopers.wallpaperapp.SelectCat;
//import com.example.wallpaperapp.ui.home.WallpaperViewHolder;


public class catAdapter extends RecyclerView.Adapter<catAdapter.CatViewHolder>{

    Context context;
    String[] catTitle;
    int[] catImages;

     public catAdapter(Context context, String[] catTitle, int[] catImages) {
        this.context = context;
        this.catTitle = catTitle;
        this.catImages = catImages;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cat_item,parent,false);
        return new CatViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {

         holder.textView.setText(catTitle[position]);
         holder.imageView.setImageResource(catImages[position]);

         holder.catCardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 MainActivity.cat = catTitle[position];
                 context.startActivity(new Intent(context, SelectCat.class));
             }
         });


    }

    @Override
    public int getItemCount() {
        return catTitle.length;
    }

    public  class CatViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView catCardView;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.catImage);
            textView = itemView.findViewById(R.id.catText);
            catCardView = itemView.findViewById(R.id.CatCardView);

        }
    }
}
