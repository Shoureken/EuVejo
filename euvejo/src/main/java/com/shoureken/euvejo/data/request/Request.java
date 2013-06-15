package com.shoureken.euvejo.data.request;

import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.os.AsyncTask;
import android.util.Log;

import com.shoureken.euvejo.data.Entity;
import com.shoureken.euvejo.data.parser.AbstractParser;
import com.shoureken.euvejo.data.parser.ParserFactory;
import com.shoureken.euvejo.util.Constants;

public class Request<T extends Entity> {

    private static final String TAG = Request.class.getSimpleName();
    private final URL urlRequest;
    private final RequestListener<T> listener;
    private final AbstractParser<T> parser;

    @SuppressWarnings("unchecked")
    public Request(Class<T> clazz, boolean queryForDetails, RequestListener<T> listener, Object... args) {
	this.listener = listener;
	this.parser = ParserFactory.getParser(clazz, queryForDetails);
	this.urlRequest = UrlFactory.getUrl(clazz, queryForDetails, args);
    }

    public void execute() {
	Log.e(TAG, "Executin Request url = "+urlRequest.toString());
	new AsyncTask<Void, Void, List<T>>() {
	    protected void onPostExecute(List<T> result) {
		listener.onRequestComplete(result);
	    }

	    protected List<T> doInBackground(Void... params) {
		try {
		    SAXParserFactory spf = SAXParserFactory.newInstance();
		    SAXParser sp = spf.newSAXParser();
		    XMLReader xr = sp.getXMLReader();
		    xr.setContentHandler(parser);
		    xr.parse(new InputSource(urlRequest.openStream()));
		    return parser.getListParsed();
		} catch (Exception e) {
		    if (Constants.LOG_ENABLED)
			Log.e(TAG, e.getLocalizedMessage(), e);
		    return null;
		}
	    }
	}.execute();
    }
    
    public static <T extends Entity> Request<T> getRequest(Class<T> clazz, boolean queryForDetails, RequestListener<T> listener,
	    Object... args) {
	if (clazz == null || listener == null){
	    return null;
	}
	return new Request<T>(clazz, queryForDetails, listener, args);
    }
}
