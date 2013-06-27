package com.shoureken.euvejo.data.request;

import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.os.AsyncTask;
import android.util.Log;

import com.shoureken.euvejo.activity.AbstractActivity;
import com.shoureken.euvejo.data.Entity;
import com.shoureken.euvejo.data.parser.AbstractParser;

public class Request<T extends Entity> {

    private static final String TAG = Request.class.getSimpleName();
    private final URL urlRequest;
    private final RequestListener<T> listener;
    private final AbstractParser<T> parser;
    private AbstractActivity activityWaiting;

    @SuppressWarnings("unchecked")
    private Request(Class<T> clazz, boolean queryForDetails, RequestListener<T> listener, Object... args) {
	this.listener = listener;
	this.parser = ParserFactory.getParser(clazz);
	this.urlRequest = UrlFactory.getUrl(clazz, queryForDetails, args);
    }

    public void execute() {
	Log.v(TAG, "Executing Request url = " + urlRequest.toString());
	new AsyncTask<Void, Void, List<T>>() {
	    private Exception exception = null;
	    
	    protected void onPostExecute(List<T> result) {
		if (activityWaiting != null) {
		    activityWaiting.hideAlertWait();
		}
		if (exception == null){
		    listener.onRequestComplete(result);
		} else {
		    listener.onRequestException(exception);
		}
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
		    Log.e(TAG, e.getLocalizedMessage(), e);
		    exception = e;
		    return null;
		}
	    }
	}.execute();
    }

    public void execute(AbstractActivity activity) {
	if (activity != null) {
	    activityWaiting = activity;
	    activityWaiting.showAlertWait();
	}
	execute();
    }

    public static <T extends Entity> Request<T> getRequest(Class<T> clazz, boolean queryForDetails,
	    RequestListener<T> listener, Object... args) {
	if (clazz == null || listener == null) {
	    return null;
	}
	return new Request<T>(clazz, queryForDetails, listener, args);
    }
}
