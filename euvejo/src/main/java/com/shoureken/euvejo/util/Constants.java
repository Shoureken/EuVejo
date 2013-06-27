package com.shoureken.euvejo.util;

public interface Constants {

    public static final String SITE = "http://www.thetvdb.com/";
    public static final String API_KEY = "2288BC661CA9C0A6";
    public static final String BASE_URL = SITE + "api/" + API_KEY + "/";
    
    public static final String EPISODE_FULL_URL = SITE + "api/" + API_KEY + "/episodes/"; // <seriesid>/all/en.xml
    public static final String GET_RATING_URL = SITE + "api/User_Rating.php?";
    public static final String SET_RATING_URL = SITE + "api/GetRatingsForUser.php?apikey=" + API_KEY + "&";
    public static final String FAVORITES_URL = SITE + "api/User_Favorites.php?";
    public static final String BANNER_URL = SITE + "banners/";
    public static final int DATABASE_VERSION = 1;
    public static final String PREFS_NAME = "EuVejo";
    public static final int THUMBNAIL_SIZE = 100;
    public static final int DEFAULT_CACHE_SIZE = 50; // 50 MB
    
    public static final String URL_LANGUAGES = BASE_URL + "languages.xml"; //<mirrorpath>/api/<apikey>/languages.xml
    public static final String URL_SERIES_SEARCH_PARAMETRIZED = SITE + "api/GetSeries.php?seriesname=%s&language=%s.xml";
    public static final String URL_SERIES_DETAIL_PARAMETRIZED = BASE_URL + "series/%s/%s.xml"; // <seriesid>/all/en.xml
    public static final String URL_SERIES_EPISODIES_PARAMETRIZED = BASE_URL + "series/%s/all/%s.xml";
    public static final String URL_SERIES_ACTOR_PARAMETRIZED = BASE_URL + "series/%s/actors.xml";
    public static final String URL_EPISODIES_DETAIL_PARAMETRIZED = BASE_URL + "episodes/%s/%s.xml";
    
}
