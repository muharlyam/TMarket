package com.muharlyam.tmarket.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.muharlyam.tmarket.MainActivity;
import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.adapter.ProductRecommendationAdapter;
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
                    RecyclerView recyclerView = view.findViewById(R.id.rec_like_prod_list);
                    ProductRecommendationAdapter productRecommendationAdapter =
                            new ProductRecommendationAdapter(view.getContext(), recommendationDto.getLikeProducts());
                    recyclerView.setAdapter(productRecommendationAdapter);

                    recyclerView = view.findViewById(R.id.rec_top_prod_txt_list);
                    productRecommendationAdapter =
                            new ProductRecommendationAdapter(view.getContext(), recommendationDto.getTopProducts());
                    recyclerView.setAdapter(productRecommendationAdapter);
                });

    }
}
