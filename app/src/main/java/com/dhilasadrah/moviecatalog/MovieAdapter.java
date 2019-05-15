package com.dhilasadrah.moviecatalog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Movies> movieList;

    public void setMovies(ArrayList<Movies> movieList) {
        this.movieList = movieList;
    }

    public MovieAdapter(Context context){
        this.context = context;
        movieList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(context).inflate(R.layout.item_movies, parent, false);

        ImageView img_poster = view.findViewById(R.id.poster);
        TextView tv_title = view.findViewById(R.id.title);
        TextView tv_releaseDate = view.findViewById(R.id.release_date);
        TextView tv_genres = view.findViewById(R.id.genre);
        RatingBar ratingstar = view.findViewById(R.id.averageVote);

        Movies movies = (Movies) getItem(position);
        img_poster.setImageResource(movies.getPoster());
        tv_title.setText(movies.getTitle());
        tv_releaseDate.setText(movies.getReleaseDate());
        tv_genres.setText(movies.getGenres());
        ratingstar.setRating((int) (movies.getAverageVote()/2));

        return view;
    }
}
