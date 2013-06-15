package com.shoureken.euvejo.data.parser;

import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.util.Log;

import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.util.Constants;

public class SeriesParser  extends AbstractParser<Serie> {
    
    private static final String TAG = SeriesParser.class.getSimpleName();
    private StringBuilder sb;
    
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

	    if (name.equals("series")) {
		getListParsed().add(getCurrentParsing());
	    } else if (name.equals("seriesid")) {
		getCurrentParsing().setId(Long.valueOf(sb.toString()));
	    } else if (name.equals("banner")) {
		// getCurrentParsing().getBanner().setUrl(sb.toString());
	    } else if (name.equals("firstaired")) {
		getCurrentParsing().setFirstAired(sb.toString());
	    } else if (name.equals("imdb_id")) {
		getCurrentParsing().setIMDB(sb.toString());
	    } else if (name.equals("language")) {
		getCurrentParsing().setLanguage(sb.toString());
	    } else if (name.equals("seriesname")) {
		getCurrentParsing().setName(sb.toString());
	    } else if (name.equals("overview")) {
		getCurrentParsing().setOverview(sb.toString());
	    } else if (name.equals("network")) {
		getCurrentParsing().setNetwork(sb.toString());
	    } else if (name.equals("zap2it_id")) {
		getCurrentParsing().setZap2it(sb.toString());
	    } else if (name.equals("aliasnames")) {
		getCurrentParsing().setAliasNames(sb.toString());
	    } else if (name.equals("id")) {
		// just ignore
	    } else {
		if (Constants.LOG_ENABLED)
		    Log.d(TAG, "'" + name + "' - tag not recognized: " + sb.toString());
	    }

	} catch (Exception e) {
	    if (Constants.LOG_ENABLED)
		Log.e(TAG, e.getLocalizedMessage(), e);
	}
    }

}
