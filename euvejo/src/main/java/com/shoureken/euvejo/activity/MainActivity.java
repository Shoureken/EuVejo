package com.shoureken.euvejo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.shoureken.euvejo.R;

import de.akquinet.android.androlog.Log;

public class MainActivity extends AbstractActivity implements OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

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

	setContentView(R.layout.activity_main);

	Button btSearch = (Button) findViewById(R.id.buttonSearch);
	Button btSeries = (Button) findViewById(R.id.buttonSeries);
	Button btSettings = (Button) findViewById(R.id.buttonSettings);
	Button btExit = (Button) findViewById(R.id.buttonExit);
	btSearch.setOnClickListener(this);
	btSeries.setOnClickListener(this);
	btSettings.setOnClickListener(this);
	btExit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
	switch (v.getId()) {
	case R.id.buttonSearch:
	    getMainHandler().post(new Runnable() {
		public void run() {
		    Intent intent = new Intent();
		    intent.setClass(getApplicationContext(), SeriesSearchingActivity.class);
		    startActivity(intent);
		}
	    });
	    break;
	case R.id.buttonSeries:
	    break;
	case R.id.buttonSettings:
	    getMainHandler().post(new Runnable() {
		public void run() {
		    Intent intent = new Intent();
		    intent.setClass(getApplicationContext(), ConfigActivity.class);
		    startActivity(intent);
		}
	    });
	    break;
	case R.id.buttonExit:
	    getMainHandler().post(new Runnable() {
		public void run() {
		    System.exit(0);
		}
	    });
	    break;
	default:
	    break;
	}
    }
}
