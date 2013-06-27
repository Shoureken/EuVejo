package com.shoureken.euvejo.activity;

import android.os.Bundle;

import com.raptureinvenice.webimageview.image.WebImageView;
import com.shoureken.euvejo.R;

import de.akquinet.android.androlog.Log;

public class ImageViewActivity extends AbstractActivity {

    private static final String TAG = ImageViewActivity.class.getSimpleName();
    //private AQuery aq;


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
	if (getIntent().getExtras().getString("urlImage") == null){
	    finish();
	}
	
	final String urlImage = getIntent().getExtras().getString("urlImage");
	
	setContentView(R.layout.activity_image_view);
	
	WebImageView myImage = (WebImageView)findViewById(R.id.my_img);
	myImage.setImageWithURL(this, urlImage);
    }
    
    protected int getContainer() {
	return R.layout.activity_image_view;
    }
}
