package com.example.nicefacev2;

import com.example.nicefacev2.MainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void startGame(View view) { 
		Intent mainIntent = new Intent(MainActivity.this, StartGameActivity.class); 
		MainActivity.this.startActivity(mainIntent); 
		MainActivity.this.finish();
	}
	
	public void quitGame(View view) { 
		finish(); 
		System.exit(0);
	}

}
