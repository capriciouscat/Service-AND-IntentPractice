package com.example.startservicebyintent;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;
import android.util.Log;

public class MP3PlayService extends Service implements OnCompletionListener{
    private static final String TAG = "MP3PlayService";
    private MediaPlayer mp = null;
    
    @Override
    public IBinder onBind(Intent intent){
    	return null;
    }
    
    @Override
    public void onCreate(){
        Log.e(TAG, "onCreate() called.");
        
        mp = MediaPlayer.create(this, R.raw.music);
        mp.setOnCompletionListener(this);
        super.onCreate();
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
    	Log.e(TAG, "onStartCommand() called.");
    	
    	if(intent.getBooleanExtra("PAUSE", false)){
    		pauseMusic();
    	} else {
    		startMusic();
    	}
    	
    	return START_REDELIVER_INTENT; //再起動する
    	//return START_NOT_STICKY; //完全停止する
    }
    
    @Override
    public void onCompletion(MediaPlayer mp){
    	Log.e(TAG, "onCompletion() called.");
    	stopSelf();
    }
    
    @Override
    public void onDestroy(){
    	Log.e(TAG, "onDestroy() called.");
    	
    	pauseMusic();
    	if(mp != null){
    		mp.release();
    		mp = null;
    	}
    	
    	super.onDestroy();
    }
    
    private void startMusic(){
    	if(!mp.isPlaying()){
    		mp.start();
    	}
    }
    
    private void pauseMusic(){
    	if(mp.isPlaying()){
    		mp.pause();
    	}
    }

}




















