package com.muharlyam.tmarket.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.databinding.ProductRecommendationItemBinding;
import com.muharlyam.tmarket.dto.ProductDto;

import java.util.List;

public class ProductRecommendationAdapter extends RecyclerView.Adapter<ProductRecommendationAdapter.ViewHolder> {

    private final List<ProductDto> productDtoList;

    public ProductRecommendationAdapter(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }

    @Override
    public ProductRecommendationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductRecommendationItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.product_recommendation_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ProductRecommendationAdapter.ViewHolder holder, int position) {
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
            bundle.putString("test", "test");
            Navigation.findNavController(new Activity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_fragment_recommendation_to_product_fragment, bundle);
        }
    }
}
