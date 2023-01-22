package com.muharlyam.tmarket.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.databinding.FragmentProductBinding;
import com.muharlyam.tmarket.databinding.ProductRecommendationItemBinding;
import com.muharlyam.tmarket.dto.ProductDto;

import java.util.List;

public class ProductRecommendationAdapter extends RecyclerView.Adapter<ProductRecommendationAdapter.ViewHolder> {

    private final List<ProductDto> productDtoList;
    private final Context context;

    public ProductRecommendationAdapter(Context context, List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
        this.context = context;
    }

    @Override
    public ProductRecommendationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductRecommendationItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.product_recommendation_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ProductRecommendationAdapter.ViewHolder holder, int position) {
        ProductDto productDto = productDtoList.get(position);
        holder.bind(productDtoList.get(position));

    }

    @Override
    public int getItemCount() {
        return productDtoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ProductRecommendationItemBinding binding;

        ViewHolder(ProductRecommendationItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ProductDto productDto) {
            binding.setProduct(productDto);
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString("1", "11");
            Navigation.findNavController(new Activity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_fragment_recommendation_to_product_fragment);
        }
    }
}
