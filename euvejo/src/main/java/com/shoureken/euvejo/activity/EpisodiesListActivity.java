package com.shoureken.euvejo.activity;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.shoureken.euvejo.R;
import com.shoureken.euvejo.data.Episode;
import com.shoureken.euvejo.data.Serie;
import com.shoureken.euvejo.data.request.Request;
import com.shoureken.euvejo.data.request.RequestListener;

import de.akquinet.android.androlog.Log;

public class EpisodiesListActivity extends AbstractActivity implements RequestListener<Episode> {

    private static final String TAG = EpisodiesListActivity.class.getSimpleName();

    //private EpisodesAdapter episodeAdapter;

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
	
	setContentView(R.layout.activity_episodies_list);
	
	
	/*final ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandable_list_episodies);
	expandableListView.setAdapter(episodeAdapter);
	episodeAdapter = new EpisodesAdapter();*/
	
	Serie basicSerie = (Serie) getIntent().getExtras().getSerializable("serie");
	final Request<Episode> request = Request.getRequest(Episode.class, false, this, basicSerie.getId(), "pt");
	request.execute(this);
    }

    @Override
    public void onRequestComplete(final List<Episode> parsedList) {
	Log.d(TAG, "onRequestComplete: " + Arrays.toString(parsedList.toArray()));
    }
    
    
    private class EpisodesAdapter extends BaseExpandableListAdapter {

	@Override
	public int getGroupCount() {
	    // TODO Auto-generated method stub
	    return 0;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
	    // TODO Auto-generated method stub
	    return 0;
	}

	@Override
	public Object getGroup(int groupPosition) {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public long getGroupId(int groupPosition) {
	    // TODO Auto-generated method stub
	    return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
	    // TODO Auto-generated method stub
	    return 0;
	}

	@Override
	public boolean hasStableIds() {
	    // TODO Auto-generated method stub
	    return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
		ViewGroup parent) {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
	    // TODO Auto-generated method stub
	    return false;
	}

	
	
    }
    
    @Override
    public void onRequestException(Exception e) {
	finish();
    }
}
