package com.shoureken.euvejo.data;

import java.util.ArrayList;
import java.util.Iterator;

public class EpisodeList extends ArrayList<Episode> {

    private static final long serialVersionUID = 1L;

    public Episode getNextAired() {
	Episode nextAired = null;
	long nextAiredLong = 0;
	long timeNow = System.currentTimeMillis();

	for (Iterator<Episode> i = this.iterator(); i.hasNext();) {
	    Episode ep = i.next();

	    if (ep.getFirstAired().getTime() > timeNow && (nextAiredLong == 0 || ep.getFirstAired().getTime() < nextAiredLong)) {
		nextAiredLong = ep.getFirstAired().getTime();
		nextAired = ep;
	    }
	}
	return nextAired;
    }

    public Episode getLastAired() {
	Episode lastAired = null;
	long lastAiredLong = 0;
	long timeNow = System.currentTimeMillis();

	for (Iterator<Episode> i = this.iterator(); i.hasNext();) {
	    Episode ep = i.next();

	    if (ep.getFirstAired().getTime() > lastAiredLong && ep.getFirstAired().getTime() < timeNow) {
		lastAiredLong = ep.getFirstAired().getTime();
		lastAired = ep;
	    }
	}
	return lastAired;
    }

    public ArrayList<Integer> getSeasonList() {
	ArrayList<Integer> seasons = new ArrayList<Integer>();

	for (Iterator<Episode> i = this.iterator(); i.hasNext();) {
	    int seasonNo = i.next().getSeasonNumber();

	    if (!seasons.contains(seasonNo))
		seasons.add(seasonNo);
	}
	return seasons;
    }

    public int getNumberOfEpisodesInSeason(int seasonNumber) {
	int count = 0;

	for (Iterator<Episode> i = this.iterator(); i.hasNext();) {
	    if (i.next().getSeasonNumber() == seasonNumber)
		count++;
	}
	return count;
    }

    public Episode getEpisode(int seasonNumber, int episodeNumber) {
	for (Iterator<Episode> i = this.iterator(); i.hasNext();) {
	    Episode ep = i.next();
	    if (ep.getSeasonNumber() == seasonNumber && ep.getSeasonEpisodeNumber() == episodeNumber) {
		return ep;
	    }
	}
	return null;
    }
}
