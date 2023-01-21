package com.muharlyam.tmarket.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.dto.ProductDto;

import java.util.List;

public class ProductRecommendationAdapter extends RecyclerView.Adapter<ProductRecommendationAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<ProductDto> productDtoList;
    private final Context context;
    private final NavController navController;

    public ProductRecommendationAdapter(Context context, List<ProductDto> productDtoList, NavController navController) {
        this.productDtoList = productDtoList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.navController = navController;
    }

    @Override
    public ProductRecommendationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product_recommendation_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductRecommendationAdapter.ViewHolder holder, int position) {
        ProductDto productDto = productDtoList.get(position);
        holder.nameView.setText(productDto.getName());
        holder.descriptionView.setText(productDto.getDescription());

        Glide.with(context)
                .load(productDtoList.get(position).getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productDtoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final ConstraintLayout item;
        final TextView nameView, descriptionView;
        final ImageView imageView;

        ViewHolder(View view) {
            super(view);
            item = view.findViewById(R.id.product_id_cl);
            nameView = view.findViewById(R.id.name);
            descriptionView = view.findViewById(R.id.description);
            imageView = view.findViewById(R.id.image);

            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString("1", "11");
            navController.navigate(R.id.action_activity_main_to_product_fragment, bundle);
        }
    }
}
