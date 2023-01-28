package com.muharlyam.tmarket.adapter;

import static com.muharlyam.tmarket.utils.Constants.DESCRIPTION;
import static com.muharlyam.tmarket.utils.Constants.IMAGE_URL;
import static com.muharlyam.tmarket.utils.Constants.NAME;
import static com.muharlyam.tmarket.utils.Constants.PRICE;
import static com.muharlyam.tmarket.utils.Constants.RANK;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.muharlyam.domain.dto.ProductDto;
import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.databinding.ItemProductBinding;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private final List<ProductDto> productDtoList;

    public ProductAdapter(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemProductBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_product, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        holder.bind(productDtoList.get(position));
    }

    @Override
    public int getItemCount() {
        return productDtoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemProductBinding binding;

        ViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ProductDto productDto) {
            binding.setProduct(productDto);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString(NAME, productDto.getName());
                bundle.putString(DESCRIPTION, productDto.getDescription());
                bundle.putString(IMAGE_URL, productDto.getImageUrl());
                bundle.putDouble(PRICE, productDto.getPrice());
                bundle.putDouble(RANK, productDto.getRank());
                Navigation.findNavController(this.binding.getRoot())
                        .navigate(R.id.action_fragment_recommendation_to_product_fragment, bundle);
            });
        }
    }
}
