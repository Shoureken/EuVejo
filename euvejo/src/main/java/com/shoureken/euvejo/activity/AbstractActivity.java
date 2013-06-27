package com.shoureken.euvejo.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.widget.Toast;

import com.shoureken.euvejo.R;

import de.akquinet.android.androlog.Log;

public class AbstractActivity extends Activity {

    private static final String TAG = AbstractActivity.class.getSimpleName();
    private static Handler handler;
    private ProgressDialog progressDialog;

    protected Handler getMainHandler() {
	if (handler == null) {
	    handler = new Handler();
	}
	return handler;
    }

    public void showAlertWait() {
	hideAlertWait();
	Log.d(TAG, "showAlertWait");
	progressDialog = new ProgressDialog(this);
	progressDialog.setMessage(getString(R.string.alert_wait_message));
	progressDialog.setCancelable(false);
	progressDialog.show();
	getMainHandler().postDelayed(new Runnable() {
	    public void run() {
		AbstractActivity.this.hideAlertWait("by delay");
	    }
	}, 30000);
    }

    public void hideAlertWait(String by) {
	try {
	    if (progressDialog != null && progressDialog.isShowing()) {
		Log.d(TAG, "hideAlertWait " + (by != null ? by : ""));
		progressDialog.dismiss();
		if (by != null && by.contains("by delay")) {
		    Toast.makeText(this, getString(R.string.slow_conection), Toast.LENGTH_LONG).show();
		}
	    }
	} catch (Exception e) {
	    Log.e(TAG, "Could not remove hideAlertWait", e);
	}
    }

    public void hideAlertWait() {
	hideAlertWait(null);
    }

    protected void showToastException(final Exception exception) {
	getMainHandler().post(new Runnable() {
	    public void run() {
		Toast.makeText(getApplicationContext(),
			exception.getClass().getSimpleName() + " - " + exception.getLocalizedMessage(),
			Toast.LENGTH_SHORT).show();
	    }
	});
    }

}
