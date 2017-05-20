package com.kgom.binaryoptions.services;

/**
 * Created by KJS on 9/6/2016.
 */
public interface ServiceListener {
    public void OnSuccess(Object response);

    public void OnFaild();

    public void OnFinished();
}
