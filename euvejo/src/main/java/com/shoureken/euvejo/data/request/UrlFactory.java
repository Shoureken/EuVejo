package com.shoureken.euvejo.data.request;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.shoureken.euvejo.data.Actor;
import com.shoureken.euvejo.data.Entity;
import com.shoureken.euvejo.data.Episode;
import com.shoureken.euvejo.data.Language;
import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.util.Constants;

import de.akquinet.android.androlog.Log;

public class UrlFactory {

    private static final String TAG = UrlFactory.class.getSimpleName();

    public static <T extends Entity> URL getUrl(Class<T> clazz, boolean queryForDetails, Object... args) {
	Log.d(TAG, "getUrl to " + clazz.getSimpleName());

	try {
	    if (clazz.equals(Serie.class)) {
		if (queryForDetails) {
		    return new URL(String.format(Constants.URL_SERIES_DETAIL_PARAMETRIZED, args[0].toString(),
			    args[1].toString()));
		} else {
		    return new URL(String.format(Constants.URL_SERIES_SEARCH_PARAMETRIZED,
			    URLEncoder.encode(args[0].toString(), "UTF-8"), args[1].toString()));
		}
	    }
	    if (clazz.equals(Language.class)) {
		return new URL(Constants.URL_LANGUAGES);
	    }
	    if (clazz.equals(Actor.class)) {
		return new URL(String.format(Constants.URL_SERIES_ACTOR_PARAMETRIZED, args[0].toString()));
	    }
	    if (clazz.equals(Episode.class)) {
		if (queryForDetails) {
		    return new URL(String.format(Constants.URL_EPISODIES_DETAIL_PARAMETRIZED, args[0].toString(), args[1].toString()));
		} else {
		    return new URL(String.format(Constants.URL_SERIES_EPISODIES_PARAMETRIZED, args[0].toString(), args[1].toString()));
		}
	    }
	} catch (MalformedURLException e) {
	    Log.e(TAG, e.getLocalizedMessage(), e);
	} catch (UnsupportedEncodingException e) {
	    Log.e(TAG, e.getLocalizedMessage(), e);
	} catch (Exception e) {
	    Log.e(TAG, e.getLocalizedMessage(), e);
	}
	return null;
    }
}
