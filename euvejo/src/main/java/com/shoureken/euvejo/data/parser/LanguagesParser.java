package com.shoureken.euvejo.data.parser;

import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.util.Log;

import com.shoureken.euvejo.data.Language;

public class LanguagesParser extends AbstractParser<Language> {

    private static final String TAG = LanguagesParser.class.getSimpleName();
    private StringBuilder sb;

    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) {
	// format the current element name
	name = name.trim().toLowerCase(Locale.getDefault());
	sb = new StringBuilder(); // Reset the string builder

	if (name.equals("language")) { // If this is a new node, create a new
				       // instance
	    this.setCurrentParsing(new Language());
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

	    if (name.equals("languages") || name.equals("data")) {
		// Just Ignore
	    } else if (name.equals("language")) {
		getListParsed().add(getCurrentParsing());
	    } else if (name.equals("id")) {
		getCurrentParsing().setId(Integer.valueOf(sb.toString()));
	    } else if (name.equals("name")) {
		getCurrentParsing().setName(sb.toString());
	    } else if (name.equals("abbreviation")) {
		getCurrentParsing().setAbbreviation(sb.toString());
	    } else {
		Log.e(TAG, "'" + name + "' - tag not recognized: " + sb.toString());
	    }

	} catch (Exception e) {
	    Log.e(TAG, e.getLocalizedMessage(), e);
	}
    }

}
