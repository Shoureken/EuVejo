package com.shoureken.euvejo.data.request;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.shoureken.euvejo.data.Entity;
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
		    return new URL(Constants.SERIES_FULL_URL + URLEncoder.encode(args[0].toString(), "UTF-8") + "/all/"
			    + args[1].toString() + ".xml");
		} else {
		    return new URL(Constants.SERIES_BASIC_URL + URLEncoder.encode(args[0].toString(), "UTF-8")
			    + "&language=" + args[1].toString());
		}
	    }
	} catch (MalformedURLException e) {
	    Log.e(TAG, e.getLocalizedMessage(), e);
	} catch (UnsupportedEncodingException e) {
	    Log.e(TAG, e.getLocalizedMessage(), e);
	}

	return null;
    }
}
