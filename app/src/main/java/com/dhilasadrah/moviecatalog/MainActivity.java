package com.dhilasadrah.moviecatalog;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MovieAdapter movieAdapter;
    String[] title, release_date, runtime, genres, overview, averageVote;
    TypedArray poster, backdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieAdapter = new MovieAdapter(this);

        listView = findViewById(R.id.listView);
        listView.setAdapter(movieAdapter);

        poster = getResources().obtainTypedArray(R.array.list_poster);
        backdrop = getResources().obtainTypedArray(R.array.list_backdrop);
        averageVote = getResources().getStringArray(R.array.list_averageVote);
        title = getResources().getStringArray(R.array.list_title);
        release_date = getResources().getStringArray(R.array.list_releaseDate);
        runtime = getResources().getStringArray(R.array.list_runtime);
        genres = getResources().getStringArray(R.array.list_genre);
        overview = getResources().getStringArray(R.array.list_overview);

        final ArrayList<Movies> movieList = new ArrayList<>();

        for (int x = 0; x < title.length; x++) {
            Movies movies = new Movies();
            movies.setPoster(poster.getResourceId(x, -1));
            movies.setBackdrop(backdrop.getResourceId(x, -1));
            movies.setTitle(title[x]);
            movies.setReleaseDate(release_date[x]);
            movies.setRuntime (runtime[x]);
            movies.setGenres(genres[x]);
            movies.setAverageVote(Float.valueOf(averageVote[x]));
            movies.setOverview(overview[x]);
            movieList.add(movies);
        }
        movieAdapter.setMovies(movieList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                intent.putExtra("movies", movieList.get(i));
                startActivity(intent);
            }
        });
    }
}
