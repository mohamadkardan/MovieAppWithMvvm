package com.example.simpleappwithmvvm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.simpleappwithmvvm.R;
import com.example.simpleappwithmvvm.adapter.PopularMoviesAdapter;
import com.example.simpleappwithmvvm.databinding.ActivityMainBinding;
import com.example.simpleappwithmvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private PopularMoviesAdapter popularMoviesAdapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


    }


//    private void setRecyclerview() {
//        popularMoviesAdapter = new PopularMoviesAdapter(this);
//        binding.recyclerviewActivityMain.setAdapter(popularMoviesAdapter);
//        binding.recyclerviewActivityMain.scrollToPosition(2);
//    }

//    private void observeData() {
//        viewModel = new MainViewModel();
//        viewModel.getMovies().observe(this, movies -> {
//            if (movies != null && !movies.isEmpty()) {
//                popularMoviesAdapter.addMovieList(movies);
//                popularMoviesAdapter.notifyDataSetChanged();
//            }
//        });
//    }
}