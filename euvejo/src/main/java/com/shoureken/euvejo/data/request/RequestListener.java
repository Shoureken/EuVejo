package com.shoureken.euvejo.data.request;

import java.util.List;

import com.shoureken.euvejo.data.Entity;

public interface RequestListener<T extends Entity> {
    
    public void onRequestComplete(List<T> parsedList);
    
    public void onRequestException(Exception exception);

}
