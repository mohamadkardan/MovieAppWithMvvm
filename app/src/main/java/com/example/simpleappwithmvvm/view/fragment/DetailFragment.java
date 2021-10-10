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

import com.bumptech.glide.Glide;
import com.example.simpleappwithmvvm.Credentials;
import com.example.simpleappwithmvvm.R;
import com.example.simpleappwithmvvm.adapter.GenreMoviesAdapter;
import com.example.simpleappwithmvvm.databinding.FragmentDetailBinding;
import com.example.simpleappwithmvvm.model.TVShow;
import com.example.simpleappwithmvvm.viewmodel.DetailViewModel;
import com.example.simpleappwithmvvm.viewmodel.MainViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private DetailViewModel detailViewModel;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        setViewModel();
        observeData();
        setGenreRecyclerview();
        return binding.getRoot();
    }

    private void setViewModel() {
        detailViewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        binding.setDetailViewModel(detailViewModel);
    }

    private void observeData() {
        if (getArguments() != null) {
            if (requireArguments().getString("mediaType").equals("tv")) {
                getTVShowData(requireArguments().getInt("id"));
            } else {
                getMovieData(requireArguments().getInt("id"));
            }
        }
    }

    private void getTVShowData(int id) {
        detailViewModel.getTvShowDetail(id).observe(getViewLifecycleOwner(), tvShow -> {
            if (tvShow != null) {
                binding.textviewOverviewFragmentDetail.setText(tvShow.getOverview());
                binding.textviewLanguageFragmentDetail.setText(tvShow.getOriginal_language());
                binding.textviewDateFragmentDetail.setText(tvShow.getFirst_air_date());
                binding.textviewTitleFragmentDetail.setText(tvShow.getName());
                binding.textviewVoteFragmentDetail.setText(String.valueOf(tvShow.getVote_average()));
                Glide.with(requireContext()).load(Credentials.POSTER_BASE_URL + tvShow.getPoster_path())
                        .into(binding.roundedImageviewFragmentDetail);
            }
        });
    }

    private void getMovieData(int id) {
        detailViewModel.getMovieDetail(id).observe(getViewLifecycleOwner(), movie -> {
            if (movie != null) {
                binding.textviewOverviewFragmentDetail.setText(movie.getOverview());
                binding.textviewLanguageFragmentDetail.setText(movie.getOriginal_language());
                binding.textviewDateFragmentDetail.setText(movie.getRelease_date());
                binding.textviewTitleFragmentDetail.setText(movie.getOriginal_title());
                binding.textviewVoteFragmentDetail.setText(String.valueOf(movie.getVote_average()));
                Glide.with(requireContext()).load(Credentials.POSTER_BASE_URL + movie.getPoster_path())
                        .into(binding.roundedImageviewFragmentDetail);
            }
        });
    }

    private void setGenreRecyclerview() {
        GenreMoviesAdapter genreMoviesAdapter = new GenreMoviesAdapter();
        genreMoviesAdapter.addMovieList(requireArguments().getStringArrayList("genreTitleList"));
        binding.recyclerviewGeneresFragmentDetail.setAdapter(genreMoviesAdapter);
        binding.recyclerviewGeneresFragmentDetail
                .setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
    }

}