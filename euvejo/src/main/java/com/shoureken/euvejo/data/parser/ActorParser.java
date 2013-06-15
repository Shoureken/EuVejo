package com.shoureken.euvejo.data.parser;

import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.util.Log;

import com.shoureken.euvejo.data.Actor;
import com.shoureken.euvejo.util.Constants;

public class ActorParser extends AbstractParser<Actor> {

    private static final String TAG = ActorParser.class.getSimpleName();
    private StringBuilder sb;
    private Actor targetActor;
    private String searchName;

    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) {
	name = name.trim().toLowerCase(Locale.getDefault()); // format the
							     // current element
							     // name
	sb = new StringBuilder(); // Reset the string builder

	if (name.equals("actor")){
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

	    if (targetActor == null) {
		if (name.equals("id")) {
		    getCurrentParsing().setId(Integer.valueOf(sb.toString()));
		    // currentActor.getImage().setId("A" + sb.toString()); //
		    // IDs
		    // are
		    // not
		    // globally
		    // unique.
		    // Prefix
		    // an A
		    // to
		    // indicate
		    // this
		    // ID is
		    // an
		    // actor
		} else if (name.equals("image")) {
		    // currentActor.getImage().setUrl(Constants.BANNER_URL +
		    // sb.toString());
		} else if (name.equals("name")) {
		    getCurrentParsing().setName(sb.toString());
		} else if (name.equals("role")) {
		    getCurrentParsing().setRole(sb.toString());
		} else if (name.equals("actor")) {

		    // if searchName = null we are retrieving all actors - add
		    // the current actor to the ArrayList
		    // else we are searching for a specific actor, if we've
		    // found him/her, set the targetActor accordingly
		    if (searchName == null) {
			getListParsed().add(getCurrentParsing());
		    } else if (getCurrentParsing().getName().equals(searchName)) {
			targetActor = getCurrentParsing();
		    }
		}
	    }

	} catch (Exception e) {
	    if (Constants.LOG_ENABLED)
		Log.e(TAG, "Error:" + e.toString());
	}
    }

}
