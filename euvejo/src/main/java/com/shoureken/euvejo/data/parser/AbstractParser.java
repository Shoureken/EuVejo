package com.shoureken.euvejo.data.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;

import com.shoureken.euvejo.data.Entity;

import de.akquinet.android.androlog.Log;

public abstract class AbstractParser<T extends Entity> extends DefaultHandler {
    
    private static final String TAG = AbstractParser.class.getSimpleName();
    private T currentParsing;
    private List<T> parsedList = new ArrayList<T>();

    public List<T> getListParsed(){
	return parsedList;
    }
    
    protected T getCurrentParsing(){
	return currentParsing;
    }
    
    protected void setCurrentParsing(T currentParsing){
	this.currentParsing = currentParsing;
    }
    
    protected List<String> parseList(String list) {
	List<String> listString = Arrays.asList(list.split("\\|"));
	listString = listString.subList(1, listString.size());
	return listString;
    }
    
    protected Date parseDate(String date) {
	try {
	    return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	} catch (ParseException e) {
	    Log.e(TAG, e.getLocalizedMessage(), e);
	}
	return null;
    }
}
