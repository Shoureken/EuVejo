package com.shoureken.euvejo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.shoureken.euvejo.R;

import de.akquinet.android.androlog.Log;

public class ActivityMain extends AbstractActivity implements OnClickListener {

    private static final String TAG = ActivityMain.class.getSimpleName();

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
	btSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
	switch (v.getId()) {
	case R.id.buttonSearch:
	    getMainHandler().post(new Runnable() {
		public void run() {
		    Intent intent = new Intent();
		    intent.setClass(getApplicationContext(), ActivitySearching.class);
		    startActivity(intent);
		}
	    });
	    break;
	default:
	    break;
	}
    }
}
