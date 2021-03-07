package com.example.covid19;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    List<Country> list;
    Context context;

    public CountryAdapter(List<Country> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.country,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        Country country = list.get(position);
        DecimalFormat fm = new DecimalFormat("#####");

        holder.tvName.setText(country.getName());
        holder.tvTotalConfirmed.setText(String.valueOf(fm.format(country.getTotalConfirmed())));
        holder.tvTotalDeaths.setText(String.valueOf(fm.format(country.getTotalDeaths())));
        holder.tvTotalRecovered.setText(String.valueOf(fm.format(country.getTotalRecovered())));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvTotalConfirmed,tvTotalDeaths,tvTotalRecovered;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.country_name);
            tvTotalConfirmed = itemView.findViewById(R.id.TotalConfirmed);
            tvTotalDeaths =itemView.findViewById(R.id.TotalDeaths);
            tvTotalRecovered =itemView.findViewById(R.id.TotalRecovered);

        }
    }
}
