package com.shoureken.euvejo.test;

import java.util.Arrays;
import java.util.List;

import android.test.ActivityInstrumentationTestCase2;

import com.shoureken.euvejo.activity.MainActivity;
import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.data.request.Request;
import com.shoureken.euvejo.data.request.RequestListener;

import de.akquinet.android.androlog.Log;

public class RequestTest extends ActivityInstrumentationTestCase2<MainActivity> implements RequestListener<Serie>{
    
    private static final String TAG = RequestTest.class.getSimpleName();

    public RequestTest() {
        super(MainActivity.class); 
    }
    
    @Override
    protected void setUp() throws Exception {
	super.setUp();
	Log.init();
    }

    @Override
    protected void tearDown() throws Exception {
	getActivity().finish();
	super.tearDown();
    }



    public void testActivity() throws InterruptedException {
	Thread.sleep(4000);
        @SuppressWarnings("unused")
	MainActivity activity = getActivity();
        
        Request<Serie> request = Request.getRequest(Serie.class, true, this, 175001, "pt");
        request.execute();
        
        Thread.sleep(10000);
    }

    @Override
    public void onRequestComplete(List<Serie> parsedList) {
	Log.v(TAG, "onRequestComplete -> parsedList: " + Arrays.toString(parsedList.toArray()));
    }

    @Override
    public void onRequestException(Exception e) {
    }

}
