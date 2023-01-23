package com.muharlyam.tmarket.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.adapter.ProductAdapter;
import com.muharlyam.tmarket.adapter.StoreAdapter;
import com.muharlyam.tmarket.dto.RecommendationDto;
import com.muharlyam.tmarket.viewmodel.RecommendationViewModel;

public class RecommendationFragment extends Fragment {

    RecommendationViewModel recommendationViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommendation, container, false);
        getDataFromApi(view);
        return view;

    }

    private void getDataFromApi(View view) {
        recommendationViewModel = new ViewModelProvider(this).get(RecommendationViewModel.class);
        recommendationViewModel.getRecommendation()
                .observe(getViewLifecycleOwner(), recommendationDto -> {
                    setProductAdapter(view, recommendationDto);
                    setStoreAdapter(view, recommendationDto);
                });

    }

    private void setProductAdapter(View view, RecommendationDto recommendationDto) {
        RecyclerView recyclerView = view.findViewById(R.id.rec_like_prod_list);
        ProductAdapter productAdapter =
                new ProductAdapter(recommendationDto.getLikeProducts());
        recyclerView.setAdapter(productAdapter);

        recyclerView = view.findViewById(R.id.rec_top_prod_txt_list);
        productAdapter =
                new ProductAdapter(recommendationDto.getTopProducts());
        recyclerView.setAdapter(productAdapter);
    }

    private void setStoreAdapter(View view, RecommendationDto recommendationDto) {
        RecyclerView recyclerView = view.findViewById(R.id.rec_like_store_list);
        StoreAdapter storeAdapter =
                new StoreAdapter(recommendationDto.getLikeStores());
        recyclerView.setAdapter(storeAdapter);

        recyclerView = view.findViewById(R.id.rec_top_store_txt_list);
        storeAdapter =
                new StoreAdapter(recommendationDto.getTopStores());
        recyclerView.setAdapter(storeAdapter);
    }
}
