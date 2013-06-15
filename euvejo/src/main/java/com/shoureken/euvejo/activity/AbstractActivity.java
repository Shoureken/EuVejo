package com.shoureken.euvejo.activity;

import android.app.Activity;
import android.os.Handler;

public class AbstractActivity extends Activity {
    
    private static Handler handler;
    
    protected Handler getMainHandler(){
	if (handler == null){
	    handler = new Handler();
	}
	return handler;
    }

}
