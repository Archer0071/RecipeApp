/**
 * Application name : Recipes App
 * Author			: Taufan Erfiyanto
 * Date				: March 2012
 */
package com.recipes.app;

import com.google.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends Activity {
	ProgressBar prgLoading;
    AdView ads;
    
	int progress = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        
        prgLoading = (ProgressBar) findViewById(R.id.prgLoading);
        ads = (AdView) findViewById(R.id.ads);
		prgLoading.setProgress(progress);

		Ads.loadAds(ads);
		
		new Loading().execute();
    }
    
    @Override
	  public void onDestroy() {
  	if (ads != null) {
  	ads.destroy();
  	}
		super.onDestroy();

	}
    
    /** this class is used to handle thread */
    public class Loading extends AsyncTask<Void, Void, Void>{
    	
    	@Override
		 protected void onPreExecute() {
		  // TODO Auto-generated method stub
    		
    	}
    	
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			while(progress < 100){
				try {
					Thread.sleep(1000);
					progress += 30;
					prgLoading.setProgress(progress);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return null;
		}
    	

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			Intent i = new Intent(SplashScreen.this, RecipesList.class);
			startActivity(i);
		}
    }
}