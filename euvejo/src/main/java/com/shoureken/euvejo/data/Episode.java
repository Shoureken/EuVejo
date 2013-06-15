package com.shoureken.euvejo.data;

public class Episode {

    private int id;
    private String name;
    private int season;
    private int number;
    private long airDate;
    private String director;
    private String overview;
    private String rating;
    private String IMDB_ID;

    public String getIMDB() {
	return IMDB_ID;
    }

    public void setIMDB(String iMDB_ID) {
	IMDB_ID = iMDB_ID;
    }

    public String getDirector() {
	return director;
    }

    public String getOverview() {
	return overview;
    }

    public void setOverview(String overview) {
	this.overview = overview;
    }

    public String getRating() {
	return rating;
    }

    public void setRating(String rating) {
	this.rating = rating;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getSeason() {
	return season;
    }

    public void setSeason(int season) {
	this.season = season;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getNumber() {
	return number;
    }

    public void setNumber(int number) {
	this.number = number;
    }

    public long getAirDate() {
	return airDate;
    }

    public void setAirDate(long airDate) {
	this.airDate = airDate;
    }
}
