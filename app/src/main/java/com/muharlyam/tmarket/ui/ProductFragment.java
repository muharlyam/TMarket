package com.muharlyam.tmarket.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.muharlyam.tmarket.R;

public class ProductFragment extends Fragment {

    NavController navController;

    public ProductFragment(){
        super(R.layout.fragment_product);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_product, container, false);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        return rootView;
    }
}
