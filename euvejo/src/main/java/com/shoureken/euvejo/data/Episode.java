package com.shoureken.euvejo.data;

import java.util.Date;
import java.util.List;

public class Episode extends Entity {

    private static final long serialVersionUID = 899240449470564197L;
    private Integer id;
    private String name;
    private Integer seasonNumber;
    private Integer seasonEpisodeNumber;
    private Integer absoluteNumber;
    private String IMDB_ID;
    private List<String> directors;
    private List<String> guestStars;
    private List<String> writers;
    private String rating;
    private Integer ratingCount;
    private Date firstAired;
    private Long lastUpdate;
    private String urlImage;
    private String overview;

    public String getIMDB() {
	return IMDB_ID;
    }

    public void setIMDB(String iMDB_ID) {
	IMDB_ID = iMDB_ID;
    }

    public List<String> getDirectors() {
	return directors;
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

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getSeasonNumber() {
	return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
	this.seasonNumber = seasonNumber;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getSeasonEpisodeNumber() {
	return seasonEpisodeNumber;
    }

    public void setSeasonEpisodeNumber(Integer seasonEpisodeNumber) {
	this.seasonEpisodeNumber = seasonEpisodeNumber;
    }

    /**
     * @return the guestStars
     */
    public List<String> getGuestStars() {
	return guestStars;
    }

    /**
     * @param guestStars
     *            the guestStars to set
     */
    public void setGuestStars(List<String> guestStars) {
	this.guestStars = guestStars;
    }

    /**
     * @return the writers
     */
    public List<String> getWriters() {
	return writers;
    }

    /**
     * @param writers
     *            the writers to set
     */
    public void setWriters(List<String> writers) {
	this.writers = writers;
    }

    /**
     * @return the absoluteNumber
     */
    public Integer getAbsoluteNumber() {
	return absoluteNumber;
    }

    /**
     * @param absoluteNumber
     *            the absoluteNumber to set
     */
    public void setAbsoluteNumber(Integer absoluteNumber) {
	this.absoluteNumber = absoluteNumber;
    }

    /**
     * @param directors
     *            the directors to set
     */
    public void setDirectors(List<String> directors) {
	this.directors = directors;
    }

    /**
     * @return the firstAired
     */
    public Date getFirstAired() {
	return firstAired;
    }

    /**
     * @param firstAired
     *            the firstAired to set
     */
    public void setFirstAired(Date firstAired) {
	this.firstAired = firstAired;
    }

    /**
     * @return the iMDB_ID
     */
    public String getIMDB_ID() {
	return IMDB_ID;
    }

    /**
     * @param iMDB_ID
     *            the iMDB_ID to set
     */
    public void setIMDB_ID(String iMDB_ID) {
	IMDB_ID = iMDB_ID;
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
     * @return the urlImage
     */
    public String getUrlImage() {
	return urlImage;
    }

    /**
     * @param urlImage
     *            the urlImage to set
     */
    public void setUrlImage(String urlImage) {
	this.urlImage = urlImage;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Episode [id=" + id + ", name=" + name + ", seasonNumber=" + seasonNumber + ", seasonEpisodeNumber="
		+ seasonEpisodeNumber + ", absoluteNumber=" + absoluteNumber + ", IMDB_ID=" + IMDB_ID + ", directors="
		+ directors + ", guestStars=" + guestStars + ", writers=" + writers + ", rating=" + rating
		+ ", ratingCount=" + ratingCount + ", firstAired=" + firstAired + ", lastUpdate=" + lastUpdate
		+ ", urlImage=" + urlImage + ", overview=" + overview + "]";
    }
}
