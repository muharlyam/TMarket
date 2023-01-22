package com.muharlyam.tmarket.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.databinding.FragmentProductBinding;
import com.muharlyam.tmarket.dto.ProductDto;

public class ProductFragment extends Fragment {

    public ProductFragment(){
        super(R.layout.fragment_product);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_product, container, false);
        ProductDto productDto = new ProductDto();

        FragmentProductBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_product, container, false);
        binding.setProduct(productDto);
        return rootView;
    }
}
