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
import android.widget.Toast;

import com.example.simpleappwithmvvm.R;
import com.example.simpleappwithmvvm.adapter.SearchedMoviesAdapter;
import com.example.simpleappwithmvvm.databinding.FragmentSearchBinding;
import com.example.simpleappwithmvvm.model.Trend;
import com.example.simpleappwithmvvm.viewmodel.SearchViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private SearchViewModel viewModel;
    private SearchedMoviesAdapter adapter;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        setViewModel();
        setRecyclerview();
        observeData();
        return binding.getRoot();
    }

    private void setViewModel() {
        viewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        binding.setViewModel(viewModel);
    }

    private void observeData() {
        viewModel.getSearchTrendsMutableLiveData().observe(getViewLifecycleOwner(), trends -> {
            if (trends != null) {
                adapter.addMovieList(trends);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setRecyclerview() {
        adapter = new SearchedMoviesAdapter();
        binding.recyclerviewSearchesFragmentSearch.setAdapter(adapter);
        binding.recyclerviewSearchesFragmentSearch.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
    }
}