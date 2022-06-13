package com.recipes.app;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class Ads {
	static void loadAds(AdView ads){
		/** 
		* this for testing only
		* when you launch this app make sure that this code are removed or cover with comment tag.
		**/
		AdRequest adRequest = new AdRequest();
		adRequest.addTestDevice(AdRequest.TEST_EMULATOR);
		adRequest.addTestDevice("DEVICE_ID");
		ads.loadAd(adRequest);
		
		/**
		 * this configuration is for final apk file. don't forget to remove comment tag to make it work.
		 */
		//ads.loadAd(new AdRequest());
	}
}
