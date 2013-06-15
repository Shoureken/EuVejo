package com.shoureken.euvejo.activity;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;

import com.shoureken.euvejo.R;
import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.data.request.Request;
import com.shoureken.euvejo.data.request.RequestListener;

import de.akquinet.android.androlog.Log;

public class ActivitySeriesDetail extends AbstractActivity implements RequestListener<Serie> {

    private static final String TAG = ActivitySeriesDetail.class.getSimpleName();
    private Serie serie;

    /**
     * Called when the activity is first created.
     * 
     * @param savedInstanceState
     *            If the activity is being re-initialized after previously being
     *            shut down then this Bundle contains the data it most recently
     *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
     *            is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	// Initializes the logging
	Log.init();

	// Log a message (only on dev platform)
	Log.i(TAG, "onCreate");

	setContentView(R.layout.activity_series_detail);
	
	if (getIntent() == null){
	    finish();
	}
	if (getIntent().getExtras() == null){
	    finish();
	}
	if (getIntent().getExtras().getSerializable("serie") == null){
	    finish();
	}
	Serie basicaSerie = (Serie) getIntent().getExtras().getSerializable("serie");
	final Request<Serie> request = Request.getRequest(Serie.class, true, this, basicaSerie.getId(), "en");
	request.execute();
    }

    @Override
    public void onRequestComplete(List<Serie> parsedList) {
	Log.e(TAG, "Finish To Load "+Arrays.toString(parsedList.toArray()));
    }

}
