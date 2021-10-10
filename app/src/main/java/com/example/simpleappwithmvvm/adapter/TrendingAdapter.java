package com.example.simpleappwithmvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleappwithmvvm.R;
import com.example.simpleappwithmvvm.databinding.ItemCardTrendBinding;
import com.example.simpleappwithmvvm.model.Trend;
import com.example.simpleappwithmvvm.viewmodel.MainViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    private List<Trend> trendList;
    private Context context;

    public TrendingAdapter(Context context) {
        trendList = new ArrayList<>();
        this.context = context;
    }

    public void addTrendList(List<Trend> trendList) {
        this.trendList = trendList;
    }

    @NonNull
    @NotNull
    @Override
    public TrendingAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemCardTrendBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_card_trend, parent, false);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TrendingAdapter.ViewHolder holder, int position) {
        Trend trend = trendList.get(position);
        holder.binding.setTrend(trend);
        holder.binding.setViewModel(new MainViewModel());
    }

    @Override
    public int getItemCount() {
        if (trendList != null) {
            return trendList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemCardTrendBinding binding;

        public ViewHolder(@NonNull @NotNull ItemCardTrendBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
