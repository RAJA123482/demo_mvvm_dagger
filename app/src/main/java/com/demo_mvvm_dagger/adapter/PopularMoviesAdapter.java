package com.demo_mvvm_dagger.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.demo_mvvm_dagger.AthConstants;
import com.demo_mvvm_dagger.R;
import com.demo_mvvm_dagger.databinding.ItemMoviesListBinding;
import com.demo_mvvm_dagger.models.MovieDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>{

    private List<MovieDetails> movieList = new ArrayList();

    @Override
    public PopularMoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                    int viewType) {
        ItemMoviesListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_movies_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieDetails movieDetails = movieList.get(position);
        holder.moviesListBinding.setMovies(movieDetails);

        Picasso.get()
                .load(AthConstants.MOVIE_PIC_URL+movieList.get(position).getPoster_path())
                .error(R.drawable.no_img)
                .placeholder(R.drawable.no_img)
                .into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ItemMoviesListBinding moviesListBinding;
        ImageView ivPoster;

        public ViewHolder(ItemMoviesListBinding moviesListBinding) {
            super(moviesListBinding.getRoot());
            this.moviesListBinding = moviesListBinding;
            ivPoster = (ImageView) moviesListBinding.getRoot().findViewById(R.id.iv_poster);
        }
    }

    public void setData(ArrayList<MovieDetails> alData) {
        this.movieList = alData;
        notifyDataSetChanged();
    }
}