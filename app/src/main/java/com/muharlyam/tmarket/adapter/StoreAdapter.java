package com.muharlyam.tmarket.adapter;

import static com.muharlyam.tmarket.utils.Constants.DESCRIPTION;
import static com.muharlyam.tmarket.utils.Constants.IMAGE_URL;
import static com.muharlyam.tmarket.utils.Constants.NAME;
import static com.muharlyam.tmarket.utils.Constants.RANK;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.muharlyam.domain.dto.StoreDto;
import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.databinding.ItemStoreBinding;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private final List<StoreDto> storeDtos;

    public StoreAdapter(List<StoreDto> storeDtos) {
        this.storeDtos = storeDtos;
    }

    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemStoreBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_store, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(StoreAdapter.ViewHolder holder, int position) {
        holder.bind(storeDtos.get(position));
    }

    @Override
    public int getItemCount() {
        return storeDtos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemStoreBinding binding;

        ViewHolder(ItemStoreBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(StoreDto storeDto) {
            binding.setStore(storeDto);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString(NAME, storeDto.getName());
                bundle.putString(DESCRIPTION, storeDto.getDescription());
                bundle.putString(IMAGE_URL, storeDto.getImageUrl());
                bundle.putDouble(RANK, storeDto.getRank());
                Navigation.findNavController(this.binding.getRoot())
                        .navigate(R.id.action_fragment_recommendation_to_store_fragment, bundle);
            });
        }
    }
}
