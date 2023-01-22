package com.muharlyam.tmarket.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.databinding.FragmentProductBinding;
import com.muharlyam.tmarket.dto.ProductDto;

public class ProductFragment extends Fragment {

    FragmentProductBinding binding;

    public ProductFragment(){
        super(R.layout.fragment_product);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_product, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProductDto productDto = new ProductDto();
        productDto.setName(getArguments().getString("name"));
        productDto.setDescription(getArguments().getString("description"));
        productDto.setImageUrl(getArguments().getString("imageUrl"));
        productDto.setPrice(getArguments().getDouble("price"));
        productDto.setRank(getArguments().getDouble("rank"));

        binding.setProduct(productDto);
    }
}
