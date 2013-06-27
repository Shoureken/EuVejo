package com.shoureken.euvejo.data.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.util.Log;

import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.util.Constants;

public class SeriesParser extends AbstractParser<Serie> {

    private static final String TAG = SeriesParser.class.getSimpleName();
    private StringBuilder sb;
    private static final List<String> ignore = Arrays.asList("seriesid", "data", "added", "addedby", "networkid",
	    "fanart");

    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) {
	// format the current element name
	name = name.trim().toLowerCase(Locale.getDefault());
	sb = new StringBuilder(); // Reset the string builder

	if (name.equals("series")) { // If this is a new node, create a new
				     // instance
	    this.setCurrentParsing(new Serie());
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
	try {
	    name = name.trim().toLowerCase(Locale.getDefault());
	    final String value = sb.toString();
	    if (value.length() == 0) {
		return;
	    }

	    if (ignore.contains(name)) {
		Log.v(TAG, "Ignoring '" + name + "' -> '" + value + "'");
	    } else if (name.equals("series")) {
		getListParsed().add(getCurrentParsing());
	    } else if (name.equals("id")) {
		getCurrentParsing().setId(Long.valueOf(value));
	    } else if (name.equals("banner")) {
		getCurrentParsing().setBannerUrl(Constants.BANNER_URL + value);
	    } else if (name.equals("poster")) {
		getCurrentParsing().setPosterUrl(Constants.BANNER_URL + value);
	    } else if (name.equals("firstaired")) {
		getCurrentParsing().setFirstAired(parseDate(value));
	    } else if (name.equals("imdb_id")) {
		getCurrentParsing().setIMDB(value);
	    } else if (name.equals("language")) {
		getCurrentParsing().setLanguage(value);
	    } else if (name.equals("seriesname")) {
		getCurrentParsing().setName(value);
	    } else if (name.equals("overview")) {
		getCurrentParsing().setOverview(value);
	    } else if (name.equals("network")) {
		getCurrentParsing().setNetwork(value);
	    } else if (name.equals("zap2it_id")) {
		getCurrentParsing().setZap2it(value);
	    } else if (name.equals("aliasnames")) {
		getCurrentParsing().setAliasNames(value);
	    } else if (name.equals("actors")) {
		getCurrentParsing().setActors(parseList(value));
	    } else if (name.equals("genre")) {
		getCurrentParsing().setGenres(parseList(value));
	    } else if (name.equals("airs_time")) {
		getCurrentParsing().setAirTime(value);
	    } else if (name.equals("status")) {
		getCurrentParsing().setStatus(value);
	    } else if (name.equals("rating")) {
		getCurrentParsing().setRating(value);
	    } else if (name.equals("runtime")) {
		getCurrentParsing().setRuntime(value);
	    } else if (name.equals("airs_dayofweek")) {
		getCurrentParsing().setAirDay(value);
	    } else if (name.equals("ratingcount")) {
		getCurrentParsing().setRatingCount(Integer.valueOf(value));
	    } else if (name.equals("lastupdated")) {
		getCurrentParsing().setLastUpdate(Long.valueOf(value));
	    } else if (name.equals("contentrating")) {
		getCurrentParsing().setContentRating(value);
	    } else {
		Log.e(TAG, "'" + name + "' - tag not recognized: " + value);
	    }

	} catch (Exception e) {
	    Log.e(TAG, e.getLocalizedMessage(), e);
	}
    }
}
