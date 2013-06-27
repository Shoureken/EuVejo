package com.shoureken.euvejo.test;

import android.test.ActivityInstrumentationTestCase2;

import com.shoureken.euvejo.activity.MainActivity;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public HelloAndroidActivityTest() {
        super(MainActivity.class); 
    }

    public void testActivity() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }
}

