package com.shoureken.euvejo.data.request;

import com.shoureken.euvejo.data.Actor;
import com.shoureken.euvejo.data.Entity;
import com.shoureken.euvejo.data.Episode;
import com.shoureken.euvejo.data.Language;
import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.data.parser.AbstractParser;
import com.shoureken.euvejo.data.parser.ActorParser;
import com.shoureken.euvejo.data.parser.EpisodiesParser;
import com.shoureken.euvejo.data.parser.LanguagesParser;
import com.shoureken.euvejo.data.parser.SeriesParser;

import de.akquinet.android.androlog.Log;

public class ParserFactory {
    
    private static final String TAG = ParserFactory.class.getSimpleName();

    @SuppressWarnings("rawtypes")
    public static AbstractParser getParser(Class<? extends Entity> clazz) {
	Log.d(TAG, "getParser to "+clazz.getSimpleName());
	if (clazz.equals(Serie.class)) {
	    return new SeriesParser();
	}
	if (clazz.equals(Episode.class)) {
	    return new EpisodiesParser();
	}
	if (clazz.equals(Actor.class)) {
	    return new ActorParser();
	}
	if (clazz.equals(Language.class)) {
	    return new LanguagesParser();
	}
	return null;
    }
}
