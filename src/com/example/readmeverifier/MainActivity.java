package com.example.readmeverifier;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

import org.nexage.sourcekit.vast.VASTPlayer;

public class MainActivity extends Activity {

    protected static final String TAG = "test";
	private VASTPlayer newPlayer = new VASTPlayer(this,
			new VASTPlayer.VASTPlayerListener() {
			@Override
			public void vastReady() {
				Log.i(TAG, "VAST Document is ready and we can play it now");
				newPlayer.play();
			}

			@Override
			public void vastError(int error) {
				Log.e(TAG, "Unable to play VAST Document (error code: " + error + ")");
			}
		}
	);
    

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
               
 //   		newPlayer.loadVideoWithUrl("ssml");
   		newPlayer.loadVideoWithUrl("http://files.nexage.com.s3.amazonaws.com/testads/SDK/vast/mmk/vast_inline_linear.xml");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	
}
