package com.shoureken.euvejo.data.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.util.Log;

import com.shoureken.euvejo.data.Episode;
import com.shoureken.euvejo.util.Constants;

public class EpisodiesParser extends AbstractParser<Episode> {

    private static final String TAG = EpisodiesParser.class.getSimpleName();
    private StringBuilder sb;
    private static final List<String> ignore = Arrays.asList("dvd_discid", "dvd_season", "dvd_episodenumber",
	    "dvd_chapter", "productioncode", "epimgflag", "language", "seriesid", "seasonid", "airsbefore_episode",
	    "airsbefore_season", "data");

    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) {
	// format the current element name
	name = name.trim().toLowerCase(Locale.getDefault());
	sb = new StringBuilder(); // Reset the string builder

	if (name.equals("episode")) { 
	    // New instance for a new node
	    this.setCurrentParsing(new Episode());
	}
    }

    // SAX parsers may return all contiguous character data in a single chunk,
    // or they may split it into several chunks
    // Therefore we must aggregate the data here, and set it in endElement()
    // function
    @Override
    public void characters(char ch[], int start, int length) {
	String chars = (new String(ch).substring(start, start + length));
	sb.append(chars);
    }

    @Override
    public void endElement(String uri, String name, String qName) throws SAXException {
	if (getCurrentParsing() == null) {
	    return;
	}
	try {
	    name = name.trim().toLowerCase(Locale.getDefault());
	    final String value = sb.toString();
	    if (value.length() == 0) {
		return;
	    }

	    if (ignore.contains(name)) {
		// Log.v(TAG, "Ignoring '" + name + "' -> '" + value + "'");
	    } else if (name.equals("episode")) {
		getListParsed().add(getCurrentParsing());
	    } else if (name.equals("id")) {
		getCurrentParsing().setId(Integer.valueOf(value));
	    } else if (name.equals("episodenumber")) {
		getCurrentParsing().setSeasonEpisodeNumber(Integer.valueOf(value));
	    } else if (name.equals("seasonnumber")) {
		getCurrentParsing().setSeasonNumber(Integer.valueOf(value));
	    } else if (name.equals("episodename")) {
		getCurrentParsing().setName(value);
	    } else if (name.equals("overview")) {
		getCurrentParsing().setOverview(value);
	    } else if (name.equals("rating")) {
		getCurrentParsing().setRating(value);
	    } else if (name.equals("imdb_id")) {
		getCurrentParsing().setIMDB(value);
	    } else if (name.equals("gueststars")) {
		getCurrentParsing().setGuestStars(parseList(value));
	    } else if (name.equals("director")) {
		getCurrentParsing().setDirectors(parseList(value));
	    } else if (name.equals("writer")) {
		getCurrentParsing().setWriters(parseList(value));
	    } else if (name.equals("absolute_number")) {
		getCurrentParsing().setAbsoluteNumber(Integer.valueOf(value));
	    } else if (name.equals("firstaired")) {
		getCurrentParsing().setFirstAired(parseDate(value));
	    } else if (name.equals("ratingcount")) {
		getCurrentParsing().setRatingCount(Integer.valueOf(value));
	    } else if (name.equals("combined_season")) {
		getCurrentParsing().setSeasonNumber(Integer.valueOf(value));
	    } else if (name.equals("combined_episodenumber")) {
		getCurrentParsing().setSeasonEpisodeNumber(Integer.valueOf(value));
	    } else if (name.equals("filename")) {
		getCurrentParsing().setUrlImage(Constants.BANNER_URL + value);
	    } else if (name.equals("lastupdated")) {
		getCurrentParsing().setLastUpdate(Long.valueOf(value));
	    } else {
		Log.e(TAG, "'" + name + "' - tag not recognized: " + value);
	    }//

	} catch (Exception e) {
	    Log.e(TAG, e.getLocalizedMessage(), e);
	}
    }
    
    
    
}
