package com.example.covid19;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.covid19.databinding.LayoutFragment1Binding;

public class Fragment1 extends Fragment {
    LayoutFragment1Binding binding;
    public static Fragment1 newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment1, container, false);
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = CountryFragment.newInstance();
                FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layout_fragment,fragment).addToBackStack(null).commit();
            }
        });
        return binding.getRoot();
    }
}
