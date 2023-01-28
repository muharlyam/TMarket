package com.muharlyam.tmarket.ui;

import static com.muharlyam.tmarket.utils.Constants.DESCRIPTION;
import static com.muharlyam.tmarket.utils.Constants.IMAGE_URL;
import static com.muharlyam.tmarket.utils.Constants.NAME;
import static com.muharlyam.tmarket.utils.Constants.PRICE;
import static com.muharlyam.tmarket.utils.Constants.RANK;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.muharlyam.domain.dto.ProductDto;
import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.databinding.FragmentProductBinding;

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
        productDto.setName(getArguments().getString(NAME));
        productDto.setDescription(getArguments().getString(DESCRIPTION));
        productDto.setImageUrl(getArguments().getString(IMAGE_URL));
        productDto.setPrice(getArguments().getDouble(PRICE));
        productDto.setRank(getArguments().getDouble(RANK));

        binding.setProduct(productDto);
    }
}
