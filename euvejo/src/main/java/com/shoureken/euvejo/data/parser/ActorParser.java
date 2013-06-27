package com.shoureken.euvejo.data.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.util.Log;

import com.shoureken.euvejo.data.Actor;
import com.shoureken.euvejo.util.Constants;

public class ActorParser extends AbstractParser<Actor> {

    private static final String TAG = ActorParser.class.getSimpleName();
    private StringBuilder sb;
    private static final List<String> ignore = Arrays.asList("sortorder", "actors");

    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) {
	name = name.trim().toLowerCase(Locale.getDefault()); // format the
							     // current element
							     // name
	sb = new StringBuilder(); // Reset the string builder

	if (name.equals("actor")) {
	    this.setCurrentParsing(new Actor());
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
		// Log.v(TAG, "Ignoring '" + name + "' -> '" + value + "'");
	    } else if (name.equals("id")) {
		getCurrentParsing().setId(Integer.valueOf(value));
	    } else if (name.equals("image")) {
		getCurrentParsing().setUrlImage(Constants.BANNER_URL + value);
	    } else if (name.equals("name")) {
		getCurrentParsing().setName(value);
	    } else if (name.equals("role")) {
		getCurrentParsing().setRole(value);
	    } else if (name.equals("actor")) {
		getListParsed().add(getCurrentParsing());
	    } else {
		Log.e(TAG, "'" + name + "' - tag not recognized: " + value);
	    }
	} catch (Exception e) {
	    Log.e(TAG, "Error:" + e.toString());
	}
    }

}
