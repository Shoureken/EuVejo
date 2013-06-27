package com.shoureken.euvejo.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Serie extends Entity {

    private static final long serialVersionUID = -7865984874913279200L;
    private Long id;
    private String name;
    private String overview;
    private Date firstAired;
    private String language;
    private ArrayList<String> actors;
    private String airDay;
    private String airTime;
    private String network;
    private String rating;
    private Integer ratingCount;
    private String status;
    private ArrayList<String> genres;
    private String runtime;
    private String IMDB;
    private String zap2it;
    private String aliasNames;
    private Long lastUpdate;
    private String contentRating;
    private String bannerUrl;
    private String posterUrl;

    public String getIMDB() {
	return IMDB;
    }

    public void setIMDB(String iMDB) {
	IMDB = iMDB;
    }

    public String getRuntime() {
	return runtime;
    }

    public void setRuntime(String runtime) {
	this.runtime = runtime;
    }

    public List<String> getGenres() {
	return genres;
    }

    public void setGenres(List<String> genres) {
	this.genres = new ArrayList<String>(genres);
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getAirDay() {
	return airDay;
    }

    public void setAirDay(String airDay) {
	this.airDay = airDay;
    }

    public String getAirTime() {
	return airTime;
    }

    public void setAirTime(String airTime) {
	this.airTime = airTime;
    }

    public String getNetwork() {
	return network;
    }

    public void setNetwork(String network) {
	this.network = network;
    }

    public String getRating() {
	return rating;
    }

    public void setRating(String rating) {
	this.rating = rating;
    }

    public String getLanguage() {
	return language;
    }

    public void setLanguage(String language) {
	this.language = language;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getOverview() {
	return overview;
    }

    public void setOverview(String overview) {
	this.overview = overview;
    }

    public Date getFirstAired() {
	return firstAired;
    }

    public void setFirstAired(Date firstAired) {
	this.firstAired = firstAired;
    }

    public void setActors(List<String> actorList) {
	actors = new ArrayList<String>(actorList);
    }

    public List<String> getActors() {
	return actors;
    }

    /**
     * @return the zap2it
     */
    public String getZap2it() {
	return zap2it;
    }

    /**
     * @param zap2it
     *            the zap2it to set
     */
    public void setZap2it(String zap2it) {
	this.zap2it = zap2it;
    }

    /**
     * @return the aliasNames
     */
    public String getAliasNames() {
	return aliasNames;
    }

    /**
     * @param aliasNames
     *            the aliasNames to set
     */
    public void setAliasNames(String aliasNames) {
	this.aliasNames = aliasNames;
    }

    /**
     * @return the ratingCount
     */
    public Integer getRatingCount() {
	return ratingCount;
    }

    /**
     * @param ratingCount
     *            the ratingCount to set
     */
    public void setRatingCount(Integer ratingCount) {
	this.ratingCount = ratingCount;
    }

    /**
     * @return the lastUpdate
     */
    public Long getLastUpdate() {
	return lastUpdate;
    }

    /**
     * @param lastUpdate
     *            the lastUpdate to set
     */
    public void setLastUpdate(Long lastUpdate) {
	this.lastUpdate = lastUpdate;
    }

    /**
     * @return the contentRating
     */
    public String getContentRating() {
	return contentRating;
    }

    /**
     * @param contentRating
     *            the contentRating to set
     */
    public void setContentRating(String contentRating) {
	this.contentRating = contentRating;
    }

    /**
     * @return the bannerUrl
     */
    public String getBannerUrl() {
	return bannerUrl;
    }

    /**
     * @param bannerUrl
     *            the bannerUrl to set
     */
    public void setBannerUrl(String bannerUrl) {
	this.bannerUrl = bannerUrl;
    }

    /**
     * @return the posterUrl
     */
    public String getPosterUrl() {
	return posterUrl;
    }

    /**
     * @param posterUrl
     *            the posterUrl to set
     */
    public void setPosterUrl(String posterUrl) {
	this.posterUrl = posterUrl;
    }
    
    
}
