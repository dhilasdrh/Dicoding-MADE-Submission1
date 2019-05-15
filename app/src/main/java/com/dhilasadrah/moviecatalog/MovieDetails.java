package com.dhilasadrah.moviecatalog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        ImageView detail_backdrop = findViewById(R.id.detail_backdrop);
        ImageView detail_poster = findViewById(R.id.detail_poster);
        TextView detail_title = findViewById(R.id.detail_title);
        TextView detail_releaseDate = findViewById(R.id.detail_releaseDate);
        TextView detail_runtime = findViewById(R.id.detail_runtime);
        TextView detail_genres = findViewById(R.id.detail_genre);
        TextView detail_overview = findViewById(R.id.detail_overview);
        RatingBar detail_averageVote = findViewById(R.id.detail_averageVote);

        Movies movies = getIntent().getParcelableExtra("movies");

        int poster = movies.getPoster();
        int backdrop = movies.getBackdrop();
        String title = movies.getTitle();
        String release_date = movies.getReleaseDate();
        String runtime = movies.getRuntime ();
        String genres = movies.getGenres();
        String overview = movies.getOverview();
        float rating = movies.getAverageVote();

        detail_poster.setImageResource(poster);
        detail_backdrop.setImageResource(backdrop);
        detail_title.setText(title);
        detail_releaseDate.setText(release_date);
        detail_runtime.setText(runtime);
        detail_genres.setText(genres);
        detail_overview.setText(overview);
        detail_averageVote.setRating(rating);

        getSupportActionBar().setTitle(movies.getTitle());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
