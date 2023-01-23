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

import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.databinding.FragmentStoreBinding;
import com.muharlyam.tmarket.dto.ProductDto;
import com.muharlyam.tmarket.dto.StoreDto;

public class StoreFragment extends Fragment {

    FragmentStoreBinding binding;

    public StoreFragment(){
        super(R.layout.fragment_store);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_store, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        StoreDto storeDto = new StoreDto();
        storeDto.setName(getArguments().getString(NAME));
        storeDto.setDescription(getArguments().getString(DESCRIPTION));
        storeDto.setImageUrl(getArguments().getString(IMAGE_URL));
        storeDto.setRank(getArguments().getDouble(RANK));

        binding.setStore(storeDto);
    }
}
