package com.dhilasadrah.moviecatalog;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    private String title, releaseDate, runtime, genres, overview;
    private int poster, backdrop;
    private float averageVote;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public int getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(int backdrop) {
        this.backdrop = backdrop;
    }

    public float getAverageVote() {
        return averageVote;
    }

    public void setAverageVote(float averageVote) {
        this.averageVote = averageVote;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.releaseDate);
        dest.writeString(this.runtime);
        dest.writeString(this.genres);
        dest.writeString(this.overview);
        dest.writeInt(this.poster);
        dest.writeInt(this.backdrop);
        dest.writeFloat(this.averageVote);
    }

    public Movies() {
    }

    protected Movies(Parcel in) {
        this.title = in.readString();
        this.releaseDate = in.readString();
        this.runtime = in.readString();
        this.genres = in.readString();
        this.overview = in.readString();
        this.poster = in.readInt();
        this.backdrop = in.readInt();
        this.averageVote = in.readFloat();
    }

    public static final Parcelable.Creator<Movies> CREATOR = new Parcelable.Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel source) {
            return new Movies(source);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
