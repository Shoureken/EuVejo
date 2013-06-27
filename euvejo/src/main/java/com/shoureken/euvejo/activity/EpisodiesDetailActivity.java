package com.shoureken.euvejo.activity;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;

import com.shoureken.euvejo.data.Episode;
import com.shoureken.euvejo.data.request.RequestListener;

import de.akquinet.android.androlog.Log;

public class EpisodiesDetailActivity extends AbstractActivity implements RequestListener<Episode> {

    private static final String TAG = EpisodiesDetailActivity.class.getSimpleName();
   // private Episode episode;

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
	
	if (getIntent() == null){
	    finish();
	}
	if (getIntent().getExtras() == null){
	    finish();
	}
	if (getIntent().getExtras().getSerializable("serie") == null){
	    finish();
	}
	
//	setContentView(R.layout.activity_episodes);
//	episodesAdapter = new EpisodesAdapter(getApplicationContext(), new ArrayList<Episode>());
//	final ListView listView = (ListView) findViewById(R.id.list_view_episodes);
//	listView.setAdapter(episodesAdapter);
//	
//	Serie basicSerie = (Serie) getIntent().getExtras().getSerializable("serie");
//	final Request<Episode> request = Request.getRequest(Episode.class, false, this, basicSerie.getId());
//	request.execute(this);
    }

    @Override
    public void onRequestComplete(final List<Episode> parsedList) {
	Log.d(TAG, "onRequestComplete: " + Arrays.toString(parsedList.toArray()));
    }

    @Override
    public void onRequestException(Exception e) {
	finish();
    }
    
    public void callUpdateEpisode(){
	getMainHandler().post(new Runnable() {
	    public void run() {
		//episodesAdapter.setList(parsedList);
	    }
	});
    }
    
    public void updateEpisode(){
	
    }
}
