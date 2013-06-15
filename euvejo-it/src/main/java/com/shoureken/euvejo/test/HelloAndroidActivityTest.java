package com.shoureken.euvejo.test;

import android.test.ActivityInstrumentationTestCase2;

import com.shoureken.euvejo.activity.ActivityMain;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<ActivityMain> {

    public HelloAndroidActivityTest() {
        super(ActivityMain.class); 
    }

    public void testActivity() {
        ActivityMain activity = getActivity();
        assertNotNull(activity);
    }
}

