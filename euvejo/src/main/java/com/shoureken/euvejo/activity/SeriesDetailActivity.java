package com.shoureken.euvejo.activity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.shoureken.euvejo.R;
import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.data.request.Request;
import com.shoureken.euvejo.data.request.RequestListener;

import de.akquinet.android.androlog.Log;

public class SeriesDetailActivity extends AbstractActivity implements OnClickListener, RequestListener<Serie> {

    private static final String TAG = SeriesDetailActivity.class.getSimpleName();
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

	if (getIntent() == null) {
	    finish();
	}
	if (getIntent().getExtras() == null) {
	    finish();
	}
	if (getIntent().getExtras().getSerializable("serie") == null) {
	    finish();
	}

	setContentView(R.layout.activity_series_detail);
	setButtonActions();

	Serie basicSerie = (Serie) getIntent().getExtras().getSerializable("serie");
	final Request<Serie> request = Request.getRequest(Serie.class, true, this, basicSerie.getId(), "pt");
	request.execute(this);
    }

    private void setButtonActions() {
	final Button btActors = (Button) findViewById(R.id.buttonActor);
	final Button btPoster = (Button) findViewById(R.id.buttonPoster);
	final Button btBanner = (Button) findViewById(R.id.buttonBanner);
	final Button btEpisodies = (Button) findViewById(R.id.buttonEpisodies);

	btActors.setOnClickListener(this);
	btBanner.setOnClickListener(this);
	btPoster.setOnClickListener(this);
	btEpisodies.setOnClickListener(this);
    }

    @Override
    public void onRequestComplete(List<Serie> parsedList) {
	Log.e(TAG, "Finish To Load " + Arrays.toString(parsedList.toArray()));
	if (parsedList.size() > 0) {
	    serie = parsedList.get(0);
	    getMainHandler().post(new Runnable() {
		public void run() {
		    hideAlertWait();
		    updateFields();
		}
	    });
	} else {
	    finish();
	}
    }

    private void updateFields() {
	final TextView textViewName = (TextView) findViewById(R.id.serie_detail_name_value);
	final TextView textViewAirDayTime = (TextView) findViewById(R.id.serie_detail_air_day_time_value);
	final TextView textViewFirstAired = (TextView) findViewById(R.id.serie_detail_first_aired_value);
	final TextView textViewGenres = (TextView) findViewById(R.id.serie_detail_genres_value);
	final TextView textViewOverview = (TextView) findViewById(R.id.serie_detail_overview_value);
	final TextView textViewRating = (TextView) findViewById(R.id.serie_detail_rating_value);

	textViewName.setText(serie.getName());
	textViewAirDayTime.setText(serie.getAirDay() + " - " + serie.getAirTime());
	textViewFirstAired.setText(new SimpleDateFormat("dd-MM-yyyy").format(serie.getFirstAired()));
	textViewGenres.setText(Arrays.toString(serie.getGenres().toArray()));
	textViewOverview.setText(serie.getOverview());
	textViewRating.setText(serie.getRating() + " / " + serie.getRatingCount());

    }

    @Override
    public void onRequestException(Exception e) {
	finish();
    }

    @Override
    public void onClick(View v) {
	final Intent intent = new Intent();
	intent.putExtra("serie", serie);
	switch (v.getId()) {
	case R.id.buttonActor:
	    intent.setClass(getApplicationContext(), ActorsActivity.class);
	    break;
	case R.id.buttonEpisodies:
	    intent.setClass(getApplicationContext(), EpisodiesListActivity.class);
	    break;
	case R.id.buttonPoster:
	    intent.putExtra("urlImage", serie.getPosterUrl());
	    intent.setClass(getApplicationContext(), ImageViewActivity.class);
	    break;
	case R.id.buttonBanner:
	    intent.putExtra("urlImage", serie.getBannerUrl());
	    intent.setClass(getApplicationContext(), ImageViewActivity.class);
	    break;	    
	default:
	    break;
	}
	startActivity(intent);
    }

}
