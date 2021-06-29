package com.eduinapps.recipesapi.adapters;

import android.net.Uri;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.eduinapps.recipesapi.R;
import com.eduinapps.recipesapi.models.Recipe;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    CircleImageView categoryImage;
    TextView categoryTitle;
    OnRecipeListener onRecipeListener;
    RequestManager requestManager;

    public CategoryViewHolder(@NonNull View itemView, OnRecipeListener onRecipeListener, RequestManager requestManager) {
        super(itemView);

        this.onRecipeListener = onRecipeListener;
        this.requestManager = requestManager;

        categoryImage = itemView.findViewById(R.id.category_image);
        categoryTitle = itemView.findViewById(R.id.category_title);

        itemView.setOnClickListener(this);
    }

    public void onBind(Recipe recipe) {
        Uri path = Uri.parse("android.resource://com.eduinapps.recipesapi/drawable/" + recipe.getImage());
        requestManager
                .load(path)
                .into(categoryImage);

        categoryTitle.setText(recipe.getLabel());
    }

    @Override
    public void onClick(View view) {
        onRecipeListener.onCategoryClick(categoryTitle.getText().toString());
    }
}
