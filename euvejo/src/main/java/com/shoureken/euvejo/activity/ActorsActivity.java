package com.shoureken.euvejo.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.shoureken.euvejo.R;
import com.shoureken.euvejo.data.Actor;
import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.data.request.Request;
import com.shoureken.euvejo.data.request.RequestListener;

import de.akquinet.android.androlog.Log;

public class ActorsActivity extends AbstractActivity implements RequestListener<Actor> {

    private static final String TAG = ActorsActivity.class.getSimpleName();

    private ActorsAdapter actorsAdapter;

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
	if (getIntent().getExtras().getSerializable("serie") == null){
	    finish();
	}
	
	setContentView(R.layout.activity_actors);
	actorsAdapter = new ActorsAdapter(getApplicationContext(), new ArrayList<Actor>());
	final ListView listView = (ListView) findViewById(R.id.list_view_actors);
	listView.setAdapter(actorsAdapter);
	listView.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Actor actor = actorsAdapter.getItem(position);
		if (actor != null) {
		    Intent intent = new Intent();
		    intent.putExtra("urlImage", actor.getUrlImage());
		    intent.setClass(getApplicationContext(), ImageViewActivity.class);
		    startActivity(intent);
		}
	    }
	});
	
	Serie basicSerie = (Serie) getIntent().getExtras().getSerializable("serie");
	final Request<Actor> request = Request.getRequest(Actor.class, false, this, basicSerie.getId());
	request.execute(this);
    }

    @Override
    public void onRequestComplete(final List<Actor> parsedList) {
	Log.d(TAG, "onRequestComplete: " + Arrays.toString(parsedList.toArray()));
	getMainHandler().post(new Runnable() {
	    public void run() {
		actorsAdapter.setList(parsedList);
	    }
	});
    }

    private class ActorsAdapter extends ArrayAdapter<Actor> implements Serializable {
	private static final long serialVersionUID = 1646713325096439501L;
	final Context context;

	public ActorsAdapter(Context context, List<Actor> list) {
	    super(context, R.layout.rowlayout_actor, list);
	    this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	    Actor actor = getItem(position);
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.rowlayout_actor, parent, false);
	    final TextView actorRole = (TextView) rowView.findViewById(R.id.text_role);
	    final TextView actorName = (TextView) rowView.findViewById(R.id.text_name);
	    if (actorName != null) {
		actorName.setText(actor.getName());
	    }
	    if (actorRole != null) {
		actorRole.setText(actor.getRole() == null ? "" : actor.getRole());
	    }
	    return rowView;
	}

	public void setList(List<Actor> newList) {
	    this.clear();
	    for (Iterator<Actor> iterator = newList.iterator(); iterator.hasNext();) {
		Actor actor = iterator.next();
		this.add(actor);
	    }
	}
    }

    @Override
    public void onRequestException(Exception e) {
	finish();
    }
}
