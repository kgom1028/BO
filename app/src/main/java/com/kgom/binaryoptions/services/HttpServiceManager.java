package com.kgom.binaryoptions.services;
import android.util.Log;

import com.kgom.binaryoptions.doc.Constants;
import com.kgom.binaryoptions.utils.HttpUtil;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.List;

/**
 * Created by KJS on 9/6/2016.
 */
public class HttpServiceManager {

    static HttpServiceManager _instance;

    public static HttpServiceManager getInstance() {
        if (_instance == null)
            _instance = new HttpServiceManager();
        return _instance;
    }

    public void registerGCMId(String gcm_id, final ServiceListener listener )
    {
        RequestParams param  = new RequestParams();
        param.put("gcm_id",gcm_id);
        HttpUtil.post(Constants.register_gcm_url, param, new AsyncHttpResponseHandler(){
            public void onFailure(Throwable paramThrowable) {
                Log.e("GoogleMap","Http request failure!");
                listener.OnFaild();
            }

            public void onFinish() {
                Log.e("GoogleMap","Http request finish!");
                listener.OnFinished();
            }

            public void onSuccess(String paramString) {  //that is return when success..
                    listener.OnSuccess("success");
            }

        });
    }

}
