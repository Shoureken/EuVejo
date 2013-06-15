package com.shoureken.euvejo.activity;

import android.os.Bundle;

import com.shoureken.euvejo.R;

import de.akquinet.android.androlog.Log;

public class ActivityConfig extends AbstractActivity {
    
    private static final String TAG = ActivityConfig.class.getSimpleName();

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializes the logging
        Log.init();

        // Log a message (only on dev platform)
        Log.i(TAG, "onCreate");

        setContentView(R.layout.activity_config);
    }

}

