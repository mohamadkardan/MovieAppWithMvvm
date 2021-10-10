package com.example.simpleappwithmvvm.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simpleappwithmvvm.R;
import com.example.simpleappwithmvvm.adapter.PopularMoviesAdapter;
import com.example.simpleappwithmvvm.adapter.TopRatedMoviesAdapter;
import com.example.simpleappwithmvvm.adapter.TrendingAdapter;
import com.example.simpleappwithmvvm.adapter.UpcomingMoviesAdapter;
import com.example.simpleappwithmvvm.databinding.FragmentHomeBinding;
import com.example.simpleappwithmvvm.model.Movie;
import com.example.simpleappwithmvvm.viewmodel.MainViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private PopularMoviesAdapter popularMoviesAdapter;
    private TrendingAdapter trendingAdapter;
    private UpcomingMoviesAdapter upcomingMoviesAdapter;
    private TopRatedMoviesAdapter topRatedMoviesAdapter;
    private FragmentHomeBinding binding;
    private MainViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        setDiscreteScrollView();
        setRecyclerViews();
        setViewModel();
        return binding.getRoot();
    }

    private void setRecyclerViews() {
        upcomingMoviesAdapter = new UpcomingMoviesAdapter();
        binding.recyclerviewUpcomingFragmentHome.setAdapter(upcomingMoviesAdapter);
        binding.recyclerviewUpcomingFragmentHome.setLayoutManager(new LinearLayoutManager(requireContext(),
                RecyclerView.HORIZONTAL, false));

        topRatedMoviesAdapter = new TopRatedMoviesAdapter();
        binding.recyclerviewTopRatedFragmentHome.setAdapter(topRatedMoviesAdapter);
        binding.recyclerviewTopRatedFragmentHome.setLayoutManager(new LinearLayoutManager(requireContext(),
                RecyclerView.HORIZONTAL, false));
    }

    private void setDiscreteScrollView() {
        trendingAdapter = new TrendingAdapter(requireContext());
        binding.discreteScrollViewFragmentHome.setAdapter(trendingAdapter);
    }

    private void setViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        observerData();
    }

    private void observerData() {
        observeTrending();
        observeUpcomingMovies();
        observeTopRatedMovies();
    }

    private void observeTrending() {
        viewModel.getTrending().observe(getViewLifecycleOwner(), trends -> {
            if (trends != null) {
                trendingAdapter.addTrendList(trends);
                trendingAdapter.notifyDataSetChanged();
            }
        });
    }

    private void observeUpcomingMovies() {
        viewModel.getUpcomingMovies().observe(getViewLifecycleOwner(), movies -> {
            if (movies != null) {
                upcomingMoviesAdapter.addMovieList(movies);
                upcomingMoviesAdapter.notifyDataSetChanged();
            }
        });
    }

    private void observeTopRatedMovies() {
        viewModel.getTopRatedMovies().observe(getViewLifecycleOwner(), movies -> {
            if (movies != null) {
                topRatedMoviesAdapter.addMovieList(movies);
                topRatedMoviesAdapter.notifyDataSetChanged();
            }
        });
    }
}