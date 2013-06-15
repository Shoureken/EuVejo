package com.shoureken.euvejo.util;

public interface Constants {

    public static final String SITE = "http://www.thetvdb.com/";
    public static final String API_KEY = "2288BC661CA9C0A6";
    public static final String BASE_URL = SITE + "api/" + API_KEY + "/";
    public static final String SERIES_BASIC_URL = SITE + "api/GetSeries.php?seriesname=";
    public static final String SERIES_FULL_URL = SITE + "api/" + API_KEY + "/series/"; // <seriesid>/all/en.xml
    public static final String EPISODE_FULL_URL = SITE + "api/" + API_KEY + "/episodes/"; // <seriesid>/all/en.xml
    public static final String GET_RATING_URL = SITE + "api/User_Rating.php?";
    public static final String SET_RATING_URL = SITE + "api/GetRatingsForUser.php?apikey=" + API_KEY + "&";
    public static final String FAVORITES_URL = SITE + "api/User_Favorites.php?";
    public static final String BANNER_URL = SITE + "banners/";
    public static final boolean LOG_ENABLED = true;
    public static final int DATABASE_VERSION = 1;
    public static final String PREFS_NAME = "EuVejo";
    public static final int THUMBNAIL_SIZE = 100;
    public static final int DEFAULT_CACHE_SIZE = 50; // 50 MB

}
