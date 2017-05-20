package com.kgom.binaryoptions.services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by KJS on 9/10/2016.
 */
public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";
    private static final String FRIENDLY_ENGAGE_TOPIC = "friendly_engage";

    /**
     * The Application's current Instance ID token is no longer valid
     * and thus a new one must be requested.
     */
    @Override
    public void onTokenRefresh() {
        // If you need to handle the generation of a token, initially or
        // after a refresh this is where you should do that.
        String token = FirebaseInstanceId.getInstance().getToken();
        RegisterTokenListener listener = new RegisterTokenListener();
        Log.d(TAG, "FCM Token: " + token);
        HttpServiceManager.getInstance().registerGCMId(token,listener);
        // Once a token is generated, we subscribe to topic.
        FirebaseMessaging.getInstance()
                .subscribeToTopic(FRIENDLY_ENGAGE_TOPIC);
    }
    class RegisterTokenListener implements  ServiceListener
    {

        @Override
        public void OnSuccess(Object response) {

        }

        @Override
        public void OnFaild() {

        }

        @Override
        public void OnFinished() {

        }
    }
}