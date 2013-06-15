package com.shoureken.euvejo.data.parser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;

import com.shoureken.euvejo.data.Entity;

public abstract class AbstractParser<T extends Entity> extends DefaultHandler {
    
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
    
}
