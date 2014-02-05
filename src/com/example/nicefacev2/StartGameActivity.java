package com.example.nicefacev2;

import client.Client;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class StartGameActivity extends Activity {
	
	Client c = new Client("b06da00689e96bb8c8eecfcbbbbe4778", "PVWeWimndNqxMS5kHLXDvTAZzRdSUKbM"); 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_game);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_game, menu);
		return true;
	}

}
