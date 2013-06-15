package com.shoureken.euvejo.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.shoureken.euvejo.R;
import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.data.request.Request;
import com.shoureken.euvejo.data.request.RequestListener;

import de.akquinet.android.androlog.Log;

public class ActivitySearching extends AbstractActivity implements OnClickListener, RequestListener<Serie> {

    private EditText editText = null;
    private static final String TAG = ActivitySearching.class.getSimpleName();
    // private SeriesAdapter listViewAdapterSeies;

    private SeriesAdapter seriesAdapter;

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

	setContentView(R.layout.activity_searching);
	editText = (EditText) findViewById(R.id.edit_text_search);
	((ImageButton) findViewById(R.id.buttonSearch)).setOnClickListener(this);
	seriesAdapter = new SeriesAdapter(getApplicationContext(), new ArrayList<Serie>());
	ListView listView = (ListView) findViewById(R.id.list_view_series);
	listView.setAdapter(seriesAdapter);
	listView.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Serie serie = seriesAdapter.getItem(position);
		if (serie != null) {
		    Intent intent = new Intent();
		    intent.putExtra("serie", serie);
		    intent.setClass(getApplicationContext(), ActivitySeriesDetail.class);
		    startActivity(intent);
		}
	    }
	});
    }

    @Override
    public void onClick(View v) {
	switch (v.getId()) {
	case R.id.buttonSearch:
	    Log.e(TAG, "buttonSearch click");
	    if (editText != null) {
		final String name = editText.getText().toString();
		final Request<Serie> request = Request.getRequest(Serie.class, false, this, name, "en");
		request.execute();
	    }
	    break;
	default:
	    break;
	}
    }

    @Override
    public void onRequestComplete(final List<Serie> parsedList) {
	Log.d(TAG, "onRequestComplete: " + Arrays.toString(parsedList.toArray()));
	getMainHandler().post(new Runnable() {
	    public void run() {
		seriesAdapter.setList(parsedList);
	    }
	});
    }

    private class SeriesAdapter extends ArrayAdapter<Serie> implements Serializable {
	private static final long serialVersionUID = -8181118920599942279L;
	final Context context;

	public SeriesAdapter(Context context, List<Serie> list) {
	    super(context, R.layout.rowlayout_message, list);
	    this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	    Serie serie = getItem(position);
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.rowlayout_message, parent, false);
	    TextView tvName = (TextView) rowView.findViewById(R.id.text_name);
	    if (tvName != null) {
		tvName.setText(serie.getName());
	    }
	    return rowView;
	}

	public void setList(List<Serie> newList) {
	    this.clear();
	    this.addAll(newList);
	}
    }
}
