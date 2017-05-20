package com.kgom.binaryoptions.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.kgom.binaryoptions.R;

import java.io.IOException;

/**
 * Created by KJS on 1/7/2017.
 */
public class IntroVideoSurface extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = "INTRO_SF_VIDEO_CALLBACK";
    private MediaPlayer mp;
    private static Boolean isPlaying = false;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IntroVideoSurface(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public IntroVideoSurface(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public IntroVideoSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public IntroVideoSurface(Context context) {
        super(context);
        init();
    }

    private void init (){
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (mp != null) {
            if (mp.isPlaying()) {
                mp.release();
                mp = null;
            }
        }
        mp = new MediaPlayer();
         AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.platform__v4);

        try {
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
            mp.prepare();

        } catch (Exception e) {
            e.printStackTrace();
        }
        int videoWidth = mp.getVideoWidth();
        int videoHeight = mp.getVideoHeight();
        int screenHeight = getHeight();
        android.view.ViewGroup.LayoutParams lp = getLayoutParams();
        lp.height = screenHeight;
        lp.width = (int) (((float)videoWidth / (float)videoHeight) * (float)screenHeight);

        setLayoutParams(lp);
        mp.setDisplay(getHolder());
        mp.setLooping(true);
        mp.start();

    }
    public void stopVideo()
    {
       // mp.stop();
    }

    public void startVideo()
    {

       // mp.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mp.stop();
    }

}