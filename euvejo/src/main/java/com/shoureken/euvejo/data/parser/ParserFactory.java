package com.shoureken.euvejo.data.parser;

import com.shoureken.euvejo.data.Actor;
import com.shoureken.euvejo.data.Entity;
import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.data.parser.AbstractParser;

import de.akquinet.android.androlog.Log;

public class ParserFactory {
    
    private static final String TAG = ParserFactory.class.getSimpleName();

    @SuppressWarnings("rawtypes")
    public static AbstractParser getParser(Class<? extends Entity> clazz, boolean queryForDetails) {
	Log.d(TAG, "getParser to "+clazz.getSimpleName());
	if (clazz.equals(Serie.class)) {
	    return new SeriesParser();
	}
	if (clazz.equals(Actor.class)) {
	    return new ActorParser();
	}
	return null;
    }

}
