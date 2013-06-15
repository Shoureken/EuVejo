package com.shoureken.euvejo.data;

public class Serie extends Entity{

    private static final long serialVersionUID = -7865984874913279200L;
    private Long id;
    private String name;
    private String overview;
    private String firstAired;
    private String language;
    private String actors;
    private String airDay;
    private String airTime;
    private String network;
    private String rating;
    private String status;
    private String genre;
    private String runtime;
    private String IMDB;
    private String zap2it;
    private String aliasNames;

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

    public String getGenre() {
	return genre;
    }

    public void setGenre(String genre) {
	this.genre = genre;
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

    public String getFirstAired() {
	return firstAired;
    }

    public void setFirstAired(String firstAired) {
	this.firstAired = firstAired;
    }

    public void setActors(String actorList) {
	actors = actorList;
    }

    public String getActors() {
	return actors;
    }

    /**
     * @return the zap2it
     */
    public String getZap2it() {
        return zap2it;
    }

    /**
     * @param zap2it the zap2it to set
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
     * @param aliasNames the aliasNames to set
     */
    public void setAliasNames(String aliasNames) {
        this.aliasNames = aliasNames;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Serie [id=" + id + ", name=" + name + ", overview=" + overview + ", firstAired=" + firstAired
		+ ", language=" + language + ", actors=" + actors + ", airDay=" + airDay + ", airTime=" + airTime
		+ ", network=" + network + ", rating=" + rating + ", status=" + status + ", genre=" + genre
		+ ", runtime=" + runtime + ", IMDB=" + IMDB + ", zap2it=" + zap2it + ", aliasNames=" + aliasNames + "]";
    }
}
