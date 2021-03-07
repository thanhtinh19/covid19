package com.example.covid19;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid19.databinding.LayoutFragment2Binding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountryFragment extends Fragment {
    LayoutFragment2Binding binding;
    String result;
    List<Country> list;
    String url = "https://apincov.herokuapp.com/countries";

    public static CountryFragment newInstance() {

        Bundle args = new Bundle();

        CountryFragment fragment = new CountryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment2, container, false);
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            binding.progessbar.setVisibility(View.INVISIBLE);
            result = response;
            getJson();
        }, error -> {
            Log.d("TAG", "onCreateView: ");
        });
        requestQueue.add(stringRequest);

        binding.edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();
                if(str.compareTo("") == 0){
                    CountryAdapter adapter = new CountryAdapter(list, getContext());
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    binding.listCountry.setAdapter(adapter);
                    binding.listCountry.setLayoutManager(layoutManager);
                    return;
                }

                List<Country> temp = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().toLowerCase().contains(str.toLowerCase())) {
                        temp.add(list.get(i));
                    }
                }

                CountryAdapter adapter = new CountryAdapter(temp, getContext());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                binding.listCountry.setAdapter(adapter);
                binding.listCountry.setLayoutManager(layoutManager);
            }
        });

        return binding.getRoot();
    }

    private void getJson() {
        list = new ArrayList<>();
        String country_name;
        double TotalConfirmed, TotalDeaths, TotalRecovered;
        try {
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                country_name = object.getString("Country_Region");
                TotalConfirmed = object.getDouble("Confirmed");
                TotalDeaths = object.getDouble("Deaths");
                TotalRecovered = object.getDouble("Recovered");
                list.add(new Country(country_name, TotalConfirmed, TotalDeaths, TotalRecovered));
            }

            CountryAdapter adapter = new CountryAdapter(list, getContext());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
            binding.listCountry.setAdapter(adapter);
            binding.listCountry.setLayoutManager(layoutManager);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
